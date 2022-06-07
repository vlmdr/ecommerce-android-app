package com.renarosantos.ecommerceapp
// states for list, one for loading, the content self and error
sealed class ProductListViewState {
    object Loading : ProductListViewState()
    data class Content(val productList: List<ProductCardViewState>) : ProductListViewState()
    object Error : ProductListViewState()
}