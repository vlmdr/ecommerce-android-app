package com.renarosantos.ecommerceapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RespositoryModule {
    // who implement the ProductRepository is
    // ProductRepositoryAPI
    // ProductRepository receive a who use him, in the casae a API\
    // To provides a Product Repository I need a ProductRepositoryAPI
    @Provides
    fun providesProductRespository(
        productRepositoryApi: ProductRepositoryApi
    ): ProductRepository = productRepositoryApi
    /*
    * ProductRepositoryAPI need a service
    * */
    fun providesProductRepositoryAPI(
        productService: ProductService
    ) : ProductRepositoryApi = ProductRepositoryApi(productService)

    fun providesProductService() : ProductService = ApiClient.getClient()

}