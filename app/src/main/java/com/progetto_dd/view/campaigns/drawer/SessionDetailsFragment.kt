package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentSessionDetailsBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.sessione.SessioneViewModel

class SessionDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSessionDetailsBinding
    private lateinit var sessioneViewModel: SessioneViewModel
    private lateinit var viewModelCampagna: CampagnaViewModel
    private var isMaster: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSessionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessioneViewModel = ViewModelProvider(requireActivity()).get(SessioneViewModel::class.java)

        // Ottieni i dati dalla sessione
        val sessioneNumero = arguments?.getString("numero_sessione")
        val sessioneGiorno = arguments?.getString("giorno_sessione")
        val sessioneDescrizione = arguments?.getString("descrizione_sessione")
        val master = arguments?.getString("master_id")
        val campagna = arguments?.getString("campagna")

        // Inizializza i campi del layout con i dati della sessione
        binding.Numero.text = sessioneNumero
        binding.Giorno.text = sessioneGiorno
        binding.Descrizione.text = sessioneDescrizione

        // Inizializza il CampagnaViewModel
        viewModelCampagna = ViewModelProvider(requireActivity()).get(CampagnaViewModel::class.java)

        // Ottieni l'ID del master
        val masterId = arguments?.getString("master_id")

        // Verifica se l'utente corrente è il master
        isMaster = masterId?.let { viewModelCampagna.isCurrentPlayerMaster(it) } ?: false

        // Nasconde il pulsante di eliminazione se l'utente non è il master
        if (!isMaster) {
            binding.eliminaSessione.isVisible = false
            setupEditMode(false)
        } else {
            // Mostra i pulsanti di modifica solo se l'utente è il master
            binding.modificaGiornoButton.setOnClickListener {
                setupEditMode(true)
            }

            binding.salvaGiornoButton.setOnClickListener {
                val nuovoGiorno = binding.modificaGiornoEdittext.text.toString()
                if (campagna != null && master != null && sessioneNumero != null && nuovoGiorno.isNotBlank()) {
                    // Chiama la funzione per modificare il giorno della sessione
                    sessioneViewModel.modificaGiornoSessione(campagna, master, sessioneNumero, nuovoGiorno)
                    showSuccessMessage("Giorno modificato con successo")
                    setupEditMode(false)
                }
            }

            binding.modificaDescrizioneButton.setOnClickListener {
                setupEditMode(true)
            }

            binding.salvaDescrizioneButton.setOnClickListener {
                val nuovaDescrizione = binding.modificaDescrizioneEdittext.text.toString()
                if (campagna != null && master != null && sessioneNumero != null && nuovaDescrizione.isNotBlank()) {
                    // Chiama la funzione per modificare la descrizione della sessione
                    sessioneViewModel.modificaDescrizioneSessione(campagna, master, sessioneNumero, nuovaDescrizione)
                    showSuccessMessage("Descrizione modificata con successo")
                    setupEditMode(false)
                }
            }
        }

        // Gestisce il click sul pulsante di eliminazione
        binding.eliminaSessione.setOnClickListener {
            showDeleteConfirmationDialog(campagna, master, sessioneNumero)
        }
    }

    // Mostra una finestra di dialogo di conferma per l'eliminazione della sessione
    private fun showDeleteConfirmationDialog(campagna: String?, master: String?, sessioneNumero: String?) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Elimina sessione")
        builder.setMessage("Sei sicuro di voler eliminare questa sessione?")
        builder.setPositiveButton("Elimina") { _, _ ->
            if (campagna != null && master != null && sessioneNumero != null) {
                // Chiama la funzione per eliminare la sessione
                sessioneViewModel.eliminaSessione(campagna, master, sessioneNumero)
                showSuccessMessage("Sessione eliminata con successo")
                findNavController().navigate(R.id.action_sessionDetailsFragment_to_visualizzasessioniFragment)
            }
        }
        builder.setNegativeButton("Annulla", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    // Abilita o disabilita la modalità di modifica
    private fun setupEditMode(isEditMode: Boolean) {
        if (isEditMode) {
            binding.modificaGiornoButton.visibility = View.GONE
            binding.modificaDescrizioneButton.visibility = View.GONE
            binding.salvaGiornoButton.visibility = View.VISIBLE
            binding.salvaDescrizioneButton.visibility = View.VISIBLE
            binding.modificaGiornoEdittext.visibility = View.VISIBLE
            binding.modificaDescrizioneEdittext.visibility = View.VISIBLE
            binding.modificaGiornoEdittext.setText(binding.Giorno.text)
            binding.modificaDescrizioneEdittext.setText(binding.Descrizione.text)
        } else {
            binding.modificaGiornoButton.visibility = if (isMaster) View.VISIBLE else View.GONE
            binding.modificaDescrizioneButton.visibility = if (isMaster) View.VISIBLE else View.GONE
            binding.salvaGiornoButton.visibility = View.GONE
            binding.salvaDescrizioneButton.visibility = View.GONE
            binding.modificaGiornoEdittext.visibility = View.GONE
            binding.modificaDescrizioneEdittext.visibility = View.GONE
        }
    }

    // Mostra un messaggio di successo utilizzando Toast
    private fun showSuccessMessage(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}
