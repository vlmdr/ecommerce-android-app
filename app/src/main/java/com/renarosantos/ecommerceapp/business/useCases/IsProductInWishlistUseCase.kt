package com.renarosantos.ecommerceapp.business.useCases

import com.renarosantos.ecommerceapp.data.repository.WishlistRepository
import javax.inject.Inject

class IsProductInWishlistUseCase @Inject constructor(
    private val wishlistRepository: WishlistRepository
) {
    // new notation
    suspend fun execute(productId: String): Boolean =  
        wishlistRepository.isFavorite(productId)
}