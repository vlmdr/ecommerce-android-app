package com.renarosantos.ecommerceapp.data.database.repository

import com.renarosantos.ecommerceapp.data.database.dao.WishlistDAO
import com.renarosantos.ecommerceapp.data.database.entities.FavoriteProductEntity
import com.renarosantos.ecommerceapp.data.repository.WishlistRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WishlistDatabaseRepository @Inject constructor(
    private val wishlistDAO: WishlistDAO
) : WishlistRepository {
    override suspend fun addToWishList(productId: String) {
        return withContext(Dispatchers.IO) {
            wishlistDAO.addProductToFavorites(
                FavoriteProductEntity(productId, "")
            )
        }
    }

    override suspend fun removeFromWishList(productId: String) {
        return withContext(Dispatchers.IO) {
            wishlistDAO.removeProductFromFavorites(
                FavoriteProductEntity(productId, "")
            )
        }
    }

    override suspend fun isFavorite(productId: String): Boolean {
        return withContext(Dispatchers.IO) {
            wishlistDAO.isProductFavorite(productId) != null
        }
    }


}