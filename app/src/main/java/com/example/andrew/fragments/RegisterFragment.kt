package com.example.andrew.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.andrew.R
import com.google.firebase.auth.FirebaseAuth

class RegisterFragment : Fragment(R.layout.fragment_register){
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextEmail = requireView().findViewById(R.id.editTextEmail)
        editTextPassword = requireView().findViewById(R.id.editTextPassword)
        buttonRegister = requireView().findViewById(R.id. buttonRegister)


        val controller = Navigation.findNavController(view)





        buttonRegister.setOnClickListener {

            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()){
                Toast.makeText(getActivity(), "ცარიელია", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment()
                        controller.navigate(action)
                    }else{
                        Toast.makeText(getActivity(), "ERROR!", Toast.LENGTH_SHORT).show()
                    }

                }

        }
    }
}



