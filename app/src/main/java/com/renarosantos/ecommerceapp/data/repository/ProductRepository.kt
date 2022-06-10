package com.renarosantos.ecommerceapp.data.repository

import com.renarosantos.ecommerceapp.domain.Product

interface ProductRepository {
    suspend fun getProductList(): List<Product>
}