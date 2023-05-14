package com.progetto_dd.memory.personaggio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PersonaggioViewModel : ViewModel() {

    private val personaggiRef = FirebaseFirestore.getInstance().collection("personaggi")
    private val currentUser = FirebaseAuth.getInstance().currentUser

    // Funzione che restituisce un oggetto LiveData contenente una lista di Personaggi
    fun getPersonaggi(): LiveData<List<Personaggio>> {

        // Crea un oggetto MutableLiveData per poter aggiornare i dati in modo asincrono
        val mutableLiveData = MutableLiveData<List<Personaggio>>()

        // Query per leggere i personaggi dell'utente corrente da Firestore
        val personaggiQuery = personaggiRef.whereEqualTo("utenteId", currentUser?.uid)

        // Aggiunge un listener per gli snapshot del Firestore
        personaggiQuery.addSnapshotListener { snapshot, e ->
            // Se si verifica un errore, lo stampa nel log e ritorna
            if (e != null) {
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            // Se lo snapshot non è nullo, crea una lista di personaggi a partire dallo snapshot
            if (snapshot != null) {
                val personaggi = snapshot.toObjects(Personaggio::class.java)
                // Aggiorna l'oggetto MutableLiveData con la nuova lista di personaggi
                mutableLiveData.postValue(personaggi)
            } else {
                // Se lo snapshot è nullo, lo stampa nel log
                Log.d(TAG, "Current data: null")
            }
        }

        // Restituisce l'oggetto MutableLiveData come oggetto LiveData
        return mutableLiveData
    }

    companion object {
        private const val TAG = "com.progetto_dd.view.characters.HomeCharacterFragment"
    }
}
