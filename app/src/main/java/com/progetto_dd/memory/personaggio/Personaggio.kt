package com.progetto_dd.memory.personaggio

data class Personaggio(
    val nome: String? = null,
    val utenteId: String? = null,
    val classe: String? = null,
    val razza: String? = null,
    val campagna: String? = null,
    val competenze: List<String>? = emptyList(),
    val equipaggiamento: List<String>? = emptyList(),
    val stato: String ?= null,
    val vitaMax: Long ?= null,
    val vita: Long ?= null,
    val livello: Long ?= null,
    val classeArmatura: Long ?= null,

    // Modificatori
    val carisma: Long? = null,
    val costituzione: Long? = null,
    val destrezza: Long? = null,
    val forza: Long? = null,
    val intelligenza: Long? = null,
    val saggezza: Long? = null,

    // Background
    val allineamento: String? = null,
    val descrizione: String? = null,
    val ideali: String ?= null,
    val legami: String ?= null,
    val storia: String ?= null,
    val difetti: String ?= null,
    val tratti: String ?= null
)