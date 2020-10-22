package com.example.digitalhouse.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.digitalhouse.R
import com.example.digitalhouse.domain.Usuario
import kotlinx.android.synthetic.main.login_body.*
import kotlin.random.Random

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        imageViewGoogle.setOnClickListener {
            makeShortToast("Google+")
        }

        imageViewFacebook.setOnClickListener {
            makeShortToast("Facebook.")
        }

        imageViewInstagram.setOnClickListener {
            makeShortToast("Instagram.")
        }

        botao_login.setOnClickListener {

            esconderTeclado()

            if (intent.hasExtra("username")) {

                val username: String = intent.getStringExtra("username")
                val senha: String = intent.getStringExtra("senha")

                if (username != edUsername.text.toString() || senha != edSenha.text.toString()) {

                    makeShortToast("Username ou senha incorretos!")

                } else {

                    val loginIntent = Intent(this, MainActivity::class.java)
                    loginIntent.putExtra("key", Usuario(Random.nextInt(), username, senha))
                    startActivity(loginIntent)

                    makeShortToast("Bem vindo, ${edUsername.text.toString()}!")
                }
            } else if (edUsername.text.toString().isNotEmpty() && edSenha.text.toString() == "123456") {

                val loginIntent = Intent(this, MainActivity::class.java)
                loginIntent.putExtra("username", Usuario(Random.nextInt(), edUsername.text.toString(), edSenha.text.toString()))
                startActivity(loginIntent)

//                makeShortToast("Bem vindo, ${edUsername.text.toString()}!")

            } else {
                makeShortToast("Username ou senha incorretos!")
            }
        }

        ir_para_cadastro.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }

    fun makeShortToast(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }

    fun Activity.esconderTeclado() {
        esconderTeclado(currentFocus ?: View(this))
    }

    fun Context.esconderTeclado(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}