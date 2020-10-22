package com.example.digitalhouse.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.digitalhouse.EntradasFragment
import com.example.digitalhouse.GastosFragment
import com.example.digitalhouse.HomeFragment
import com.example.digitalhouse.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.mywallet)

        val frag = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            add(R.id.frameLayout, frag)
            commit()
        }

        button_home.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, HomeFragment.newInstance())
                commit()
            }
        }

        button_entradas.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, EntradasFragment.newInstance())
                commit()
            }
        }

        button_gastos.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, GastosFragment.newInstance())
                commit()
            }
        }

        toolbar.setNavigationIcon(R.drawable.ic_backbt)

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }
}