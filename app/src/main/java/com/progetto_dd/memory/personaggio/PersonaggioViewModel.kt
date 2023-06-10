package com.progetto_dd.memory.personaggio

import android.content.Context
import android.util.Log
import android.widget.Toast
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
    private val _competenzePersonaggio = MutableLiveData<List<String>>()
    val competenzePersonaggio: LiveData<List<String>> get() = _competenzePersonaggio

    // Funzione per salvare le competenze
    fun setCompetenzePersonaggio(competenze: List<String>) {
        _competenzePersonaggio.value = competenze
    }

    // Stringa per la descrizione
    private val _backgroundDescrizione = MutableLiveData<String>()
    val backgroundDescrizione: LiveData<String> get() = _backgroundDescrizione

    // Funzione per salvare la descrizione
    fun setBackgroundDescrizione(descrizione: String){
        _backgroundDescrizione.value = descrizione
    }

    // Stringa per la storia
    private val _backgroundStoria = MutableLiveData<String>()
    val backgroundStoria: LiveData<String> get() = _backgroundStoria

    // Funzione per salvare la storia
    fun setBackgroundStoria(storia: String){
        _backgroundStoria.value = storia
    }

    // Stringa per i tratti caratteriali
    private val _backgroundTratti = MutableLiveData<String>()
    val backgroundTratti: LiveData<String> get() = _backgroundTratti

    // Funzione per salvare i tratti caratteriali
    fun setBackgroundTratti(tratti: String){
        _backgroundTratti.value = tratti
    }

    // Stringa per i difetti
    private val _backgroundDifetti = MutableLiveData<String>()
    val backgroundDifetti: LiveData<String> get() = _backgroundDifetti

    // Funzione per salvare i tratti caratteriali
    fun setBackgroundDifetti(difetti: String){
        _backgroundDifetti.value = difetti
    }

    // Stringa per gli ideali
    private val _backgroundIdeali = MutableLiveData<String>()
    val backgroundIdeali: LiveData<String> get() = _backgroundIdeali

    // Funzione per salvare i tratti caratteriali
    fun setBackgroundIdeali(ideali: String){
        _backgroundIdeali.value = ideali
    }

    // Stringa per i legami
    private val _backgroundLegami = MutableLiveData<String>()
    val backgroundLegami: LiveData<String> get() = _backgroundLegami

    // Funzione per salvare i tratti caratteriali
    fun setBackgroundLegami(legami: String){
        _backgroundLegami.value = legami
    }

    // Stringa per i legami
    private val _backgroundAllineamento = MutableLiveData<String>()
    val backgroundAllineamento: LiveData<String> get() = _backgroundAllineamento

    // Funzione per salvare i tratti caratteriali
    fun setBackgroundAllineamento(allineamento: String){
        _backgroundAllineamento.value = allineamento
    }

    // Getter e setter per tutti i modificatori
    private val _modForza = MutableLiveData<Int>()
    val modForza: LiveData<Int> get() = _modForza

    fun setModForza(forza: Int){
        _modForza.value = forza
    }

    private val _modDestrezza = MutableLiveData<Int>()
    val modDestrezza: LiveData<Int> get() = _modDestrezza

    fun setModDestrezza(destrezza: Int){
        _modDestrezza.value = destrezza
    }

    private val _modCostituzione = MutableLiveData<Int>()
    val modCostituzione: LiveData<Int> get() = _modCostituzione

    fun setModCostituzione(costituzione: Int){
        _modCostituzione.value = costituzione
    }

    private val _modIntelligenza = MutableLiveData<Int>()
    val modIntelligenza: LiveData<Int> get() = _modIntelligenza

    fun setModIntelligenza(intelligenza: Int){
        _modIntelligenza.value = intelligenza
    }

    private val _modSaggezza = MutableLiveData<Int>()
    val modSaggezza: LiveData<Int> get() = _modSaggezza

    fun setModSaggezza(saggezza: Int){
        _modSaggezza.value = saggezza
    }

    private val _modCarisma = MutableLiveData<Int>()
    val modCarisma: LiveData<Int> get() = _modCarisma

    fun setModCarisma(carisma: Int){
        _modCarisma.value = carisma
    }

    // Lista per l'equipaggiamento
    private val _equipaggiamento = MutableLiveData<List<String?>?>()
    val equipaggiamento: LiveData<List<String?>?>
        get() = _equipaggiamento

    fun setEquipaggiamento(equipaggiamentoList: List<String?>?) {
        _equipaggiamento.value = equipaggiamentoList
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

    fun saveCharacterToFirestore() {
        val db = FirebaseFirestore.getInstance()
        val personaggiRef = db.collection("personaggi")

        val slots: List<Int> = listOf(0, 0, 0, 0, 0, 0, 0, 0, 0)
        val magie: List<String> = emptyList()

        val character = hashMapOf<String, Any?>(
            "classe" to this.classePersonaggio.value,
            "nome" to this.nomePersonaggio.value,
            "razza" to this.razzaPersonaggio.value,
            "utenteId" to this.currentUser?.uid,
            "competenze" to this.competenzePersonaggio.value,
            "descrizione" to this.backgroundDescrizione.value,
            "storia" to this.backgroundStoria.value,
            "tratti" to this.backgroundTratti.value,
            "difetti" to this.backgroundDifetti.value,
            "ideali" to this.backgroundIdeali.value,
            "legami" to this.backgroundLegami.value,
            "allineamento" to this.backgroundAllineamento.value,
            "forza" to this.modForza.value,
            "destrezza" to this.modDestrezza.value,
            "costituzione" to this.modCostituzione.value,
            "intelligenza" to this.modIntelligenza.value,
            "saggezza" to this.modSaggezza.value,
            "carisma" to this.modCarisma.value,
            "equipaggiamento" to this.equipaggiamento.value,

            "stato" to "Nessuno",
            "vitaMax" to 0,
            "vita" to 0,
            "livello" to 1,
            "classeArmatura" to 0,
            "campagna" to "",
            "slotTot" to slots,
            "slotUsati" to slots,
            "magie" to magie
        )

        personaggiRef.add(character)
    }

    fun aggiungiEquipaggiamento(nomePersonaggio: String, nomeCampagna: String, nuovoOggetto: String) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi"
        val personaggiRef = db.collection("personaggi")

        // Ottieni la lista attuale di equipaggiamento dal MutableLiveData
        val equipaggiamentoList = _equipaggiamento.value?.toMutableList() ?: mutableListOf()
        equipaggiamentoList.add(nuovoOggetto)

        // Esegui una query per ottenere il personaggio corrispondente al nome e alla campagna specificati
        val personaggioQuery = personaggiRef
            .whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("campagna", nomeCampagna)

        personaggioQuery.get().addOnSuccessListener { querySnapshot ->
            if (!querySnapshot.isEmpty) {
                val documentSnapshot = querySnapshot.documents[0]
                val personaggioId = documentSnapshot.id

                // Crea un HashMap con i dati da aggiornare nel documento del personaggio
                val updateData = hashMapOf<String, Any>(
                    "equipaggiamento" to equipaggiamentoList
                )

                // Esegui l'aggiornamento del documento del personaggio con i nuovi dati
                personaggiRef.document(personaggioId)
                    .update(updateData)
            }
        }
    }


    fun updatePersonaggioStato(nomePersonaggio: String, nomeCampagna: String, nuovoStato: String) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi"
        val personaggiRef = db.collection("personaggi")

        // Esegui una query per ottenere i documenti dei personaggi corrispondenti al nome e alla campagna specificati
        val query = personaggiRef.whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("campagna", nomeCampagna)

        query.get().addOnSuccessListener { documents ->
            for (document in documents) {
                // Modifica il campo "stato" del personaggio con il nuovo stato
                document.reference.update("stato", nuovoStato)
            }
        }
    }

    fun deletePersonaggio(nome: String, razza: String, classe: String, utenteId: String, campagna: String): LiveData<Boolean> {
        // Crea un oggetto MutableLiveData<Boolean> per indicare se la cancellazione è avvenuta con successo o meno
        val deletionLiveData = MutableLiveData<Boolean>()

        // Controlla se la campagna è specificata, se sì restituisci immediatamente "false"
        if (campagna != "") {
            deletionLiveData.value = false
            return deletionLiveData
        }

        // Esegui una query per ottenere i documenti dei personaggi corrispondenti ai parametri specificati
        val query = personaggiRef
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)
            .whereEqualTo("campagna", campagna)

        query.get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    // Elimina il documento del personaggio
                    personaggiRef.document(document.id).delete()
                        .addOnSuccessListener {
                            // Imposta il valore di "deletionLiveData" su "true" per indicare la cancellazione avvenuta con successo
                            deletionLiveData.value = true
                        }
                        .addOnFailureListener { exception ->
                            // Imposta il valore di "deletionLiveData" su "false" in caso di errore durante la cancellazione
                            deletionLiveData.value = false
                        }
                }
            }
            .addOnFailureListener { exception ->
                // Imposta il valore di "deletionLiveData" su "false" in caso di errore durante la query
                deletionLiveData.value = false
            }

        return deletionLiveData
    }


    fun updateCampoNumerico(
        nome: String,
        razza: String,
        classe: String,
        utenteId: String,
        nomeCampo: String,
        nuovoValore: Number
    ) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi"
        val personaggiRef = db.collection("personaggi")

        // Esegui una query per ottenere i documenti dei personaggi corrispondenti ai parametri specificati
        personaggiRef
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)
            .get()
            .addOnSuccessListener { querySnapshot ->
                if (querySnapshot.isEmpty) {
                    // Nessun documento trovato con i parametri specificati
                    return@addOnSuccessListener
                }

                // Ottieni il primo documento trovato
                val document = querySnapshot.documents.first()
                val documentId = document.id

                // Crea un oggetto contenente il campo da aggiornare e il nuovo valore
                val updateData = mapOf(nomeCampo to nuovoValore)

                // Aggiorna il documento con i nuovi dati
                personaggiRef.document(documentId)
                    .update(updateData)
            }
    }

    fun updateCampoString(
        nome: String,
        razza: String,
        classe: String,
        utenteId: String,
        campo: String,
        nuovoValore: String
    ) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            // Itera sui documenti restituiti dalla query
            for (document in querySnapshot) {
                // Aggiorna il campo specificato con il nuovo valore nel documento corrente
                document.reference.update(campo, nuovoValore)
            }
        }
    }


    fun addEquipaggiamentoToPersonaggio(
        nome: String,
        razza: String,
        classe: String,
        utenteId: String,
        nuovoOggetto: String
    ) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            // Itera sui documenti restituiti dalla query
            for (document in querySnapshot) {
                // Ottieni l'array di equipaggiamento dal documento corrente
                val equipaggiamento = document.get("equipaggiamento") as? ArrayList<String>

                // Aggiungi il nuovo oggetto all'array di equipaggiamento, se presente
                equipaggiamento?.add(nuovoOggetto)

                // Aggiorna il campo "equipaggiamento" con l'array aggiornato nel documento corrente
                document.reference.update("equipaggiamento", equipaggiamento)
            }
        }
    }


    fun removeEquipaggiamentoFromPersonaggio(
        nome: String,
        razza: String,
        classe: String,
        utenteId: String,
        oggettoDaRimuovere: String
    ): LiveData<Boolean> {
        // Crea un oggetto LiveData per restituire il risultato della rimozione
        val removeResult = MutableLiveData<Boolean>()

        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            // Itera sui documenti restituiti dalla query
            for (document in querySnapshot) {
                // Ottieni l'array di equipaggiamento dal documento corrente
                val equipaggiamento = document.get("equipaggiamento") as? ArrayList<String>

                // Rimuovi l'oggetto specificato dall'array di equipaggiamento, se presente
                equipaggiamento?.remove(oggettoDaRimuovere)

                // Aggiorna il campo "equipaggiamento" con l'array aggiornato nel documento corrente
                document.reference.update("equipaggiamento", equipaggiamento)
                    .addOnSuccessListener {
                        // L'oggetto è stato rimosso correttamente
                        removeResult.value = true
                    }
                    .addOnFailureListener {
                        // Si è verificato un errore durante la rimozione dell'oggetto
                        removeResult.value = false
                    }
            }
        }

        // Restituisci l'oggetto LiveData che conterrà il risultato della rimozione
        return removeResult
    }

    fun addIncantesimoToPersonaggio(
        context: Context,
        nome: String,
        razza: String,
        classe: String,
        utenteId: String,
        nuovaMagia: String
    ) {
        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            // Itera sui documenti restituiti dalla query
            for (document in querySnapshot) {
                // Ottieni l'array di magie dal documento corrente
                val magie = document.get("magie") as? ArrayList<String>

                if (magie == null || !magie.contains(nuovaMagia)) {
                    // Se l'array di magie è nullo o non contiene già la nuova magia, aggiungila all'array
                    magie?.add(nuovaMagia)

                    // Aggiorna il campo "magie" con l'array aggiornato nel documento corrente
                    document.reference.update("magie", magie)

                    Toast.makeText(context, "Magia aggiunta correttamente", Toast.LENGTH_SHORT).show()
                } else {
                    // Se l'array di magie contiene già la nuova magia, mostra un messaggio di avviso
                    Toast.makeText(context, "La magia esiste già", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    fun removeIncantesimoFromPersonaggio(
        context: Context,
        nome: String,
        razza: String,
        classe: String,
        utenteId: String,
        magiaDaRimuovere: String
    ): LiveData<Boolean> {
        val removeResult = MutableLiveData<Boolean>()

        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            // Itera sui documenti restituiti dalla query
            for (document in querySnapshot) {
                // Ottieni l'array di magie dal documento corrente
                val magie = document.get("magie") as? ArrayList<String>

                if (magie != null && magie.contains(magiaDaRimuovere)) {
                    // Se l'array di magie non è nullo e contiene la magia da rimuovere, rimuovila dall'array
                    magie.remove(magiaDaRimuovere)

                    // Aggiorna il campo "magie" con l'array aggiornato nel documento corrente
                    document.reference.update("magie", magie)
                        .addOnSuccessListener {
                            // L'oggetto è stato rimosso correttamente
                            removeResult.value = true

                            Toast.makeText(context, "Magia rimossa correttamente", Toast.LENGTH_SHORT).show()
                        }
                        .addOnFailureListener {
                            // Si è verificato un errore durante la rimozione dell'oggetto
                            removeResult.value = false

                            Toast.makeText(context, "Errore nella rimozione della magia", Toast.LENGTH_SHORT).show()
                        }
                } else {
                    // Se l'array di magie è nullo o non contiene la magia da rimuovere, mostra un messaggio di avviso
                    Toast.makeText(context, "La magia non è presente", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return removeResult
    }


    fun getMagieFromFirestore(nomePersonaggio: String, utenteId: String): LiveData<List<String>> {
        val mutableLiveData = MutableLiveData<List<String>>()

        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val collection = db.collection("personaggi")
        val query = collection.whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        query.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val result = mutableListOf<String>()
                for (document in task.result) {
                    // Ottieni l'array di magie dal documento corrente
                    val magie = document.get("magie") as? List<String>
                    if (magie != null) {
                        // Aggiungi le magie all'elenco dei risultati
                        result.addAll(magie)
                    }
                }
                mutableLiveData.value = result
            } else {
                // Gestisci il caso di errore
                mutableLiveData.value = emptyList()
            }
        }

        return mutableLiveData
    }


    fun getSlotTotArray(nomePersonaggio: String, utenteId: String): MutableLiveData<List<Int>> {
        val slotTotLiveData = MutableLiveData<List<Int>>()

        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggiRef = db.collection("personaggi")
            .whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggiRef.get().addOnSuccessListener { querySnapshot ->
            val documents = querySnapshot.documents
            if (documents.isNotEmpty()) {
                val document = documents[0]
                // Ottieni l'array di slotTot dal documento corrente
                val slotTot = document.get("slotTot") as? List<Long>
                // Converte gli elementi dell'array in Int e restituisce una lista di Int
                val slotTotInt = slotTot?.map { it.toInt() } ?: emptyList()
                slotTotLiveData.value = slotTotInt
            } else {
                // Nessun documento trovato con i criteri di filtro
                slotTotLiveData.value = emptyList()
            }
        }.addOnFailureListener {
            // Si è verificato un errore durante l'accesso ai dati
            slotTotLiveData.value = emptyList()
        }

        return slotTotLiveData
    }


    fun getSlotUsatiArray(nomePersonaggio: String, utenteId: String): MutableLiveData<List<Int>> {
        val slotUsatiLiveData = MutableLiveData<List<Int>>()

        // Ottieni un'istanza del database di Firestore
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggiRef = db.collection("personaggi")
            .whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggiRef.get().addOnSuccessListener { querySnapshot ->
            val documents = querySnapshot.documents
            if (documents.isNotEmpty()) {
                val document = documents[0]
                // Ottieni l'array di slotUsati dal documento corrente
                val slotUsati = document.get("slotUsati") as? List<Long>
                // Converte gli elementi dell'array in Int e restituisce una lista di Int
                val slotUsatiInt = slotUsati?.map { it.toInt() } ?: emptyList()
                slotUsatiLiveData.value = slotUsatiInt
            } else {
                // Nessun documento trovato con i criteri di filtro
                slotUsatiLiveData.value = emptyList()
            }
        }.addOnFailureListener {
            // Si è verificato un errore durante l'accesso ai dati
            slotUsatiLiveData.value = emptyList()
        }

        return slotUsatiLiveData
    }


    fun updateSlotTotUsati(context: Context, nomePersonaggio: String, utenteId: String, livello: Int, newSlotTot: Int, newSlotUsati: Int) {
        val db = FirebaseFirestore.getInstance()

        // Ottieni una referenza alla collezione "personaggi" e applica i criteri di filtro
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("utenteId", utenteId)

        // Esegui la query per ottenere i documenti dei personaggi corrispondenti ai criteri di filtro
        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                val slotTotArray = document.get("slotTot") as? ArrayList<Long>
                val slotUsatiArray = document.get("slotUsati") as? ArrayList<Long>

                slotTotArray?.let {
                    if (livello >= 1 && livello <= slotTotArray.size) {
                        val slotTot = newSlotTot.coerceAtLeast(0)
                        it[livello - 1] = slotTot.toLong()
                    }
                }

                slotUsatiArray?.let {
                    if (livello >= 1 && livello <= slotUsatiArray.size) {
                        val slotTot = newSlotTot.coerceAtLeast(0)
                        val slotUsati = newSlotUsati.coerceIn(0, slotTot)
                        it[livello - 1] = slotUsati.toLong()
                    }
                }

                // Aggiorna i valori degli array "slotTot" e "slotUsati" nel documento corrente
                document.reference.update("slotTot", slotTotArray)
                document.reference.update("slotUsati", slotUsatiArray)
                    .addOnSuccessListener {
                        // Aggiornamento riuscito
                        Toast.makeText(context, "Aggiornamento riuscito!", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener {
                        // Errore durante l'aggiornamento
                        Toast.makeText(context, "Non fare il furbo, o il Master avrà il diritto di mangiarsi i tuoi dadi!", Toast.LENGTH_SHORT).show()
                    }
            }
        }
    }




    companion object {
        const val TAG = "com.progetto_dd.view.characters.HomeCharacterFragment"
    }
}
