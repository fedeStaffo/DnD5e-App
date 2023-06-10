package com.progetto_dd.memory.personaggio.incantesimo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Factory per creare un'istanza di IncantesimoViewModel
class IncantesimoViewModelFactory(private val dao: IncantesimoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IncantesimoViewModel::class.java)) {
            // Restituisce un'istanza di IncantesimoViewModel con il DAO fornito come parametro
            return IncantesimoViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
