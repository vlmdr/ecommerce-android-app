package com.renarosantos.ecommerceapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ProductRepositoryApi @Inject constructor(
    private val service: ProductService) : ProductRepository {
//    private val client = ApiClient().getClient()

    override suspend fun getProductList(): List<ProductCardViewState> {
        return withContext(Dispatchers.IO) {
            service.getProductList().map {
                ProductCardViewState(
                    it.title,
                    it.description,
                    "U$ ${it.price}",
                    it.imageUrl
                )
            }
        }
    }
}