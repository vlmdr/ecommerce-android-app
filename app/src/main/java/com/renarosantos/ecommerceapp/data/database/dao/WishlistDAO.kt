package com.renarosantos.ecommerceapp.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.renarosantos.ecommerceapp.data.database.entities.FavoriteProductEntity

@Dao
interface WishlistDAO {
    @Query("SELECT * FROM favoriteproductentity WHERE id=:id")
    fun isProductFavorite(id: String): FavoriteProductEntity?

    @Insert
    fun addProductToFavorites(product: FavoriteProductEntity)

    @Delete
    fun removeProductFromFavorites(product: FavoriteProductEntity)
}