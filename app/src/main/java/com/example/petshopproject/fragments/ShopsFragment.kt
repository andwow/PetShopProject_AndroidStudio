package com.example.petshopproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopproject.R
import com.example.petshopproject.adapters.ShopAdapter
import com.example.petshopproject.interfaces.OnShopItemClick
import com.example.petshopproject.models.Shop

class ShopsFragment : Fragment() {
    private val shops: ArrayList<Shop> = ArrayList()
    private val onShopItemClick: OnShopItemClick = OnShopItemClick {}
    private val shopAdapter: ShopAdapter = ShopAdapter(shops, onShopItemClick)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.shops_fragment, container, false)
        setUpRecyclerView(view)
        return view
    }

    private fun setUpRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.shops_recyclerview);
        val linearLayoutManager = LinearLayoutManager(view.context);
        shops.add(Shop(1, "123", "123"))
        recyclerView.layoutManager = linearLayoutManager
        val adapter = ShopAdapter(
            shops,
            OnShopItemClick {})
        recyclerView.adapter=adapter
    }
}