package com.renarosantos.ecommerceapp.data.database

import com.renarosantos.ecommerceapp.data.repository.WishlistRepository
import javax.inject.Inject

class WishlistDatabaseRepository @Inject constructor(): WishlistRepository {
    override fun addToWishList(productId: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeFromWishList(productId: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun isFavorite(productId: String): Boolean {
        return true
    }


}