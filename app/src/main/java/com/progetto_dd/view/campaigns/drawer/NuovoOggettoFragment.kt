package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.progetto_dd.R
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class NuovoOggettoFragment : Fragment() {

    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_nuovo_oggetto, container, false)

        spinner = view.findViewById(R.id.spinnerGiocatore)
        val btnAggiungi: Button = view.findViewById(R.id.btnAggiungiOggetto)

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
                spinner.adapter = adapter
            }
        }

        btnAggiungi.setOnClickListener {
            val personaggioSelezionato = spinner.selectedItem as? String
            val nomeOggetto = view.findViewById<TextInputEditText>(R.id.nome_oggetto).text.toString()

            if (personaggioSelezionato != null && nomeOggetto.isNotEmpty()) {
                val alertDialogBuilder = AlertDialog.Builder(requireContext())
                alertDialogBuilder.setTitle("Conferma aggiunta")
                alertDialogBuilder.setMessage("Vuoi confermare l'aggiunta dell'oggetto?")
                alertDialogBuilder.setPositiveButton("Conferma") { dialog, _ ->
                    if (campagnaNome != null) {
                        viewModelPers.aggiungiEquipaggiamento(personaggioSelezionato, campagnaNome, nomeOggetto)
                    }
                    dialog.dismiss()
                    findNavController().navigate(R.id.action_nuovoOggettoFragment_to_visualizzaCampagnaFragment)
                }
                alertDialogBuilder.setNegativeButton("Annulla") { dialog, _ ->
                    dialog.dismiss()
                }

                val alertDialog = alertDialogBuilder.create()
                alertDialog.show()
            }
        }


        return view
    }

}