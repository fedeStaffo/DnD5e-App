package com.progetto_dd.memory.campagna

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.view.campaigns.drawer.MainDrawerCampagnaActivity

class CampagnaAdapter(private val campagne: List<Campagna>):
    RecyclerView.Adapter<CampagnaAdapter.CampagnaViewHolder>() {

    // Crea una nuova istanza di CampagnaViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampagnaAdapter.CampagnaViewHolder {
        // Infla il layout per l'elemento della lista
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_campagna, parent, false)
        // Restituisce la nuova istanza di CampagnaViewHolder
        return CampagnaViewHolder(view)
    }

    // Associa i dati di una campagna alla relativa view
    override fun onBindViewHolder(holder: CampagnaAdapter.CampagnaViewHolder, position: Int) {
        // Ottiene la campagna alla posizione specificata
        val campagna = campagne[position]
        // Chiama il metodo bind di CampagnaViewHolder per associare i dati alla view
        holder.bind(campagna)
    }

    // Restituisce il numero di elementi nella lista
    override fun getItemCount(): Int {
        return campagne.size
    }

    // Classe che contiene la view per ogni elemento della lista
    inner class CampagnaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Inizializza le view
        private val nameTextView: TextView = itemView.findViewById(R.id.nomeCampagna)
        private val masterTextView: TextView = itemView.findViewById(R.id.nomeMaster)

        // Associa i dati della campagna alle view
        fun bind(campagna: Campagna) {
            // Imposta il nome del campagna
            nameTextView.text = campagna.nome
            // Imposta la razza del campagna
            masterTextView.text = campagna.masterNome

            // Imposta il listener del clic sulla card della campagna
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, MainDrawerCampagnaActivity::class.java)
                // Passa il nome della campagna e l'id del master alla nuova activity
                intent.putExtra("campagna_nome", campagna.nome)
                intent.putExtra("master_id", campagna.masterId)
                intent.putExtra("master_nome", campagna.masterNome)
                itemView.context.startActivity(intent)
            }
        }
    }
}