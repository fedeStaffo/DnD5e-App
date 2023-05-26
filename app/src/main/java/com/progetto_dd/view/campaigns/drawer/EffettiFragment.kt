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

    private lateinit var spinnerGiocatori: Spinner
    private lateinit var spinnerEffetti: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_effetti, container, false)

        spinnerGiocatori = view.findViewById(R.id.spinnerGiocatori)
        spinnerEffetti = view.findViewById(R.id.spinnerEffetti)
        val btnAggiungi: Button = view.findViewById(R.id.buttonAggiungiEffetto)

        // Inizializza i ViewModel
        val viewModelCamp = ViewModelProvider(this).get(CampagnaViewModel::class.java)
        val viewModelPers = ViewModelProvider(this).get(PersonaggioViewModel::class.java)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")

        // Ottieni la lista di personaggi associati alla campagna
        if (campagnaNome != null) {
            viewModelCamp.getPersonaggiByCampagna(campagnaNome).observe(viewLifecycleOwner) { personaggi ->
                val nomiPersonaggi = personaggi.map { it.nome }
                val adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    nomiPersonaggi
                )
                spinnerGiocatori.adapter = adapter
            }
        }

        btnAggiungi.setOnClickListener {
            val personaggioSelezionato = spinnerGiocatori.selectedItem as? String
            val stato = spinnerEffetti.selectedItem as? String

            if (personaggioSelezionato != null && stato != null) {
                val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
                if (campagnaNome != null) {
                    val confermaDialog = AlertDialog.Builder(requireContext())
                        .setTitle("Conferma aggiunta")
                        .setMessage("Sei sicuro di voler aggiungere l'effetto al personaggio?")
                        .setPositiveButton("Aggiungi") { dialog, _ ->
                            viewModelPers.updatePersonaggioStato(personaggioSelezionato, campagnaNome, stato)
                            dialog.dismiss()
                            findNavController().navigate(R.id.action_effettiFragment_to_visualizzaCampagnaFragment)
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