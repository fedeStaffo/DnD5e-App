package com.progetto_dd.memory.personaggio

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.progetto_dd.memory.personaggio.Competenza
import com.progetto_dd.memory.personaggio.CompetenzaDao
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CompetenzaViewModel(private val dao: CompetenzaDao) : ViewModel() {

    val competenzeNomiLiveData = MutableLiveData<List<String>>()

    init {
        insertCompetenzePredefinite()
    }

    // Prende le competenze della classe data dal database ordinandole per nome
    fun getCompetenzeNomiByClasse(classe: String) {
        viewModelScope.launch {
            val competenzeNomi = withContext(Dispatchers.IO) {
                dao.getCompetenzeNomiByClasse(classe).sorted()
            }
            competenzeNomiLiveData.value = competenzeNomi
        }
    }

    private fun insertCompetenzePredefinite() {
        val competenzePredefinite = listOf(
            Competenza("Atletica", listOf("Bardo","Guerriero","Ladro")),
            Competenza("Acrobazia", listOf("Bardo","Guerriero","Ladro")),
            Competenza("Furtività", listOf("Bardo","Ladro")),
            Competenza("Rapidità di mano", listOf("Bardo","Ladro")),
            Competenza("Arcano", listOf("Bardo","Mago")),
            Competenza("Indagare", listOf("Bardo","Ladro","Mago")),
            Competenza("Natura", listOf("Bardo")),
            Competenza("Religione", listOf("Bardo","Mago")),
            Competenza("Storia", listOf("Bardo","Ladro","Mago")),
            Competenza("Addestrare animali", listOf("Bardo","Ladro")),
            Competenza("Intuizione", listOf("Bardo","Guerriero","Ladro","Mago")),
            Competenza("Medicina", listOf("Bardo","Mago")),
            Competenza("Percezione", listOf("Bardo","Guerriero","Ladro")),
            Competenza("Sopravvivenza", listOf("Bardo","Guerriero")),
            Competenza("Intimidire", listOf("Bardo","Guerriero","Ladro")),
            Competenza("Inganno", listOf("Bardo","Ladro")),
            Competenza("Intrattenere", listOf("Bardo")),
            Competenza("Persuasione", listOf("Bardo","Ladro")),
        )

        viewModelScope.launch {
            competenzePredefinite.forEach { competenza ->
                dao.insertOrReplace(competenza)
            }
        }
    }
}
