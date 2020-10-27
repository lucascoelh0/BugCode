package com.example.digitalhouse.ui

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.TextViewCompat
import com.example.digitalhouse.R
import com.example.digitalhouse.`interface`.ContractMainActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity(), ContractMainActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.mywallet)

        val frag = HomeFragment.newInstance()

        supportFragmentManager.beginTransaction().apply {
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

//        if (supportFragmentManager.backStackEntryCount > 3) {
//            supportFragmentManager.popBackStack()
//        }

        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.action_avatar -> {

                val intent = Intent(this, ProfileActivity::class.java)
                intent.putExtra("Nome", Bundle().apply {

                })

                val bundle: Bundle ?= intent.extras
                if (bundle != null) {
                    val nome = bundle.getString("Nome")
                    val peso = bundle.getDouble("Peso")
                    val idade = bundle.getInt("Idade")
                    val titular = bundle.getBoolean("Titular")

                    Toast.makeText(this, bundle.toString(), Toast.LENGTH_SHORT).show()
                }

                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun callFragDetailGastos() {
        val fragDetailGastos = DetailGastosFragment.newInstance("Lista de Gastos")
        supportFragmentManager.beginTransaction().apply {
            addToBackStack(null)
            replace(R.id.flFragDetails, fragDetailGastos)
            commit()
        }
    }

    override fun mudarCorHome(idCor: Int) {
        button_home.setTextColor(ContextCompat.getColor(this, idCor))
        if (idCor == R.color.colorWhite) {
            button_home.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
            button_home.setBackgroundResource(R.drawable.home_button_default)
        } else {
            button_home.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#800080"))
            button_home.setBackgroundResource(R.drawable.home_button_selected)
        }
    }

    override fun mudarCorEntrada(idCor: Int) {
        button_entradas.setTextColor(ContextCompat.getColor(this, idCor))
        if (idCor == R.color.colorWhite) {
            button_entradas.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
            button_entradas.setBackgroundResource(R.drawable.home_button_default)
        } else {
            button_entradas.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#800080"))
            button_entradas.setBackgroundResource(R.drawable.home_button_selected)
        }
    }

    override fun mudarCorGastos(idCor: Int) {
        button_gastos.setTextColor(ContextCompat.getColor(this, idCor))
        if (idCor == R.color.colorWhite) {
            button_gastos.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#FFFFFF"))
            button_gastos.setBackgroundResource(R.drawable.home_button_default)
        } else {
            button_gastos.compoundDrawableTintList = ColorStateList.valueOf(Color.parseColor("#800080"))
            button_gastos.setBackgroundResource(R.drawable.home_button_selected)
        }
    }
}