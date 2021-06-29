package com.example.petshopproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petshopproject.R
import com.example.petshopproject.models.User
import com.google.firebase.firestore.*

class RegisterFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.register_fragment, container, false)
        val username = view.findViewById<TextView>(R.id.username_register)
        val password = view.findViewById<TextView>(R.id.password_register)
        val email = view.findViewById<TextView>(R.id.email_register)
        val location = view.findViewById<TextView>(R.id.location_register)
        val register = view.findViewById<Button>(R.id.sign_up_button)
        val cancel = view.findViewById<Button>(R.id.cancel_button)
        register.setOnClickListener {
            register(username.text.toString(), password.text.toString(), email.text.toString(), location.text.toString())
        }
        cancel.setOnClickListener {
            cancel()
        }
        return view
    }

    private fun register(username: String, password: String, email: String, location: String) {
        if(username != "" && password != "" && email != "" && location != "") {
            val emailRegex = Regex(".+@.+\\..+")
            val db = FirebaseFirestore.getInstance()
            db.collection("users").addSnapshotListener(object :
                EventListener<QuerySnapshot> {
                override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                    if (error != null) {
                        Log.e("Firestore error", error.message.toString())
                        return
                    }
                    for (dc: DocumentChange in value?.documentChanges!!) {
                        if (dc.type == DocumentChange.Type.ADDED) {
                            val user = dc.document.toObject(User::class.java)
                            if (user.username.equals(username)) {
                                return
                            }
                            if (user.email.equals(email) || !emailRegex.matches(email)) {
                                return
                            }
                        }
                    }
                    db.collection("users").add(User(username, password, email, location))
                    cancel()
                }
            })
        }
    }

    private fun cancel() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, LoginFragment())
        fragmentTransaction?.commit()
    }
}