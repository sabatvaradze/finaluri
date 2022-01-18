package com.example.andrew.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.andrew.R
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordFragment : Fragment(R.layout.fragment_reset)  {
    private lateinit var editTextEmail: EditText
    private lateinit var buttonSendEmail: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editTextEmail = requireView().findViewById(R.id.editTextEmail)
        buttonSendEmail = requireView().findViewById(R.id.buttonSendEmail)
        val controller = Navigation.findNavController(view)

        buttonSendEmail.setOnClickListener {
            val email = editTextEmail.text.toString()
            if (email.isEmpty()){
                Toast.makeText(getActivity(), "Empty E-mail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{ task ->
                    if(task.isSuccessful){
                        Toast.makeText(getActivity(), "Check E-mail!", Toast.LENGTH_SHORT).show()
                        val action= ResetPasswordFragmentDirections.actionResetPasswordFragmentToLoginFragment()
                        controller.navigate(action)
                    }else{
                        Toast.makeText(getActivity(), "ERROR! ERROR!", Toast.LENGTH_SHORT).show()
                    }
                }

        }

    }
}
