package com.bignerdranch.android.zd2_v3_evsyukov.presentation


import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bignerdranch.android.zd2_v3_evsyukov.R


class SignInFragment : Fragment(R.layout.fragment_sign_in) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val btnSignIn = view.findViewById<Button>(R.id.btnSignIn)

        val prefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        etEmail.setText(prefs.getString("email", ""))
        etPassword.setText(prefs.getString("password", ""))

        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            if (password.length <= 8) {
                Toast.makeText(requireContext(), "Пароль должен быть > 8 символов", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            prefs.edit()
                .putString("email", email)
                .putString("password", password)
                .apply()

            (activity as? MainActivity)?.openFragment(MainMenuFragment(), addToBackStack = false)
        }
    }
}