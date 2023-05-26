package com.progetto_dd.view.campaigns.drawer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import com.progetto_dd.R
import java.text.SimpleDateFormat
import java.util.*

class CreaSessioniFragment : Fragment() {

    private lateinit var numeroSessioneEditText: TextInputEditText
    private lateinit var giornoSessioneEditText: TextInputEditText
    private lateinit var descrizioneSessioneEditText: TextInputEditText
    private lateinit var aggiungiSessioneButton: Button

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crea_sessioni, container, false)

        numeroSessioneEditText = view.findViewById(R.id.numero_sessione)
        giornoSessioneEditText = view.findViewById(R.id.giorno_sessione)
        descrizioneSessioneEditText = view.findViewById(R.id.descrizione_sessione)
        aggiungiSessioneButton = view.findViewById(R.id.aggiungi_sessione)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        aggiungiSessioneButton.setOnClickListener {
            val numeroSessione = numeroSessioneEditText.text.toString().trim()
            val giornoSessione = giornoSessioneEditText.text.toString().trim()
            val descrizioneSessione = descrizioneSessioneEditText.text.toString().trim()

            if (numeroSessione.isEmpty() || giornoSessione.isEmpty() || descrizioneSessione.isEmpty()) {
                Toast.makeText(
                    requireContext(),
                    "Inserisci il numero, il giorno e la descrizione della Sessione",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Controlla se esiste già una sessione con lo stesso numero nella stessa campagna
                val sessioniCollection = firestore.collection("sessioni")
                sessioniCollection
                    .whereEqualTo("campagna", campagnaNome)
                    .whereEqualTo("numero", numeroSessione)
                    .get()
                    .addOnSuccessListener { querySnapshot ->
                        if (querySnapshot.isEmpty) {
                            // Non esiste una sessione con lo stesso numero nella stessa campagna, procedi con l'aggiunta
                            val sessione = hashMapOf(
                                "numero" to numeroSessione,
                                "giorno" to giornoSessione,
                                "descrizione" to descrizioneSessione,
                                "campagna" to campagnaNome,
                                "master" to masterId
                            )

                            firestore.collection("sessioni")
                                .add(sessione)
                                .addOnSuccessListener {
                                    findNavController().navigate(R.id.action_creaSessioniFragment_to_visualizzaCampagnaFragment)
                                }
                        } else {
                            // Esiste già una sessione con lo stesso numero nella stessa campagna, mostra un Toast di avviso
                            Toast.makeText(
                                requireContext(),
                                "Esiste già una sessione con lo stesso numero nella stessa campagna",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            }
        }


        return view
    }
}