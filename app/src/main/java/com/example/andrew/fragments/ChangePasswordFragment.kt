package com.example.andrew.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.andrew.R
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordFragment : Fragment(R.layout.fragment_change_password) {
    private lateinit var editTextNewPassword: EditText
    private lateinit var buttonChangePassword: Button



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        init()
        registerListeners()
    }


    private fun init(){
        editTextNewPassword =  requireView().findViewById(R.id. editTextNewPassword)
        buttonChangePassword =  requireView().findViewById(R.id. buttonChangePassword)
    }

    private fun registerListeners(){
        buttonChangePassword.setOnClickListener {
            val newPassword = editTextNewPassword.toString()
            if(newPassword.isEmpty() || newPassword.length < 6) {
                Toast.makeText(getActivity(), "Incorrect password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(getActivity(), "ERRORRR!", Toast.LENGTH_SHORT).show()
                    }
                }

        }


    }

}
