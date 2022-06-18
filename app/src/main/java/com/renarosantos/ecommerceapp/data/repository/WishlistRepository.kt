package com.renarosantos.ecommerceapp.data.repository

interface WishlistRepository {
    suspend fun addToWishList(productId: String)
    suspend fun removeFromWishList(productId: String)
    suspend fun isFavorite(productId: String) : Boolean
}