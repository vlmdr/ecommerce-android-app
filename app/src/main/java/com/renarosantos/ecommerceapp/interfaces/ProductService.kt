package com.renarosantos.ecommerceapp.interfaces

import com.renarosantos.ecommerceapp.ProductEntity
import retrofit2.http.GET

interface ProductService {

    @GET("products")
    suspend fun getProductList() : List<ProductEntity>
}