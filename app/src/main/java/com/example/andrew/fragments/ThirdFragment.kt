package com.example.andrew.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.andrew.R
import com.google.firebase.auth.FirebaseAuth

class ThirdFragment : Fragment(R.layout.fragment_third) {
    private lateinit var hameri: TextView
    private lateinit var konce: TextView
    private lateinit var cable: TextView
    private lateinit var preach: TextView
    private lateinit var imigeView3: ImageView
    private lateinit var imigeView4: ImageView
    private lateinit var imigeView5: ImageView
    private lateinit var imigeView6: ImageView
    private lateinit var buttonLogin: ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

    }

    private fun init() {
        hameri = requireView().findViewById(R.id. hameri)
        konce = requireView().findViewById(R.id. konce)
        cable =requireView().findViewById(R.id. cable)
        preach = requireView().findViewById(R.id. preach)




    }
}
