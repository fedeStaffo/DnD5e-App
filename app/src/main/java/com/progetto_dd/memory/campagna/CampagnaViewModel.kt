package com.progetto_dd.memory.campagna

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore

class CampagnaViewModel : ViewModel() {

    // Riferimenti alle collezioni nel database
    private val campagneRef = FirebaseFirestore.getInstance().collection("campagne")

    // Riferimento all'utente loggato
    private val currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser

    fun creaCampagna(nome: String, password: String, master: String) {
        currentUser?.let { user ->
            // Creazione di un nuovo documento con un ID generato automaticamente
            val nuovoDocumento = campagneRef.document()

            // Creazione dell'oggetto campagna con i dati forniti
            val campagna = hashMapOf(
                "nome" to nome,
                "password" to password,
                "masterNome" to master,
                "masterId" to user.uid
            )

            // Salvataggio della nuova campagna nel Firestore
            nuovoDocumento.set(campagna)
        }
    }


    fun getCampagne(): LiveData<List<Campagna>> {
        val mutableLiveData = MutableLiveData<List<Campagna>>()

        val userId = currentUser?.uid

        val campagneQueryMaster = campagneRef.whereEqualTo("masterId", userId)
        val campagneQueryPlayer = userId?.let { campagneRef.whereArrayContains("partecipanti", it) }

        val campagneMasterTask = campagneQueryMaster.get()
        val campagnePlayerTask = campagneQueryPlayer?.get()

        Tasks.whenAllComplete(campagneMasterTask, campagnePlayerTask)
            .addOnSuccessListener { results ->
                val campagneMaster = campagneMasterTask.result?.toObjects(Campagna::class.java)
                val campagnePlayer = campagnePlayerTask?.result?.toObjects(Campagna::class.java)

                val campagne = mutableListOf<Campagna>()

                campagneMaster?.let { campagne.addAll(it) }
                campagnePlayer?.let { campagne.addAll(it) }

                mutableLiveData.postValue(campagne)
            }
            .addOnFailureListener { exception ->
                Log.e(TAG, "Errore nella lettura delle campagne da Firestore: ", exception)
            }

        return mutableLiveData
    }

    /*
    Questa funzione esegue due query separate: una per ottenere i nomi dei personaggi dell'utente e
    un'altra per verificare se i personaggi fanno parte di una campagna.
    I nomi dei personaggi che fanno parte di una campagna vengono esclusi dalla lista finale.
     */
    fun getNomiPersonaggiUtente(): LiveData<List<String>> {
        val mutableLiveData = MutableLiveData<List<String>>()

        val personaggiRef = FirebaseFirestore.getInstance().collection("personaggi")
        val campagneRef = FirebaseFirestore.getInstance().collection("campagne")
        val utenteId = FirebaseAuth.getInstance().currentUser?.uid

        val nomiPersonaggi = mutableListOf<String>()

        // Query per ottenere i nomi dei personaggi dell'utente
        val queryPersonaggi = personaggiRef.whereEqualTo("utenteId", utenteId)

        queryPersonaggi.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                val nomePersonaggio = document.getString("nome")
                nomePersonaggio?.let {
                    nomiPersonaggi.add(it)
                }
            }

            // Query per verificare se i personaggi fanno parte di una campagna
            val queryCampagne = campagneRef.whereArrayContainsAny("personaggi", nomiPersonaggi)

            queryCampagne.get().addOnSuccessListener { campagneSnapshot ->
                for (document in campagneSnapshot) {
                    val personaggiCampagna = document.get("personaggi") as? List<String>
                    personaggiCampagna?.let {
                        nomiPersonaggi.removeAll(it)
                    }
                }

                mutableLiveData.postValue(nomiPersonaggi)
            }.addOnFailureListener { exception ->
                Log.e(TAG, "Errore nella lettura delle campagne da Firestore: ", exception)
            }
        }.addOnFailureListener { exception ->
            Log.e(TAG, "Errore nella lettura personaggi da Firestore: ", exception)
        }

        return mutableLiveData
    }

    fun aggiungiPersonaggioACampagna(context: Context, nomeCampagna: String, passwordCampagna: String, nomePersonaggioSelezionato: String) {
        // Verifica l'esistenza della campagna con la password fornita
        campagneRef.whereEqualTo("nome", nomeCampagna)
            .whereEqualTo("password", passwordCampagna)
            .get()
            .addOnSuccessListener { snapshot ->
                if (snapshot.isEmpty) {
                    // La campagna non esiste o la password non è corretta
                    Toast.makeText(context, "La campagna non esiste o la password non è corretta", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }

                val campagnaDocument = snapshot.documents[0]
                val campagnaId = campagnaDocument.id

                val partecipanti = campagnaDocument.get("partecipanti") as? List<String>

                if (partecipanti != null && partecipanti.contains(currentUser?.uid)) {
                    // L'utente corrente è già un partecipante della campagna
                    Toast.makeText(context, "Partecipi già a questa campagna", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }

                val userId = currentUser?.uid
                val campagnaMasterId = campagnaDocument.getString("masterId")

                if (userId != null && userId == campagnaMasterId) {
                    // L'utente corrente è il master della campagna
                    Toast.makeText(context, "Sei già il master di questa campagna", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }

                val personaggiRef = campagneRef.document(campagnaId)

                // Verifica se l'utente corrente ha già un personaggio nella campagna
                personaggiRef.get()
                    .addOnSuccessListener { campagnaSnapshot ->
                        val personaggi = campagnaSnapshot.get("personaggi") as? List<String>

                        if (personaggi != null && personaggi.contains(currentUser?.uid)) {
                            // L'utente corrente ha già un personaggio nella campagna
                            Toast.makeText(context, "Hai già un personaggio nella campagna", Toast.LENGTH_SHORT).show()
                            return@addOnSuccessListener
                        }

                        // Aggiungi il personaggio alla campagna
                        personaggiRef.update("personaggi", FieldValue.arrayUnion(nomePersonaggioSelezionato))
                            .addOnSuccessListener {
                                // Il personaggio è stato aggiunto con successo all'array "personaggi"
                            }
                            .addOnFailureListener { exception ->
                                Log.e(TAG, "Errore nella scrittura del personaggio su Firestore: ", exception)
                            }

                        // Aggiungi l'ID dell'utente corrente all'array "partecipanti"
                        personaggiRef.update("partecipanti", FieldValue.arrayUnion(currentUser?.uid))
                            .addOnSuccessListener {
                                // L'utente corrente è stato aggiunto con successo all'array "partecipanti"
                            }
                            .addOnFailureListener { exception ->
                                Log.e(TAG, "Errore nella scrittura del partecipante su Firestore: ", exception)
                            }
                    }
                    .addOnFailureListener { exception ->
                        Log.e(TAG, "Errore nella lettura dei personaggi della campagna su Firestore: ", exception)
                    }
            }
    }


    companion object {
        private const val TAG = "com.progetto_dd.view.campaigns.HomeCampaignsFragment"
    }
}
