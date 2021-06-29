package com.example.petshopproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopproject.R
import com.example.petshopproject.adapters.ProductAdapter
import com.example.petshopproject.interfaces.OnProductItemClick
import com.example.petshopproject.models.Product
import com.example.petshopproject.models.Shop
import com.google.firebase.firestore.*

class ShopLayoutFragment(shop: Shop) : Fragment() {
    private val shop: Shop = shop
    private val products: ArrayList<Product> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.shop_layout_fragment, container, false)
        val shopName = view.findViewById<TextView>(R.id.shop_name_for_layout)
        val shopDescription = view.findViewById<TextView>(R.id.shop_description_for_layout)
        val shopLocation = view.findViewById<TextView>(R.id.shop_location_for_layout)
        shopName.text = shop.name
        shopDescription.text = shopDescription.text.toString() + " " + shop.description
        shopLocation.text = shopLocation.text.toString() + " " + shop.location
        setUpRecyclerView(view)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun setUpRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.products_recyclerview);
        val linearLayoutManager = LinearLayoutManager(view.context);
        recyclerView.layoutManager = linearLayoutManager
        val adapter = ProductAdapter(
            products,
            OnProductItemClick {})
        recyclerView.adapter = adapter
        eventChangeListener(adapter)
    }

    private fun eventChangeListener(adapter : ProductAdapter) {
        val db = FirebaseFirestore.getInstance()
        db.collection("petshops").document(shop.document).collection("products").addSnapshotListener(object: EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error != null) {
                    Log.e("Firestore error", error.message.toString())
                    return
                }
                for(dc:DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        var product = dc.document.toObject(Product::class.java);
                        products.add(product)
                    }
                }
                adapter.notifyDataSetChanged()
            }
        })

    }
}