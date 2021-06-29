package com.example.petshopproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.petshopproject.R
import com.example.petshopproject.adapters.OrderAdapter
import com.example.petshopproject.models.Shop
import com.example.petshopproject.models.User

class YourCartFragment(private val shop: Shop, private val user: User) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.your_cart_fragment, container, false)
        val cancel = view.findViewById<Button>(R.id.cancel_view_cart)
        cancel.setOnClickListener {
            cancelViewCart()
        }
        setUpRecyclerView(view)
        return view
    }

    private fun setUpRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.orders_recyclerview)
        val linearLayoutManager = LinearLayoutManager(view.context)
        recyclerView?.layoutManager = linearLayoutManager
        val adapter = OrderAdapter(
            user.orders
        ) {}
        recyclerView?.adapter=adapter
    }

    private fun cancelViewCart() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.shopping_fragment, ShopLayoutFragment(shop, user))
        fragmentTransaction?.commit()
    }
}