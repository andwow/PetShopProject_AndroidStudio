package com.example.petshopproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.petshopproject.R
import com.example.petshopproject.models.User
import com.google.firebase.firestore.FirebaseFirestore

class PlaceOrderFragment (user: User) : Fragment() {
    val user = user
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.place_order_fragment, container, false)
        val db = FirebaseFirestore.getInstance()
        val yourCurrentLocation = view.findViewById<Button>(R.id.your_location)
        yourCurrentLocation.setOnClickListener {
            if(user.orders.isNotEmpty()) {
                db.collection("orders").add(user)
            }
        }
        return view
    }
}