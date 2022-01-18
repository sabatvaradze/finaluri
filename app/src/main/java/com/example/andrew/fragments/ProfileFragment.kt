package com.example.andrew.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.andrew.R
import com.google.firebase.auth.FirebaseAuth

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var buttonLogout: Button
    private lateinit var buttonPasswordChange: Button
    private lateinit var textView: TextView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        init()
        registerListeners()

        textView.text = FirebaseAuth.getInstance().currentUser?.uid
    }

    private fun init(){
        buttonLogout = requireView().findViewById(R.id.buttonLogout)
        buttonPasswordChange= requireView().findViewById(R.id.buttonPasswordChange)
        textView= requireView().findViewById(R.id.textView)
    }


    private fun registerListeners(){
        buttonLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(activity, LoginFragment::class.java))
            Activity().finish()
        }

        buttonPasswordChange.setOnClickListener {
            startActivity(Intent(activity, ChangePasswordFragment::class.java))
        }
    }

}