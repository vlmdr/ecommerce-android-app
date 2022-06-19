package com.renarosantos.ecommerceapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renarosantos.ecommerceapp.business.useCases.AddOrRemoveFromWishlistUseCase
import com.renarosantos.ecommerceapp.business.useCases.IsProductInWishlistUseCase
import com.renarosantos.ecommerceapp.data.repository.ProductRepository
import com.renarosantos.ecommerceapp.data.repository.WishlistRepository
import com.renarosantos.ecommerceapp.presentation.viewstate.ProductCardViewState
import com.renarosantos.ecommerceapp.presentation.viewstate.ProductListViewState
import com.renarosantos.ecommerceapp.presentation.viewstate.updateFavoriteProduct
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val repository: ProductRepository,
    private val wishlistRepository: WishlistRepository,
    private val isProductInWishListUseCase: IsProductInWishlistUseCase,
    private val addOrRemoveFromWishListUseCase: AddOrRemoveFromWishlistUseCase
) : ViewModel() {

    private val _viewState = MutableLiveData<ProductListViewState>()
    val viewState: LiveData<ProductListViewState>
        get() = _viewState


    fun loadProductList() {
        viewModelScope.launch {
            wishlistRepository.addToWishList("4")
            _viewState.postValue(ProductListViewState.Loading)
            // Data call to fetch products
            val productList = repository.getProductList()
            _viewState.postValue(ProductListViewState.Content(
                productList.map {
                    ProductCardViewState(
                        it.id,
                        it.title,
                        it.description,
                        "US $ ${it.price}",
                        it.imageUrl,
                        wishlistRepository.isFavorite(it.id)
                    )
                }
            ))
        }
    }

    fun favoriteIconClicked(productId: String) {
        viewModelScope.launch {
            addOrRemoveFromWishListUseCase.execute(productId)
            val currentViewState = _viewState.value
            (currentViewState as? ProductListViewState.Content)?.let { content ->
                _viewState.postValue(
                    content.updateFavoriteProduct(
                        productId,
                        isProductInWishListUseCase.execute(productId)
                    )
                )
            }
        }
    }
}