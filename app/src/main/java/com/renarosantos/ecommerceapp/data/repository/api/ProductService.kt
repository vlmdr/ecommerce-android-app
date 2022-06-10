package com.renarosantos.ecommerceapp.data.repository.api

import com.renarosantos.ecommerceapp.data.entities.ProductEntity
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProductList() : List<ProductEntity>
}