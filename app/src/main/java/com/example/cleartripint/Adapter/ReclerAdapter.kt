package com.example.cleartripint.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cleartripint.data.ProductsItem
import com.example.cleartripint.databinding.ItemLayoutBinding
import com.squareup.picasso.Picasso

class ReclerAdapter(
    private var productList: List<ProductsItem>,

    private var onItemClicked: ((productItem: ProductsItem) -> Unit)
) : RecyclerView.Adapter<ReclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productList[position])
    }

    inner class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productsItem: ProductsItem) = binding.apply {

            textDesc.text = productsItem.description
            textPrice.text = productsItem.price.toString()
            textTitle.text = productsItem.title
            Picasso.get()
                .load(productsItem.image)
                .into(appImg)

            root.setOnClickListener {

                onItemClicked(productsItem)
            }
        }
    }



    override fun getItemCount(): Int {
        return productList.size
    }


}