package com.progetto_dd.memory.npc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R

class NpcAdapter(private val npc: List<Npc>) :
    RecyclerView.Adapter<NpcAdapter.NpcViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NpcViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_npc, parent, false
        )
        return NpcViewHolder(view)
    }

    override fun onBindViewHolder(holder: NpcViewHolder, position: Int) {
        val npc_singolo = npc[position]
        holder.bind(npc_singolo)
    }

    // Restituisce il numero di elementi nella lista
    override fun getItemCount(): Int {
        return npc.size
    }

    // Classe che contiene la view per ogni elemento della lista
    inner class NpcViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Inizializza le view
        private val nameTextView: TextView = itemView.findViewById(R.id.lista_npcNome)
        private val boundTextView: TextView = itemView.findViewById(R.id.lista_npcLegame)

        // Associa i dati del personaggio alle view
        // Associa i dati del personaggio alle view
        fun bind(npc: Npc) {
            // Imposta il nome dell'npc
            nameTextView.text = npc.nome
            // Imposta il legame dell'npc
            boundTextView.text = npc.legame

            // Aggiungi il ClickListener alla card
            itemView.setOnClickListener {
                val args = Bundle().apply {
                    putString("nome_npc", npc.nome)
                    putString("descrizione_npc", npc.descrizione)
                    putString("legame_npc", npc.legame)
                    putString("master_id", npc.master)
                    putString("campagna", npc.campagna)
                }

                val navController = itemView.findNavController()
                navController.navigate(R.id.action_visualizzaNpcFragment_to_npcDetailsFragment, args)
            }


        }

    }

}