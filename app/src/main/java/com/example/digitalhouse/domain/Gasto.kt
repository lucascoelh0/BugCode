package com.example.digitalhouse.domain

data class Gasto(
    val descricao: String,
    val categoria: String,
    val dataEHora: String,
    val valor: Double
) {
}