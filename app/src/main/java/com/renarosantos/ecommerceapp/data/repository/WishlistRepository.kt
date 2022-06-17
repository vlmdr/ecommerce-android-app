package com.renarosantos.ecommerceapp.data.repository

interface WishlistRepository {
    fun addToWishList(productId: String) : Boolean
    fun removeFromWishList(productId: String) : Boolean
    fun isFavorite(productId: String) : Boolean
}