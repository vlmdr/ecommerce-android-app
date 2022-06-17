package com.renarosantos.ecommerceapp.presentation.viewstate

data class ProductCardViewState(
    val title: String,
    val description: String,
    val price: String,
    val imageUrl : String,
    val isFavorite: Boolean
)