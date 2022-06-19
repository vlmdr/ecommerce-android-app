package com.renarosantos.ecommerceapp.business.useCases

import com.renarosantos.ecommerceapp.data.repository.WishlistRepository
import javax.inject.Inject

class AddOrRemoveFromWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository,
    private val isProductInWishlistUseCase: IsProductInWishlistUseCase
) {

    suspend fun execute(productId: String) {
        if (isProductInWishlistUseCase.execute(productId)) {
            wishlistRepository.removeFromWishList(productId)
        } else {
            wishlistRepository.addToWishList(productId)
        }
    }
}