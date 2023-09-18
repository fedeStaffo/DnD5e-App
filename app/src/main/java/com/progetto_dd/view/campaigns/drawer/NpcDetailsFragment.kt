package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.progetto_dd.R
import android.content.Intent
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.databinding.FragmentNpcDetailsBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.npc.NpcViewModel
import com.progetto_dd.view.campaigns.CampaignsActivity

class NpcDetailsFragment : Fragment(R.layout.fragment_npc_details) {

    private lateinit var binding: FragmentNpcDetailsBinding
    private lateinit var viewModelCampagna: CampagnaViewModel
    private lateinit var npcViewModel: NpcViewModel
    private var isEditingLegame = false
    private var isEditingDescrizione = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNpcDetailsBinding.bind(view)

        // Inizializza il ViewModel
        npcViewModel = ViewModelProvider(this).get(NpcViewModel::class.java)

        // Recupera i dati passati dagli argomenti del fragment
        val npcNome = arguments?.getString("nome_npc")
        val npcDescrizione = arguments?.getString("descrizione_npc")
        val npcLegame = arguments?.getString("legame_npc")
        val npcMaster = arguments?.getString("master_id")
        val campagna = arguments?.getString("campagna")

        binding.Nome.text = npcNome
        binding.Legame.text = npcLegame
        binding.Descrizione.text = npcDescrizione

        // Inizializza il CampagnaViewModel
        viewModelCampagna = ViewModelProvider(requireActivity()).get(CampagnaViewModel::class.java)

        // Prende l'id del master
        val masterId = arguments?.getString("master_id")

        val isMaster = masterId?.let { viewModelCampagna.isCurrentPlayerMaster(it) }

        if (isMaster == false) {
            binding.eliminaNpc.isVisible = false
            binding.modificaLegameButton.isVisible = false
            binding.modificaDescrizioneButton.isVisible = false
        } else {
            // Abilita la modifica del legame
            binding.modificaLegameButton.setOnClickListener {
                isEditingLegame = !isEditingLegame
                updateUI()
            }

            // Abilita la modifica della descrizione
            binding.modificaDescrizioneButton.setOnClickListener {
                isEditingDescrizione = !isEditingDescrizione
                updateUI()
            }

            // Salva le modifiche del legame
            binding.salvaLegameButton.setOnClickListener {
                val newLegame = binding.spinnerLegame.selectedItem.toString()
                if (npcNome != null && npcMaster != null && campagna != null) {
                    npcViewModel.modificaLegameNpc(npcNome, npcMaster, campagna, newLegame)
                    isEditingLegame = false
                    updateUI()
                    showSuccessDialog("Legame modificato con successo!")
                }
            }

            // Salva le modifiche della descrizione
            binding.salvaDescrizioneButton.setOnClickListener {
                val newDescrizione = binding.modificaDescrizioneEdittext.text.toString()
                if (npcNome != null && npcMaster != null && campagna != null) {
                    npcViewModel.modificaDescrizioneNpc(npcNome, npcMaster, campagna, newDescrizione)
                    isEditingDescrizione = false
                    updateUI()
                    showSuccessDialog("Descrizione modificata con successo!")
                }
            }
        }

        binding.eliminaNpc.setOnClickListener {
            if (npcNome != null && npcMaster != null && campagna != null) {
                showConfirmationDialog(npcNome, npcMaster, campagna)
            }
        }
    }

    // Dialog che appare se si vuole eliminare un npc
    private fun showConfirmationDialog(npcNome: String, npcMaster: String, campagna: String) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
            .setTitle("Conferma Eliminazione")
            .setMessage("Sei sicuro di voler eliminare questo NPC?")
            .setPositiveButton("Conferma") { _, _ ->
                // Chiamata alla funzione eliminaNpc nel ViewModel
                npcViewModel.eliminaNpc(npcNome, npcMaster, campagna)
                findNavController().navigate(R.id.action_npcDetailsFragment_to_visualizzaNpcFragment)
                showSuccessDialog("NPC eliminato con successo!")
            }
            .setNegativeButton("Annulla", null)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    // Dialog che mostra un messaggio di successo
    private fun showSuccessDialog(message: String) {
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
            .setTitle("Operazione Completata")
            .setMessage(message)
            .setPositiveButton("OK", null)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun updateUI() {
        binding.Legame.visibility = if (isEditingLegame) View.GONE else View.VISIBLE
        binding.spinnerLegame.visibility = if (isEditingLegame) View.VISIBLE else View.GONE
        binding.modificaLegameButton.text = if (isEditingLegame) "Annulla Modifica" else "Modifica Legame"

        binding.Descrizione.visibility = if (isEditingDescrizione) View.GONE else View.VISIBLE
        binding.modificaDescrizioneEdittext.visibility = if (isEditingDescrizione) View.VISIBLE else View.GONE
        binding.modificaDescrizioneButton.text = if (isEditingDescrizione) "Annulla Modifica" else "Modifica Descrizione"

        binding.salvaLegameButton.visibility = if (isEditingLegame) View.VISIBLE else View.GONE
        binding.salvaDescrizioneButton.visibility = if (isEditingDescrizione) View.VISIBLE else View.GONE
    }
}
