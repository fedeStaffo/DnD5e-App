package com.progetto_dd.memory.sessione

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.view.campaigns.drawer.VisualizzaSessioneActivity

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

                val intent = Intent(itemView.context, VisualizzaSessioneActivity::class.java)

                intent.putExtra("numero_sessione", sessione.numero.toString())
                intent.putExtra("giorno_sessione", sessione.giorno)
                intent.putExtra("descrizione_sessione", sessione.descrizione)
                intent.putExtra("master_id", sessione.master)
                intent.putExtra("campagna", sessione.campagna)
                itemView.context.startActivity(intent)
            }
        }
    }
}