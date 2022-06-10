package com.renarosantos.ecommerceapp

import com.renarosantos.ecommerceapp.domain.Product

sealed class ProductListViewState {
    object Loading : ProductListViewState()
    data class Content(val productList: List<Product>) : ProductListViewState()
    object Error : ProductListViewState()
}