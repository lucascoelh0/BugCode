package com.example.digitalhouse.ui

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.example.digitalhouse.R
import com.example.digitalhouse.`interface`.ContractMainActivity
import com.example.digitalhouse.ui.detailgastos.DetailGastosFragment
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

//                val bundle = Bundle()
//                bundle.putString("nome", "Lucas")
//                bundle.putInt("idade", 23)
//                bundle.putDouble("Peso", 77.5)
//                bundle.putBoolean("status", true)
//
//                intent.putExtras(bundle)

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