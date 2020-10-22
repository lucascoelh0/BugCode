package com.example.digitalhouse.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalhouse.HomeFragment
import com.example.digitalhouse.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.frameLayout, frag)
            commit()
        }
    }
}