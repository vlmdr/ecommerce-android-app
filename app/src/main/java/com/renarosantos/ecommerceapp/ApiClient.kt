package com.renarosantos.ecommerceapp

import retrofit2.Retrofit

class ApiClient {

    fun getClient() : ProductService {
        Retrofit.Builder().baseUrl()
    }
}