package com.progetto_dd.memory.npc

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.view.campaigns.drawer.VisualizzaNpcActivity

class NpcAdapter(private val npc: List<Npc>) :
    RecyclerView.Adapter<NpcAdapter.NpcViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NpcViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_npc, parent, false
        )
        return NpcViewHolder(view)
    }

    // Associa i dati di un personaggio alla relativa view
    override fun onBindViewHolder(holder: NpcViewHolder, position: Int) {
        // Ottiene il personaggio alla posizione specificata
        val npc_singolo = npc[position]
        // Chiama il metodo bind di PersonaggioViewHolder per associare i dati alla view
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

                val intent = Intent(itemView.context, VisualizzaNpcActivity::class.java)

                intent.putExtra("nome_npc", npc.nome)
                intent.putExtra("descrizione_npc", npc.descrizione)
                intent.putExtra("legame_npc", npc.legame)
                intent.putExtra("master_id", npc.master)
                intent.putExtra("campagna", npc.campagna)
                itemView.context.startActivity(intent)

            }

        }

    }

}