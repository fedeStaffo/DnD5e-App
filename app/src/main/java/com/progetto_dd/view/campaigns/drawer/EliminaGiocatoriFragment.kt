package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.progetto_dd.R
import com.progetto_dd.memory.campagna.CampagnaViewModel

class EliminaGiocatoriFragment : Fragment() {
    private lateinit var spinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_elimina_giocatori, container, false)
        spinner = view.findViewById(R.id.spinner)
        val btnAvanti: Button = view.findViewById(R.id.btnAvanti)

        // Inizializza il ViewModel
        val viewModel = ViewModelProvider(this).get(CampagnaViewModel::class.java)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")
        val masterNome = requireActivity().intent.getStringExtra("master_nome")

        // Ottieni la lista di personaggi associati alla campagna
        if (campagnaNome != null) {
            viewModel.getPersonaggiByCampagna(campagnaNome).observe(viewLifecycleOwner) { personaggi ->
                val nomiPersonaggi = personaggi.map { it.nome }
                val adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    nomiPersonaggi
                )
                spinner.adapter = adapter
            }
        }

        btnAvanti.setOnClickListener {
            val personaggioSelezionato = spinner.selectedItem as? String

            // Mostra il dialog di conferma per l'eliminazione
            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Conferma eliminazione")
                .setMessage("Sei sicuro di voler eliminare il giocatore selezionato?")
                .setPositiveButton("Conferma") { dialog, which ->
                    // Esegui l'eliminazione del giocatore selezionato
                    if (personaggioSelezionato != null) {
                        if (campagnaNome != null && masterNome != null && masterId != null) {
                            viewModel.eliminaGiocatoreDaCampagna(personaggioSelezionato, campagnaNome, masterNome, requireContext())
                        }
                    }
                }
                .setNegativeButton("Annulla") { dialog, which ->
                    // Annulla l'eliminazione
                }
                .show()
        }

        return view
    }
}
