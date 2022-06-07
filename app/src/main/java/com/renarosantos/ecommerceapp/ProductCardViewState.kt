package com.renarosantos.ecommerceapp
// state of each product in list
// view layer
data class ProductCardViewState(
    val title: String,
    val description: String,
    val price: String,
    val imageUrl : String
)