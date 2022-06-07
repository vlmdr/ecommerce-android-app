package com.renarosantos.ecommerceapp

import retrofit2.http.GET

interface ProductService {
    @GET
    suspend fun getProductList() : List<ProductEntity>
}