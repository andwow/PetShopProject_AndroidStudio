package com.example.petshopproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopproject.R
import com.example.petshopproject.adapters.ProductAdapter
import com.example.petshopproject.adapters.ShopAdapter
import com.example.petshopproject.interfaces.OnProductItemClick
import com.example.petshopproject.interfaces.OnShopItemClick
import com.example.petshopproject.models.Product
import com.example.petshopproject.models.Shop

class ShopLayoutFragment (shopId: Int) : Fragment() {
    private val shopId = shopId
    private val products: ArrayList<Product> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.shop_layout_fragment, container, false)
        setUpRecyclerView(view)
        return view
    }

    private fun setUpRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.products_recyclerview);
        val linearLayoutManager = LinearLayoutManager(view.context);
        products.add(Product(1, "123", "123", 13.32F))
        recyclerView.layoutManager = linearLayoutManager
        val adapter = ProductAdapter(
            products,
            OnProductItemClick {})
        recyclerView.adapter = adapter
    }
}