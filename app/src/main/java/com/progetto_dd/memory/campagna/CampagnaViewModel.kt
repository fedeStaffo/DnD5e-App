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
import com.progetto_dd.memory.personaggio.Personaggio

class CampagnaViewModel : ViewModel() {

    // Riferimenti alle collezioni nel database
    private val campagneRef = FirebaseFirestore.getInstance().collection("campagne")
    private val personaggiRef = FirebaseFirestore.getInstance().collection("personaggi")

    // Riferimento all'utente loggato
    private val currentUser: FirebaseUser? = FirebaseAuth.getInstance().currentUser

    // Variabile per il nome della campagna
    private val _nomeCampagna = MutableLiveData<String>()
    val nomeCampagna: LiveData<String>
        get() = _nomeCampagna

    fun setNomeCampagna(nome: String) {
        _nomeCampagna.value = nome
    }

    // Variabile per il nome del Master
    private val _nomeMaster = MutableLiveData<String>()
    val nomeMaster: LiveData<String>
        get() = _nomeMaster

    fun setNomeMaster(nome: String) {
        _nomeMaster.value = nome
    }

    // Variabile per il MasterId
    private val _nomeMasterId = MutableLiveData<String>()
    val nomeMasterId: LiveData<String>
        get() = _nomeMasterId

    fun setNomeMasterId(nome: String) {
        _nomeMasterId.value = nome
    }

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
    fun getPersonaggiByCampagna(nomeCampagna: String): LiveData<List<Personaggio>> {
        // Crea un oggetto MutableLiveData per poter aggiornare i dati in modo asincrono
        val mutableLiveData = MutableLiveData<List<Personaggio>>()

        // Query per ottenere i documenti delle campagne che corrispondono al nome specificato
        val campagneQuery = campagneRef.whereEqualTo("nome", nomeCampagna)

        // Aggiunge un listener per gli snapshot delle campagne
        campagneQuery.addSnapshotListener { campagneSnapshot, campagneError ->
            // Se si verifica un errore, lo stampa nel log e ritorna
            if (campagneError != null) {
                Log.w(TAG, "Listen failed for campagne.", campagneError)
                return@addSnapshotListener
            }

            // Se lo snapshot delle campagne non è nullo e contiene almeno un documento
            if (campagneSnapshot != null && !campagneSnapshot.isEmpty) {
                val campagnaDocument = campagneSnapshot.documents[0]
                val personaggi = campagnaDocument.get("personaggi") as? List<String>

                // Se il campo "personaggi" è presente e non è vuoto
                if (personaggi != null && personaggi.isNotEmpty()) {
                    // Query per ottenere i personaggi la cui ID è presente nell'array "personaggi" della campagna
                    val personaggiQuery = personaggiRef.whereIn("nome", personaggi).whereEqualTo("campagna", nomeCampagna)

                    // Aggiunge un listener per gli snapshot dei personaggi
                    personaggiQuery.addSnapshotListener { personaggiSnapshot, personaggiError ->
                        // Se si verifica un errore, lo stampa nel log e ritorna
                        if (personaggiError != null) {
                            Log.w(TAG, "Listen failed for personaggi.", personaggiError)
                            return@addSnapshotListener
                        }

                        // Se lo snapshot dei personaggi non è nullo, crea una lista di personaggi a partire dallo snapshot
                        if (personaggiSnapshot != null) {
                            val personaggiList = personaggiSnapshot.toObjects(Personaggio::class.java)
                            // Aggiorna l'oggetto MutableLiveData con la nuova lista di personaggi
                            mutableLiveData.postValue(personaggiList)
                        } else {
                            // Se lo snapshot dei personaggi è nullo, lo stampa nel log
                            Log.d(TAG, "Current data for personaggi: null")
                        }
                    }
                } else {
                    // Se il campo "personaggi" non è presente o è vuoto, imposta l'oggetto MutableLiveData come lista vuota
                    mutableLiveData.postValue(emptyList())
                }
            } else {
                // Se lo snapshot delle campagne è nullo o non contiene documenti, imposta l'oggetto MutableLiveData come lista vuota
                mutableLiveData.postValue(emptyList())
            }
        }

        // Restituisce l'oggetto MutableLiveData come oggetto LiveData
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

                // Aggiungi l'ID dell'utente corrente all'array "partecipanti"
                campagneRef.document(campagnaId)
                    .update("partecipanti", FieldValue.arrayUnion(currentUser?.uid))
                    .addOnSuccessListener {
                        // L'utente corrente è stato aggiunto con successo all'array "partecipanti"

                        // Aggiungi il nome del personaggio all'array "personaggi"
                        campagneRef.document(campagnaId)
                            .update("personaggi", FieldValue.arrayUnion(nomePersonaggioSelezionato))
                            .addOnSuccessListener {
                                // Il personaggio è stato aggiunto con successo all'array "personaggi"
                            }
                            .addOnFailureListener { exception ->
                                Log.e(TAG, "Errore nella scrittura del personaggio su Firestore: ", exception)
                            }
                    }
                    .addOnFailureListener { exception ->
                        Log.e(TAG, "Errore nella scrittura del partecipante su Firestore: ", exception)
                    }
            }
    }



    fun aggiungiCampagnaAPersonaggio(nomePersonaggio: String, nomeCampagna: String) {

        // Query per ottenere il riferimento al personaggio con il nome specificato
        val query = personaggiRef.whereEqualTo("nome", nomePersonaggio)

        query.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot.documents) {
                // Aggiungi il nome della campagna al campo "campagna" del personaggio
                document.reference.update("campagna", nomeCampagna)
                    .addOnSuccessListener {
                        // Aggiornamento riuscito
                    }
                    .addOnFailureListener { exception ->
                        // Errore durante l'aggiornamento
                        Log.e(TAG, "Errore durante l'aggiornamento del personaggio: ", exception)
                    }
            }
        }.addOnFailureListener { exception ->
            // Errore durante la query
            Log.e(TAG, "Errore durante la ricerca del personaggio: ", exception)
        }
    }




    companion object {
        private const val TAG = "com.progetto_dd.view.campaigns.HomeCampaignsFragment"
    }
}
