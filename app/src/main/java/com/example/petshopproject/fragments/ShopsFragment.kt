package com.example.petshopproject.fragments

import android.os.Bundle
import android.util.Log
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
import com.google.firebase.firestore.*

class ShopsFragment : Fragment() {
    private val shops: ArrayList<Shop> = ArrayList()
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
        recyclerView?.layoutManager = linearLayoutManager

        val adapter = ShopAdapter(
            shops,
            OnShopItemClick {changeFragment()})
        recyclerView.adapter=adapter
        eventChangeListener(adapter)
    }

    private fun eventChangeListener(adapter : ShopAdapter) {
        val db = FirebaseFirestore.getInstance()
        db.collection("petshop").addSnapshotListener(object: EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error != null) {
                    Log.e("Firestore error", error.message.toString())
                    return
                }
                for(dc:DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        shops.add(dc.document.toObject(Shop::class.java))
                    }
                }
                adapter.notifyDataSetChanged()
            }
        })

    }

    private fun changeFragment() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction!!.replace(R.id.fragment, ShopLayoutFragment())
        fragmentTransaction!!.commit()
    }
}