package com.renarosantos.ecommerceapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.renarosantos.ecommerceapp.data.database.dao.WishlistDAO
import com.renarosantos.ecommerceapp.data.database.entities.FavoriteProductEntity

// entrypoint from database, here I specify a table for use
@Database(entities = [FavoriteProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishlistDao(): WishlistDAO

}