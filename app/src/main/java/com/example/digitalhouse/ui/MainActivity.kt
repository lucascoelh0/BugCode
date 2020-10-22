package com.example.digitalhouse.ui

import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
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
        button_home.setTextColor(getColor(R.color.colorPurple))
        button_home.setBackgroundResource(R.drawable.home_button_selected)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.frameLayout, frag)
            commit()
        }

        button_home.setOnClickListener {

            button_home.setTextColor(getColor(R.color.colorPurple))
            button_home.setBackgroundResource(R.drawable.home_button_selected)

            button_entradas.setTextColor(getColor(R.color.colorWhite))
            button_entradas.setBackgroundResource(R.drawable.home_button_default)

            button_gastos.setTextColor(getColor(R.color.colorWhite))
            button_gastos.setBackgroundResource(R.drawable.home_button_default)

            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, HomeFragment.newInstance())
                commit()
            }
        }

        button_entradas.setOnClickListener {

            button_entradas.setTextColor(getColor(R.color.colorPurple))
            button_entradas.setBackgroundResource(R.drawable.home_button_selected)

            button_home.setTextColor(getColor(R.color.colorWhite))
            button_home.setBackgroundResource(R.drawable.home_button_default)

            button_gastos.setTextColor(getColor(R.color.colorWhite))
            button_gastos.setBackgroundResource(R.drawable.home_button_default)

            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, EntradasFragment.newInstance())
                commit()
            }
        }

        button_gastos.setOnClickListener {

            button_gastos.setTextColor(getColor(R.color.colorPurple))
            button_gastos.setBackgroundResource(R.drawable.home_button_selected)

            button_entradas.setTextColor(getColor(R.color.colorWhite))
            button_entradas.setBackgroundResource(R.drawable.home_button_default)

            button_home.setTextColor(getColor(R.color.colorWhite))
            button_home.setBackgroundResource(R.drawable.home_button_default)

            supportFragmentManager.beginTransaction().apply {
                addToBackStack(null)
                replace(R.id.frameLayout, GastosFragment.newInstance())
                commit()
            }
        }

//        if (supportFragmentManager.backStackEntryCount > 3) {
//            supportFragmentManager.popBackStack()
//        }

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