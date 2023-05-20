package com.progetto_dd.memory.personaggio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class IncantesimoViewModelFactory(private val dao: IncantesimoDao) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IncantesimoViewModel::class.java)) {
            return IncantesimoViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}