package com.progetto_dd.view.characters

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.progetto_dd.R
import com.progetto_dd.memory.personaggio.Personaggio
import com.progetto_dd.memory.personaggio.PersonaggioAdapter

class HomeCharacterFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView // RecyclerView in cui mostrare i personaggi
    private lateinit var adapter: PersonaggioAdapter // Adapter per visualizzare i personaggi nella RecyclerView
    private lateinit var layoutManager: LinearLayoutManager // LayoutManager per la RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla il layout del fragment
        val view = inflater.inflate(R.layout.fragment_home_character, container, false)

        // Ottiene la RecyclerView dal layout
        recyclerView = view.findViewById(R.id.reyclerViewPers)

        // Crea un LinearLayoutManager per la RecyclerView
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Legge i personaggi dell'utente corrente da Firestore
        val currentUser = FirebaseAuth.getInstance().currentUser
        val personaggiRef = FirebaseFirestore.getInstance().collection("personaggi")
            .whereEqualTo("utenteId", currentUser?.uid)

        // Aggiunge un listener per gli snapshot del Firestore
        personaggiRef.addSnapshotListener { snapshot, e ->
            if (e != null) {
                // Se si verifica un errore, lo stampa nel log e ritorna
                Log.w(TAG, "Listen failed.", e)
                return@addSnapshotListener
            }

            if (snapshot != null) {
                // Se lo snapshot non è nullo, crea una lista di personaggi a partire dallo snapshot
                val personaggi = snapshot.toObjects(Personaggio::class.java)
                // Crea un adapter per la RecyclerView a partire dalla lista di personaggi
                adapter = PersonaggioAdapter(personaggi)
                // Imposta l'adapter alla RecyclerView
                recyclerView.adapter = adapter
            } else {
                // Se lo snapshot è nullo, lo stampa nel log
                Log.d(TAG, "Current data: null")
            }
        }

        return view
    }

    companion object {
        private const val TAG = "com.progetto_dd.view.characters.HomeCharacterFragment"
    }
}
