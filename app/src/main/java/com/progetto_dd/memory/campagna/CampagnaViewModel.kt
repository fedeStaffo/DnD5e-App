package com.progetto_dd.memory.campagna

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import com.progetto_dd.memory.npc.NpcViewModel
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

    fun checkExistingCampaign(campaignName: String): LiveData<Boolean> {
        // Crea un'istanza di MutableLiveData<Boolean> per il risultato
        val resultLiveData = MutableLiveData<Boolean>()

        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "campagne"
        val campaignsCollection = db.collection("campagne")

        // Ottieni l'ID dell'utente corrente
        val userId = currentUser?.uid

        // Esegui la query per verificare l'esistenza di una campagna con il nome specificato e il masterId corrispondente all'ID dell'utente corrente
        campaignsCollection
            .whereEqualTo("masterId", userId)
            .whereEqualTo("nome", campaignName)
            .get()
            .addOnSuccessListener { querySnapshot ->
                resultLiveData.value = !querySnapshot.isEmpty // Imposta il valore dell'oggetto LiveData in base al fatto che la query abbia restituito risultati o meno
            }
            .addOnFailureListener {
                resultLiveData.value = false             // In caso di errore, impostare il valore dell'oggetto LiveData su "false"
            }
        // Restituisci l'oggetto LiveData che rappresenta il risultato della query
        return resultLiveData
    }


    fun getCampagne(): LiveData<List<Campagna>> {
        // Crea un'istanza di MutableLiveData<List<Campagna>> per i risultati
        val mutableLiveData = MutableLiveData<List<Campagna>>()

        // Ottieni l'ID dell'utente corrente
        val userId = currentUser?.uid

        // Crea una query per ottenere le campagne gestite dall'utente corrente
        val campagneQueryMaster = campagneRef.whereEqualTo("masterId", userId)

        // Crea una query per ottenere le campagne in cui l'utente corrente è un partecipante
        val campagneQueryPlayer = userId?.let { campagneRef.whereArrayContains("partecipanti", it) }

        // Esegui le due query in parallelo
        val campagneMasterTask = campagneQueryMaster.get()
        val campagnePlayerTask = campagneQueryPlayer?.get()

        // Attendi il completamento di entrambe le query
        Tasks.whenAllComplete(campagneMasterTask, campagnePlayerTask)
            .addOnSuccessListener { results ->
                // Ottieni i risultati delle query come liste di oggetti Campagna
                val campagneMaster = campagneMasterTask.result?.toObjects(Campagna::class.java)
                val campagnePlayer = campagnePlayerTask?.result?.toObjects(Campagna::class.java)

                // Crea una lista mutabile di oggetti Campagna
                val campagne = mutableListOf<Campagna>()

                // Aggiungi le campagne gestite dall'utente corrente alla lista
                campagneMaster?.let { campagne.addAll(it) }

                // Aggiungi le campagne in cui l'utente corrente è un partecipante alla lista
                campagnePlayer?.let { campagne.addAll(it) }

                // Aggiorna il valore dell'oggetto MutableLiveData con la lista di campagne
                mutableLiveData.postValue(campagne)
            }
            .addOnFailureListener { exception ->
                // In caso di errore, registra un messaggio di log
                Log.e(TAG, "Errore nella lettura delle campagne da Firestore: ", exception)
            }

        // Restituisci l'oggetto MutableLiveData che rappresenta i risultati della query
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

            // Se non ci sono personaggi, restituisci una lista vuota direttamente
            if (nomiPersonaggi.isEmpty()) {
                mutableLiveData.postValue(emptyList())
                return@addOnSuccessListener
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

                if (partecipanti?.contains(currentUser?.uid) == true) {
                    // L'utente corrente è già un partecipante della campagna
                    Toast.makeText(context, "Partecipi già a questa campagna", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }

                val userId = currentUser?.uid
                val campagnaMasterId = campagnaDocument.getString("masterId")

                if (userId == campagnaMasterId) {
                    // L'utente corrente è il master della campagna
                    Toast.makeText(context, "Sei già il master di questa campagna", Toast.LENGTH_SHORT).show()
                    return@addOnSuccessListener
                }

                val updates = mutableMapOf<String, Any>()
                updates["partecipanti"] = FieldValue.arrayUnion(userId)
                updates["personaggi"] = FieldValue.arrayUnion(nomePersonaggioSelezionato)

                // Aggiorna i campi "partecipanti" e "personaggi" nell'array "campagne"
                campagneRef.document(campagnaId)
                    .update(updates)
                    .addOnSuccessListener {
                        // L'utente corrente è stato aggiunto con successo all'array "partecipanti"
                        // Il personaggio è stato aggiunto con successo all'array "personaggi"
                    }
                    .addOnFailureListener { exception ->
                        Log.e(TAG, "Errore nella scrittura del partecipante o del personaggio su Firestore: ", exception)
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

    fun rimuoviPersonaggioDaCampagna(personaggio: String, nomeCampagna: String, masterId: String) {
        val db = FirebaseFirestore.getInstance()
        val campagneCollection = db.collection("campagne")

        val query = campagneCollection
            .whereEqualTo("nome", nomeCampagna)
            .whereEqualTo("masterId", masterId)

        query.get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    val campagnaDocument = querySnapshot.documents[0]
                    val campagnaDocumentRef = campagneCollection.document(campagnaDocument.id)

                    campagnaDocumentRef.get()
                        .addOnSuccessListener { documentSnapshot ->
                            val personaggiList = documentSnapshot.get("personaggi") as? MutableList<String>

                            personaggiList?.let {
                                it.remove(personaggio)

                                campagnaDocumentRef.update("personaggi", it)
                            }
                        }
                }
            }
    }

    fun aggiornaCampagnaPersonaggio(personaggio: String, nomeCampagna: String) {
        val db = FirebaseFirestore.getInstance()
        val personaggiCollection = db.collection("personaggi")
        val campagneCollection = db.collection("campagne")

        personaggiCollection
            .whereEqualTo("nome", personaggio)
            .whereEqualTo("campagna", nomeCampagna)
            .get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    val personaggioDocument = querySnapshot.documents[0]
                    val personaggioDocumentRef = personaggiCollection.document(personaggioDocument.id)

                    personaggioDocumentRef.update("campagna", "")

                    val partecipantiList = campagneCollection
                        .whereEqualTo("nome", nomeCampagna)
                        .get()
                        .addOnSuccessListener { querySnapshot ->
                            if (!querySnapshot.isEmpty) {
                                val campagnaDocument = querySnapshot.documents[0]
                                val campagnaDocumentRef = campagneCollection.document(campagnaDocument.id)

                                val partecipantiList = campagnaDocument["partecipanti"] as MutableList<String>
                                partecipantiList.remove(personaggioDocument["utenteId"].toString())

                                campagnaDocumentRef.update("partecipanti", partecipantiList)
                            }
                        }
                }
            }
    }

    fun eliminaGiocatoreDaCampagna(personaggio: String, nomeCampagna: String, masterId: String) {
        // Rimuovi il personaggio dalla campagna specificata chiamando la funzione rimuoviPersonaggioDaCampagna
        rimuoviPersonaggioDaCampagna(personaggio, nomeCampagna, masterId)

        // Aggiorna la campagna del personaggio chiamando la funzione aggiornaCampagnaPersonaggio
        aggiornaCampagnaPersonaggio(personaggio, nomeCampagna)
    }



    fun getPasswordByCampagna(nomeCampagna: String, masterId: String): MutableLiveData<String?> {
        // Crea un oggetto MutableLiveData per poter aggiornare i dati in modo asincrono
        val mutableLiveData = MutableLiveData<String?>()

        // Query per ottenere il documento della campagna che corrisponde al nome e masterId specificati
        val campagneQuery = campagneRef.whereEqualTo("nome", nomeCampagna).whereEqualTo("masterId", masterId)

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
                val password = campagnaDocument.getString("password")

                // Se il campo "password" è presente
                if (password != null) {
                    // Aggiorna l'oggetto MutableLiveData con la nuova password
                    mutableLiveData.postValue(password)
                } else {
                    // Se il campo "password" non è presente, imposta l'oggetto MutableLiveData come stringa vuota
                    mutableLiveData.postValue("")
                }
            } else {
                // Se lo snapshot delle campagne è nullo o non contiene documenti, imposta l'oggetto MutableLiveData come stringa vuota
                mutableLiveData.postValue("")
            }
        }

        // Restituisce l'oggetto MutableLiveData come oggetto LiveData
        return mutableLiveData
    }


    fun updateCampagnaPassword(nomeCampagna: String, masterId: String, password: String) {
        // Crea una query per ottenere la campagna con il nome specificato e il masterId corrispondente
        val query = campagneRef.whereEqualTo("nome", nomeCampagna).whereEqualTo("masterId", masterId)

        // Esegue la query
        query.get().addOnSuccessListener { querySnapshot ->
            if (querySnapshot.isEmpty) {
                // La campagna non esiste o il masterId non corrisponde
                return@addOnSuccessListener
            }

            // Ottiene il documento della campagna dalla prima riga dei risultati della query
            val campagnaDocument = querySnapshot.documents[0]
            val campagnaId = campagnaDocument.id

            // Crea un HashMap per contenere gli aggiornamenti da applicare al documento
            val updates = hashMapOf<String, Any>(
                "password" to password
            )

            // Esegue l'aggiornamento del documento della campagna con la nuova password
            campagneRef.document(campagnaId).update(updates)
        }
    }


    fun eliminaCampagna(nomeCampagna: String, masterId: String) {
        // Query per ottenere la campagna con il nome e masterId specificati
        val campagnaQuery = campagneRef.whereEqualTo("nome", nomeCampagna).whereEqualTo("masterId", masterId)

        // Aggiunge un listener per lo snapshot della campagna
        campagnaQuery.get().addOnSuccessListener { campagneSnapshot ->
            // Se lo snapshot non è nullo e contiene almeno un documento
            if (campagneSnapshot != null && !campagneSnapshot.isEmpty) {
                val campagnaDocument = campagneSnapshot.documents[0]
                val campagnaId = campagnaDocument.id

                // Ottieni il campo "personaggi" della campagna
                val personaggi = campagnaDocument.get("personaggi") as? List<String>

                // Verifica se l'elenco personaggi è vuoto o non esiste
                if (personaggi.isNullOrEmpty()) {
                    // Elimina il documento della campagna direttamente
                    campagneRef.document(campagnaId).delete()
                } else {
                    // Setta a vuoto il campo "campagna" di tutti i personaggi che hanno come valore del campo "campagna" il nomeCampagna specificato
                    val personaggiQuery = personaggiRef.whereIn("nome", personaggi).whereEqualTo("campagna", nomeCampagna)
                    personaggiQuery.get().addOnSuccessListener { personaggiSnapshot ->
                        val updateTasks = mutableListOf<Task<Void>>()
                        for (personaggioDocument in personaggiSnapshot.documents) {
                            val updateTask = personaggioDocument.reference.update("campagna", "")
                            updateTasks.add(updateTask)
                        }

                        // Quando tutte le operazioni di aggiornamento sono completate, elimina la campagna
                        Tasks.whenAll(updateTasks)
                            .addOnSuccessListener {
                                campagneRef.document(campagnaId).delete()
                            }
                    }
                }
            }
        }
    }


    // Confronta l'id del giocatore attuale con quello del master
    fun isCurrentPlayerMaster(masterId: String): Boolean {
        val currentUser = FirebaseAuth.getInstance().currentUser
        val currentUserId = currentUser?.uid

        return currentUserId == masterId
    }


    companion object {
        private const val TAG = "com.progetto_dd.view.campaigns.HomeCampaignsFragment"
    }
}
