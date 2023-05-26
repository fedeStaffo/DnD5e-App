package com.progetto_dd.view.campaigns.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.ActivityVisualizzaNpcBinding
import com.progetto_dd.memory.npc.NpcViewModel
import com.progetto_dd.view.campaigns.CampaignsActivity

class VisualizzaNpcActivity : AppCompatActivity() {

    private lateinit var binding : ActivityVisualizzaNpcBinding

    // Aggiungi una proprietà per il tuo ViewModel
    private lateinit var npcViewModel: NpcViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisualizzaNpcBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inizializza il ViewModel
        npcViewModel = ViewModelProvider(this).get(NpcViewModel::class.java)

        // Recupera i dati passati dall'adapter
        val npcNome = this.intent.getStringExtra("nome_npc")
        val npcDescrizione = this.intent.getStringExtra("descrizione_npc")
        val npcLegame = this.intent.getStringExtra("legame_npc")
        val npcMaster = this.intent.getStringExtra("master_id")
        val campagna = this.intent.getStringExtra("campagna")

        binding.Nome.text = npcNome
        binding.Legame.text = npcLegame
        binding.Descrizione.text = npcDescrizione

        binding.eliminaNpc.setOnClickListener {
            if (npcNome != null && npcMaster != null && campagna != null) {
                showConfirmationDialog(npcNome, npcMaster, campagna)
            }
        }
    }

    // Dialog che appare se si vuole eliminare un npc
    private fun showConfirmationDialog(npcNome: String, npcMaster: String, campagna: String) {
        val alertDialogBuilder = AlertDialog.Builder(this)
            .setTitle("Conferma Eliminazione")
            .setMessage("Sei sicuro di voler eliminare questo NPC?")
            .setPositiveButton("Conferma") { _, _ ->
                // Chiamata alla funzione eliminaNpc nel ViewModel
                npcViewModel.eliminaNpc(npcNome, npcMaster, campagna)
                val intent = Intent(this, CampaignsActivity::class.java)
                startActivity(intent)
            }
            .setNegativeButton("Annulla", null)

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}
