package com.renarosantos.ecommerceapp.interfaces

import com.renarosantos.ecommerceapp.ProductCardViewState

interface ProductRepository {
    suspend fun getProductList(): List<ProductCardViewState>
}