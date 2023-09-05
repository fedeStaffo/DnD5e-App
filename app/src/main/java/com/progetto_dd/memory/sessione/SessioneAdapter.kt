package com.progetto_dd.memory.sessione

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R

class SessioneAdapter(private val sessione: List<Sessione>) :
    RecyclerView.Adapter<SessioneAdapter.SessioneViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessioneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_sessione, parent, false
        )
        return SessioneViewHolder(view)
    }

    // Associa i dati di un sessione alla relativa view
    override fun onBindViewHolder(holder: SessioneViewHolder, position: Int) {
        // Ottiene la sessione alla posizione specificata
        val sessioneSingolo = sessione[position]
        // Chiama il metodo bind di SessioneViewHolder per associare i dati alla view
        holder.bind(sessioneSingolo)
    }

    // Restituisce il numero di elementi nella lista
    override fun getItemCount(): Int {
        return sessione.size
    }

    // Classe che contiene la view per ogni elemento della lista
    inner class SessioneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Inizializza le view
        private val numeroTextView: TextView = itemView.findViewById(R.id.sessione_numero)
        private val giornoTextView: TextView = itemView.findViewById(R.id.sessione_giorno)


        // Associa i dati della sessione alle view
        fun bind(sessione: Sessione) {
            // Imposta il numero della sessione
            numeroTextView.text = sessione.numero.toString()
            // Imposta il giorno della sessione
            giornoTextView.text = sessione.giorno

            // Aggiungi il ClickListener alla card
            itemView.setOnClickListener {
                val args = Bundle().apply {
                    putString("numero_sessione", sessione.numero.toString())
                    putString("giorno_sessione", sessione.giorno)
                    putString("descrizione_sessione", sessione.descrizione)
                    putString("master_id", sessione.master)
                    putString("campagna", sessione.campagna)
                }

                val navController = itemView.findNavController()
                navController.navigate(R.id.action_visualizzasessioniFragment_to_sessionDetailsFragment, args)
            }
        }
    }

    // Aggiungi questo metodo per ordinare le sessioni in base al numero
    fun sortSessionsByNumber() {
        sessione.sortedBy { it.numero }
        notifyDataSetChanged()
    }
}