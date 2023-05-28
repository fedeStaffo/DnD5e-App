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
        val db = FirebaseFirestore.getInstance()
        val personaggiRef = db.collection("personaggi")

        val equipaggiamentoList = _equipaggiamento.value?.toMutableList() ?: mutableListOf()
        equipaggiamentoList.add(nuovoOggetto)

        val personaggioQuery = personaggiRef
            .whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("campagna", nomeCampagna)

        personaggioQuery.get().addOnSuccessListener { querySnapshot ->
            if (!querySnapshot.isEmpty) {
                val documentSnapshot = querySnapshot.documents[0]
                val personaggioId = documentSnapshot.id

                val updateData = hashMapOf<String, Any>(
                    "equipaggiamento" to equipaggiamentoList
                )

                personaggiRef.document(personaggioId)
                    .update(updateData)

            }
        }
    }

    fun updatePersonaggioStato(nomePersonaggio: String, nomeCampagna: String, nuovoStato: String) {

        val db = FirebaseFirestore.getInstance()
        val personaggiRef = db.collection("personaggi")

        val query = personaggiRef.whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("campagna", nomeCampagna)

        query.get().addOnSuccessListener { documents ->
            for (document in documents) {
                // Modifica il campo "stato" del personaggio
                document.reference.update("stato", nuovoStato)
            }
        }
    }

    fun deletePersonaggio(nome: String, razza: String, classe: String, utenteId: String, campagna: String): LiveData<Boolean> {
        val deletionLiveData = MutableLiveData<Boolean>()

        if (campagna != "") {
            deletionLiveData.value = false
            return deletionLiveData
        }

        val query = personaggiRef
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)
            .whereEqualTo("campagna", campagna)

        query.get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot.documents) {
                    personaggiRef.document(document.id).delete()
                        .addOnSuccessListener {
                            deletionLiveData.value = true
                        }
                        .addOnFailureListener { exception ->
                            deletionLiveData.value = false
                        }
                }
            }
            .addOnFailureListener { exception ->
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
        nuovoValore: Number) {
        val db = FirebaseFirestore.getInstance()
        val personaggiRef = db.collection("personaggi")

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

                val document = querySnapshot.documents.first()
                val documentId = document.id

                // Aggiorna il campo con il nuovo valore
                val updateData = mapOf(nomeCampo to nuovoValore)

                personaggiRef.document(documentId)
                    .update(updateData)
            }
    }

    fun updateCampoString(nome: String, razza: String, classe: String, utenteId: String, campo: String, nuovoValore: String) {
        val db = FirebaseFirestore.getInstance()
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                document.reference.update(campo, nuovoValore)
            }
        }
    }

    fun addEquipaggiamentoToPersonaggio(nome: String, razza: String, classe: String, utenteId: String, nuovoOggetto: String) {
        val db = FirebaseFirestore.getInstance()
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                val equipaggiamento = document.get("equipaggiamento") as? ArrayList<String>
                equipaggiamento?.add(nuovoOggetto)
                document.reference.update("equipaggiamento", equipaggiamento)
            }
        }
    }

    fun removeEquipaggiamentoFromPersonaggio(nome: String, razza: String, classe: String, utenteId: String, oggettoDaRimuovere: String): LiveData<Boolean> {
        val removeResult = MutableLiveData<Boolean>()

        val db = FirebaseFirestore.getInstance()
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                val equipaggiamento = document.get("equipaggiamento") as? ArrayList<String>
                equipaggiamento?.remove(oggettoDaRimuovere)
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

        return removeResult
    }

    fun addIncantesimoToPersonaggio(nome: String, razza: String, classe: String, utenteId: String, nuovaMagia: String) {
        val db = FirebaseFirestore.getInstance()
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                val magie = document.get("magie") as? ArrayList<String>
                magie?.add(nuovaMagia)
                document.reference.update("magie", magie)
            }
        }
    }

    fun removeIncantesimoFromPersonaggio(nome: String, razza: String, classe: String, utenteId: String, magiaDaRimuovere: String): LiveData<Boolean> {
        val removeResult = MutableLiveData<Boolean>()

        val db = FirebaseFirestore.getInstance()
        val personaggioRef = db.collection("personaggi")
            .whereEqualTo("nome", nome)
            .whereEqualTo("razza", razza)
            .whereEqualTo("classe", classe)
            .whereEqualTo("utenteId", utenteId)

        personaggioRef.get().addOnSuccessListener { querySnapshot ->
            for (document in querySnapshot) {
                val magie = document.get("magie") as? ArrayList<String>
                magie?.remove(magiaDaRimuovere)
                document.reference.update("magie", magie)
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

        return removeResult
    }

    fun getMagieFromFirestore(nomePersonaggio: String, utenteId: String): LiveData<List<String>> {
        val mutableLiveData = MutableLiveData<List<String>>()

        val collection = FirebaseFirestore.getInstance().collection("personaggi")
        val query = collection.whereEqualTo("nome", nomePersonaggio)
            .whereEqualTo("utenteId", utenteId)

        query.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val result = mutableListOf<String>()
                for (document in task.result) {
                    val magie = document["magie"] as? List<String>
                    if (magie != null) {
                        result.addAll(magie)
                    }
                }
                mutableLiveData.value = result
            }
        }

        return mutableLiveData
    }


    companion object {
        const val TAG = "com.progetto_dd.view.characters.HomeCharacterFragment"
    }
}
