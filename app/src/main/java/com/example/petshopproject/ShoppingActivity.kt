package com.example.petshopproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.petshopproject.fragments.ShopLayoutFragment
import com.example.petshopproject.fragments.ShopsFragment
import com.example.petshopproject.models.Shop

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.shopping_activity)
        val shop:Shop = intent.getSerializableExtra("shop") as Shop
        changeFragment(shop)
    }
    private fun changeFragment(shop: Shop) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.shopping_fragment, ShopLayoutFragment(shop))
        fragmentTransaction.commit()
    }
}