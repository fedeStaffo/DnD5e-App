package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class EffettiFragment : Fragment() {

    private lateinit var spinnerGiocatori: Spinner // Spinner per i giocatori
    private lateinit var spinnerEffetti: Spinner // Spinner per gli effetti

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_effetti, container, false)

        spinnerGiocatori = view.findViewById(R.id.spinnerGiocatori) // Inizializza il riferimento al spinner dei giocatori
        spinnerEffetti = view.findViewById(R.id.spinnerEffetti) // Inizializza il riferimento al spinner degli effetti
        val btnAggiungi: Button = view.findViewById(R.id.buttonAggiungiEffetto) // Bottone "Aggiungi effetto"

        // Inizializza i ViewModel
        val viewModelCamp = ViewModelProvider(this).get(CampagnaViewModel::class.java)
        val viewModelPers = ViewModelProvider(this).get(PersonaggioViewModel::class.java)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome") // Ottiene il nome della campagna dalla activity precedente

        // Ottieni la lista di personaggi associati alla campagna
        if (campagnaNome != null) {
            viewModelCamp.getPersonaggiByCampagna(campagnaNome).observe(viewLifecycleOwner) { personaggi ->
                val nomiPersonaggi = personaggi.map { it.nome } // Ottieni solo i nomi dei personaggi
                val adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    nomiPersonaggi
                )
                spinnerGiocatori.adapter = adapter // Imposta l'adapter per il spinner dei giocatori
            }
        }

        btnAggiungi.setOnClickListener {
            val personaggioSelezionato = spinnerGiocatori.selectedItem as? String // Ottieni il personaggio selezionato dallo spinner dei giocatori
            val stato = spinnerEffetti.selectedItem as? String // Ottieni lo stato selezionato dallo spinner degli effetti

            if (personaggioSelezionato != null && stato != null) {
                if (campagnaNome != null) {
                    val confermaDialog = AlertDialog.Builder(requireContext())
                        .setTitle("Conferma aggiunta")
                        .setMessage("Sei sicuro di voler aggiungere l'effetto al personaggio?")
                        .setPositiveButton("Aggiungi") { dialog, _ ->
                            viewModelPers.updatePersonaggioStato(personaggioSelezionato, campagnaNome, stato) // Aggiorna lo stato del personaggio nel ViewModel
                            dialog.dismiss()
                            findNavController().navigate(R.id.action_effettiFragment_to_visualizzaCampagnaFragment) // Naviga alla schermata di visualizzazione della campagna
                        }
                        .setNegativeButton("Annulla") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()

                    confermaDialog.show()
                }
            }
        }

        return view
    }

}
