package com.renarosantos.ecommerceapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// Represent a table
@Entity
data class FavoriteProductEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "product_name") val productName: String

)
