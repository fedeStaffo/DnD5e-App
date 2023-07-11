package com.progetto_dd.memory.sessione

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore

class SessioneViewModel : ViewModel() {

    // Ottieni le sessioni corrispondenti alla campagna e al master specificati
    fun getSessione(campagna: String, master: String): MutableLiveData<List<Sessione>> {
        val sessioneLiveData = MutableLiveData<List<Sessione>>()
        val db = FirebaseFirestore.getInstance()
        val sessioneCollection = db.collection("sessioni")

        sessioneCollection
            .whereEqualTo("campagna", campagna)
            .whereEqualTo("master", master)
            .get()
            .addOnSuccessListener { documents ->
                val sessioneList = mutableListOf<Sessione>()
                for (document in documents) {
                    // Recupera i dati della sessione dal documento Firestore
                    val numero = document.getString("numero")
                    val giorno = document.getString("giorno")
                    val descrizione = document.getString("descrizione") ?: ""
                    val masterNome = document.getString("master") ?: ""
                    val campagnaNome = document.getString("campagna") ?: ""

                    // Crea un oggetto Sessione e aggiungilo alla lista
                    val sessione = Sessione(numero, giorno, descrizione, campagnaNome, masterNome)
                    sessioneList.add(sessione)
                }

                val sortedSessione = sessioneList.sortedBy { it.numero?.toInt() } // Ordina la lista delle sessioni per numero
                sessioneLiveData.value = sortedSessione
            }
        return sessioneLiveData
    }

    // Elimina una sessione specifica dalla campagna e dal master specificati
    fun eliminaSessione(campagnaNome: String, masterId: String, numeroSessione: String) {
        val db = FirebaseFirestore.getInstance()
        val sessioniCollection = db.collection("sessioni")

        sessioniCollection
            .whereEqualTo("campagna", campagnaNome)
            .whereEqualTo("master", masterId)
            .whereEqualTo("numero", numeroSessione)
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    // Elimina il documento della sessione
                    document.reference.delete()
                }
            }
    }

    // Elimina tutte le sessioni di una campagna specifica per il master specificato
    fun deleteSessionsFromCampaign(campaignName: String, masterId: String) {
        val db = FirebaseFirestore.getInstance()
        val sessionCollection = db.collection("sessioni")

        sessionCollection
            .whereEqualTo("campagna", campaignName)
            .whereEqualTo("master", masterId)
            .get()
            .addOnSuccessListener { querySnapshot ->
                val batch = db.batch()

                for (document in querySnapshot.documents) {
                    val sessionDocumentRef = sessionCollection.document(document.id)
                    batch.delete(sessionDocumentRef)
                }

                batch.commit()
            }
    }
}
