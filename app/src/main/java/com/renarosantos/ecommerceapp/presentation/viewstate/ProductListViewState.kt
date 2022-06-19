package com.renarosantos.ecommerceapp.presentation.viewstate
import com.renarosantos.ecommerceapp.presentation.viewstate.ProductListViewState.Content


sealed class ProductListViewState {
    object Loading : ProductListViewState()
    data class Content(val productList: List<ProductCardViewState>) : ProductListViewState()
    object Error : ProductListViewState()
}

fun Content.updateFavoriteProduct(
    productId: String,
    isFavorite: Boolean
): Content {
    return Content(productList = this.productList.map { viewState ->
        if (viewState.id == productId) {
            viewState.copy(isFavorite = isFavorite)
        } else {
            viewState
        }
    }
    )
}