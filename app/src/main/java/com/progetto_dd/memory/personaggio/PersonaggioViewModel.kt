package com.progetto_dd.memory.personaggio

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PersonaggioViewModel : ViewModel() {

    // Riferimenti alle collezioni nel database
    private val personaggiRef = FirebaseFirestore.getInstance().collection("personaggi")
    private val razzeRef = FirebaseFirestore.getInstance().collection("razze")
    private val classiRef = FirebaseFirestore.getInstance().collection("classi")

    // Riferimento all'utente loggato
    private val currentUser = FirebaseAuth.getInstance().currentUser

    // Variabile per la stringa inserita nella TextInputEditText del NameCharacterFragment
    private val _nomePersonaggio = MutableLiveData<String>()
    val nomePersonaggio: LiveData<String>
        get() = _nomePersonaggio

    // Funzione per salvare la stringa inserita nella TextInputEditText
    fun setNomePersonaggio(nome: String) {
        _nomePersonaggio.value = nome
    }

    // Variabile per la razza
    private val _razzaPersonaggio = MutableLiveData<String>()
    val razzaPersonaggio: LiveData<String>
        get() = _razzaPersonaggio

    // Funzione per salvare la razza
    fun setRazzaPersonaggio(razza: String) {
        _razzaPersonaggio.value = razza
    }

    // Variabile per la classe
    private val _classePersonaggio = MutableLiveData<String>()
    val classePersonaggio: LiveData<String>
        get() = _classePersonaggio

    // Funzione per salvare la classe
    fun setClassePersonaggio(classe: String) {
        _classePersonaggio.value = classe
    }

    // Variabile per le competenze
    private val _competenzePersonaggio = MutableLiveData<Set<String>>()
    val competenzePersonaggio: LiveData<Set<String>> get() = _competenzePersonaggio

    // Funzione per salvare le competenze
    fun setCompetenzePersonaggio(competenze: Set<String>) {
        _competenzePersonaggio.value = competenze
    }

    // Funzione che restituisce un oggetto LiveData contenente una lista di Personaggi
    // da usare per la recycler view dove vengono visualizzati tutti i personaggi di un utente
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

    // Metodo per ottenere informazioni sulla razza prendendole da Firestore
    fun getInfoRazza(razza: String): MutableLiveData<String?> {

        // Crea un oggetto MutableLiveData per poter aggiornare i dati in modo asincrono
        val mutableLiveData = MutableLiveData<String?>()

        // Query per leggere la razza dalla collezione "razze" di Firestore
        val razzaQuery = razzeRef.document(razza)

        razzaQuery.addSnapshotListener { snapshot, e ->
            // Se si verifica un errore, lo stampa nel log e ritorna
            if (e != null) {
                Log.w(TAG_RACE, "Listen failed.", e)
                return@addSnapshotListener
            }

            // Se lo snapshot non è nullo, estrae il campo "info" e lo aggiorna nell'oggetto MutableLiveData
            if (snapshot != null && snapshot.exists()) {
                val info = snapshot.getString("info")
                mutableLiveData.postValue(info)
            } else {
                // Se lo snapshot è nullo o non esiste, lo stampa nel log
                Log.d(TAG_RACE, "Current data: null")
            }
        }

        // Restituisce l'oggetto MutableLiveData come oggetto LiveData
        return mutableLiveData
    }

    // Funzione per leggere dal database le info della classe
    fun getInfoClasse(classe: String): MutableLiveData<String?> {

        // Crea un oggetto MutableLiveData per poter aggiornare i dati in modo asincrono
        val mutableLiveData = MutableLiveData<String?>()

        // Query per leggere la classe dalla collezione "classi" di Firestore
        val classeQuery = classiRef.document(classe)

        classeQuery.addSnapshotListener { snapshot, e ->
            // Se si verifica un errore, lo stampa nel log e ritorna
            if (e != null) {
                Log.w(TAG_CLASS, "Listen failed.", e)
                return@addSnapshotListener
            }

            // Se lo snapshot non è nullo, estrae il campo "info" e lo aggiorna nell'oggetto MutableLiveData
            if (snapshot != null && snapshot.exists()) {
                val info = snapshot.getString("info")
                mutableLiveData.postValue(info)
            } else {
                // Se lo snapshot è nullo o non esiste, lo stampa nel log
                Log.d(TAG_CLASS, "Current data: null")
            }
        }

        // Restituisce l'oggetto MutableLiveData come oggetto LiveData
        return mutableLiveData
    }

    companion object {
        private const val TAG = "com.progetto_dd.view.characters.HomeCharacterFragment"
        private const val TAG_RACE = "com.progetto_dd.view.characters.RaceFragment"
        private const val TAG_CLASS = "com.progetto_dd.view.characters.ClassFragment"
    }
}
