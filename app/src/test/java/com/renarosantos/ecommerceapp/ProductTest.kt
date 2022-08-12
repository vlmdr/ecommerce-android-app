package com.renarosantos.ecommerceapp

import com.renarosantos.ecommerceapp.product_list.presentation.ProductCardViewState
import com.renarosantos.ecommerceapp.product_list.presentation.ProductListViewState
import com.renarosantos.ecommerceapp.product_list.presentation.updateFavoriteProduct
import com.renarosantos.ecommerceapp.wishlist.business.AddOrRemoveFromWishListUseCase
import com.renarosantos.ecommerceapp.wishlist.business.IsProductInWishListUseCase
import com.renarosantos.ecommerceapp.wishlist.data.repository.WishlistRepository
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class ProductTest {
    private val isProductInWishListUseCase = mockk<IsProductInWishListUseCase>()
    private val wishlistRepository = mockk<WishlistRepository>(relaxed = true)
    lateinit var useCase: AddOrRemoveFromWishListUseCase

    @Before
    fun setup() {
        useCase = AddOrRemoveFromWishListUseCase(isProductInWishListUseCase,wishlistRepository)
    }

    @Test
    fun `Correct product view state is update`() {
        val content = ProductListViewState.Content(
            productList = (0..9).map {
                ProductCardViewState(
                    "$it",
                    "",
                    "",
                    "",
                    "",
                    false
                )
            }
        )

        val result = content.updateFavoriteProduct("4", true)

        assert(result.productList[4].isFavorite)
    }
    @Test
    fun `Product is not wishlist, add then`() = runTest {
        coEvery {
            isProductInWishListUseCase.execute(any())
        } returns false

        useCase.execute("123")

        coVerify {
            wishlistRepository.addToWishlist("123")
        }
    }

    @Test
    fun `Product is not wishlist, removed`() = runTest {
        coEvery {
            isProductInWishListUseCase.execute(any())
        } returns true

        useCase.execute("123")

        coVerify {
            wishlistRepository.removeFromWishlist("123")
        }
    }

}