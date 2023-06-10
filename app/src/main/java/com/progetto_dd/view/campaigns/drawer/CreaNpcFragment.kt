package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.progetto_dd.R

class CreaNpcFragment : Fragment() {

    private lateinit var nomeNpcEditText: TextInputEditText
    private lateinit var descrizioneNpcEditText: TextInputEditText
    private lateinit var spinnerLegame: Spinner
    private lateinit var aggiungiNpcButton: Button

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crea_npc, container, false)

        // Inizializzazione delle view
        nomeNpcEditText = view.findViewById(R.id.nome_npc)
        descrizioneNpcEditText = view.findViewById(R.id.descrizione_npc)
        spinnerLegame = view.findViewById(R.id.spinnerLegame)
        aggiungiNpcButton = view.findViewById(R.id.aggiungi_npc)

        // Recupera il nome della campagna e l'ID del master dalla Activity chiamante
        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        // Definizione del comportamento del pulsante "Aggiungi NPC"
        aggiungiNpcButton.setOnClickListener {
            val nomeNpc = nomeNpcEditText.text.toString().trim()
            val descrizioneNpc = descrizioneNpcEditText.text.toString().trim()
            val legameNpc = spinnerLegame.selectedItem.toString()

            if (nomeNpc.isEmpty() || descrizioneNpc.isEmpty()) {
                // Verifica se il nome e la descrizione dell'NPC sono vuoti
                Toast.makeText(requireContext(), "Inserisci il nome e la descrizione dell'NPC", Toast.LENGTH_SHORT).show()
            } else {
                val npcQuery = firestore.collection("npc")
                    .whereEqualTo("nome", nomeNpc)
                    .whereEqualTo("campagna", campagnaNome)

                npcQuery.get()
                    .addOnSuccessListener { querySnapshot ->
                        if (querySnapshot.isEmpty) {
                            // Non esiste un NPC con lo stesso nome nella stessa campagna, procedi con l'aggiunta
                            val npc = hashMapOf(
                                "nome" to nomeNpc,
                                "descrizione" to descrizioneNpc,
                                "legame" to legameNpc,
                                "campagna" to campagnaNome,
                                "master" to masterId
                            )

                            firestore.collection("npc")
                                .add(npc)
                                .addOnSuccessListener {
                                    // Aggiunta dell'NPC al database avvenuta con successo, naviga alla visualizzazione della campagna
                                    findNavController().navigate(R.id.action_creaNpcFragment_to_visualizzaCampagnaFragment)
                                }
                        } else {
                            // Esiste già un NPC con lo stesso nome nella stessa campagna, mostra un messaggio di errore
                            Toast.makeText(requireContext(), "Esiste già un NPC con lo stesso nome nella campagna", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .addOnFailureListener { exception ->
                        // Gestisci eventuali errori nella query
                        Toast.makeText(requireContext(), "Errore durante il controllo dell'NPC", Toast.LENGTH_SHORT).show()
                        Log.e("CreaNpcFragment", "Errore nella query NPC: $exception")
                    }
            }
        }

        return view
    }
}
