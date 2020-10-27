package com.example.digitalhouse.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.digitalhouse.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val bundle: Bundle ?= intent.extras

        if (bundle != null) {

            val nome = bundle.getString("nome")

            Toast.makeText(
                this,
                "Perfil de $nome",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}