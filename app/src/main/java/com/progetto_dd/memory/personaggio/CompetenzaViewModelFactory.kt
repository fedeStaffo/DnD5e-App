package com.progetto_dd.memory.personaggio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CompetenzaViewModelFactory(private val dao: CompetenzaDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CompetenzaViewModel::class.java)) {
            return CompetenzaViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}
