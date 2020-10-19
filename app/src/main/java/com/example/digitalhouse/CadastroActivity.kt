package com.example.digitalhouse

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_cadastro.*
import kotlinx.android.synthetic.main.cadastro_body.*
import kotlinx.android.synthetic.main.toolbar.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.cadastrar_maiusculo)

        esconderTeclado()

        botao_cadastrar.setOnClickListener {

            esconderTeclado()

            val username = cadastro_username.text.toString()
            val email = cadastro_email.text.toString()
            val senha = cadastro_senha.text.toString()
            val confirmarSenha = cadastro_confirmar_senha.text.toString()

            if (username.isEmpty() || email.isEmpty() || senha.isEmpty() || confirmarSenha.isEmpty()) {

                makeSnack("Digite as informações destacadas.")
                validarCampo(username, cadastro_username)
                validarCampo(email, cadastro_email)
                validarCampo(senha, cadastro_senha)
                validarCampo(confirmarSenha, cadastro_confirmar_senha)

            } else if (senha != confirmarSenha) {

                makeSnack("As senhas não coincidem.")
                cadastro_confirmar_senha.backgroundTintList = ContextCompat.getColorStateList(this, R.color.colorRed)

            } else {
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("senha", senha)

                startActivity(intent)

                Toast.makeText(this, "Cadastro realizado com sucesso! Por favor realize o login.", Toast.LENGTH_SHORT).show()
            }
        }

        toolbar.setNavigationIcon(R.drawable.ic_backbt)

        toolbar.setNavigationOnClickListener {
            esconderTeclado()
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cadastro, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun makeSnack(mensagem: String) {
        Snackbar.make(activity_cadastro, mensagem, Snackbar.LENGTH_LONG).show()
    }

    fun validarCampo(string: String, campo: TextInputEditText) {
        if (string.isEmpty()) {
            campo.backgroundTintList = ContextCompat.getColorStateList(this, R.color.colorAccent)
        } else {
            campo.backgroundTintList = ContextCompat.getColorStateList(this, R.color.colorRed)
        }
    }

    fun Activity.esconderTeclado() {
        esconderTeclado(currentFocus ?: View(this))
    }

    fun Context.esconderTeclado(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}