package com.progetto_dd.memory.campagna

data class Campagna(
    val nome: String? = null,
    val masterId: String? = null,
    val masterNome: String? = null,
    val password: String? = null,
    val partecipanti: List<String>? = null
)
