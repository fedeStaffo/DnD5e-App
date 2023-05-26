package com.progetto_dd.memory.sessione


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore


class SessioneViewModel : ViewModel() {

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
                    val numero = document.getString("numero")
                    val giorno = document.getString("giorno")
                    val descrizione = document.getString("descrizione") ?: ""
                    val masterNome = document.getString("master") ?: ""
                    val campagnaNome = document.getString("campagna") ?: ""

                    val sessione = Sessione(numero, giorno, descrizione, campagnaNome, masterNome)
                    sessioneList.add(sessione)
                }
                sessioneLiveData.value = sessioneList
            }
        return sessioneLiveData
    }

    fun eliminaSessione(campagnaNome: String, masterId: String, numeroSessione: String) {
        val db = FirebaseFirestore.getInstance()
        val sessioniCollection = db
            .collection("sessioni")
        sessioniCollection
            .whereEqualTo("campagna", campagnaNome)
            .whereEqualTo("master", masterId)
            .whereEqualTo("numero", numeroSessione)
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    document.reference.delete()
                }
            }
    }



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