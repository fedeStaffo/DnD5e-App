package com.progetto_dd.memory.personaggio.competenza

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CompetenzaViewModelFactory(private val dao: CompetenzaDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompetenzaViewModel::class.java)) {
            // Restituisce un'istanza di CompetenzaViewModel
            return CompetenzaViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
