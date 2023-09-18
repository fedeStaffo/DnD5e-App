package com.progetto_dd.memory.npc

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class NpcViewModel: ViewModel() {

    fun getNpc(campaignName: String, masterId: String): MutableLiveData<List<Npc>> {
        val npcLiveData = MutableLiveData<List<Npc>>()
        val firestore = FirebaseFirestore.getInstance()

        // Ottieni il riferimento alla raccolta "npc" filtrando i documenti in base ai valori "campagna" e "master"
        val npcCollectionRef = firestore.collection("npc")
            .whereEqualTo("campagna", campaignName)
            .whereEqualTo("master", masterId)
            .get()
            .addOnSuccessListener { querySnapshot ->
                val npcList = mutableListOf<Npc>()

                for (document in querySnapshot.documents) {
                    // Ottieni i campi "nome", "legame" e "descrizione"
                    // "campagna" e "master" da ogni documento nella raccolta "npc"
                    val nome = document.getString("nome") ?: ""
                    val legame = document.getString("legame") ?: ""
                    val descrizione = document.getString("descrizione") ?: ""
                    val campagna = document.getString("campagna") ?: ""
                    val master = document.getString("master") ?: ""

                    val npc = Npc(nome, legame, descrizione, campagna, master)
                    npcList.add(npc)
                }

                val sortedNpc = npcList.sortedWith(compareBy { it.nome?.lowercase() }) // Ordina la lista degli npc per nome senza differenziare maiuscole e minuscole
                npcLiveData.value = sortedNpc
            }
        return npcLiveData
    }


    fun eliminaNpc(nome: String, master: String, campagna: String) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "npc"
        val npcCollection = db.collection("npc")

        // Esegui una query per ottenere tutti i documenti npc che corrispondono ai criteri specificati
        npcCollection
            .whereEqualTo("nome", nome)
            .whereEqualTo("master", master)
            .whereEqualTo("campagna", campagna)
            .get()
            .addOnSuccessListener { documents ->
                // Itera sui documenti restituiti dalla query
                for (document in documents) {
                    // Elimina il documento npc corrente utilizzando la sua ID
                    npcCollection.document(document.id).delete()
                }
            }
    }


    fun deleteNPCsFromCampaign(campaignName: String, masterId: String) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "npc"
        val npcCollection = db.collection("npc")

        // Esegui una query per ottenere tutti i documenti npc che corrispondono alla campagna e al masterId specificati
        npcCollection
            .whereEqualTo("campagna", campaignName)
            .whereEqualTo("master", masterId)
            .get()
            .addOnSuccessListener { querySnapshot ->
                // Crea un batch di operazioni
                val batch = db.batch()

                // Itera sui documenti restituiti dalla query
                for (document in querySnapshot.documents) {
                    // Ottieni la referenza al documento npc corrente
                    val npcDocumentRef = npcCollection.document(document.id)

                    // Aggiungi un'operazione di eliminazione al batch per il documento npc corrente
                    batch.delete(npcDocumentRef)
                }

                // Esegui il batch di operazioni di eliminazione
                batch.commit()
            }
    }

    fun modificaLegameNpc(nome: String, master: String, campagna: String, nuovoLegame: String) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "npc"
        val npcCollection = db.collection("npc")

        // Esegui una query per ottenere il documento NPC corrispondente ai criteri specificati
        npcCollection
            .whereEqualTo("nome", nome)
            .whereEqualTo("master", master)
            .whereEqualTo("campagna", campagna)
            .get()
            .addOnSuccessListener { documents ->
                // Verifica se è stato trovato almeno un documento
                if (documents.isEmpty) {
                    // Documento non trovato, puoi gestire l'errore qui
                    return@addOnSuccessListener
                }

                // Ottieni il documento NPC
                val npcDocument = documents.first()

                // Aggiorna il campo "legame" con il nuovo valore
                npcDocument.reference.update("legame", nuovoLegame)
            }
    }

    fun modificaDescrizioneNpc(nome: String, master: String, campagna: String, nuovaDescrizione: String) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "npc"
        val npcCollection = db.collection("npc")

        // Esegui una query per ottenere il documento NPC corrispondente ai criteri specificati
        npcCollection
            .whereEqualTo("nome", nome)
            .whereEqualTo("master", master)
            .whereEqualTo("campagna", campagna)
            .get()
            .addOnSuccessListener { documents ->
                // Verifica se è stato trovato almeno un documento
                if (documents.isEmpty) {
                    // Documento non trovato, puoi gestire l'errore qui
                    return@addOnSuccessListener
                }

                // Ottieni il documento NPC
                val npcDocument = documents.first()

                // Aggiorna il campo "descrizione" con il nuovo valore
                npcDocument.reference.update("descrizione", nuovaDescrizione)
            }
    }
}