package com.example.andrew.fragments
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.andrew.R
import com.google.firebase.auth.FirebaseAuth

class SecondFragment : Fragment(R.layout.fragment_second) {
    private lateinit var textView: TextView



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        val controller = Navigation.findNavController(view)
        textView.setOnClickListener {
            val action = SecondFragmentDirections.actionSecondFragmentToThirdFragment()
            controller.navigate(action)
        }

    }

    private fun init() {
        textView = requireView().findViewById(R.id. textView)

    }
}
