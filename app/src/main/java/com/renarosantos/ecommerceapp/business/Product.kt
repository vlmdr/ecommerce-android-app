package com.renarosantos.ecommerceapp.business

data class Product(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val imageUrl : String
)