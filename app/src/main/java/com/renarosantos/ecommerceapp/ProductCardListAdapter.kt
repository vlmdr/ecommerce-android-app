package com.renarosantos.ecommerceapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.renarosantos.ecommerceapp.databinding.ProductCardBinding
import com.renarosantos.ecommerceapp.domain.Product


/*
* Adapter is a bridge between AdapterView and underlying data for that view.
* Provides access to data items
* */
class ProductCardListAdapter(val onItemClicked: (Product) -> Unit) : RecyclerView.Adapter<ProductCardListAdapter.ViewHolder>() {


    private var data: List<Product> = emptyList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(productList: List<Product>) {
        this.data = productList
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            val bind = ProductCardBinding.bind(itemView)
            itemView.setOnClickListener {
                onItemClicked(product)
            }
            bind.apply {
                viewProductName.text = product.title
                viewProductDescription.text = product.description
                productPrice.text = product.price
                Glide.with(productImage)
                    .asBitmap()
                    .load(product.imageUrl)
                    .into(BitmapImageViewTarget(productImage))
            }
        }

    }
}