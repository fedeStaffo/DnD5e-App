package com.progetto_dd.memory.personaggio.incantesimo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.view.characters.visualizza.ListaMagieFragment
import com.progetto_dd.view.characters.visualizza.MagieFragment

class IncantesimoAdapter(var magie: List<Incantesimo>, private val currentFragment: Fragment) :
    RecyclerView.Adapter<IncantesimoAdapter.IncantesimoViewHolder>() {

    // Crea una nuova istanza di IncantesimoViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncantesimoViewHolder {
        // Infla il layout dell'elemento della lista
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_incantesimo, parent, false)
        return IncantesimoViewHolder(view)
    }

    // Associa i dati di un incantesimo alla vista dell'elemento della lista
    override fun onBindViewHolder(holder: IncantesimoViewHolder, position: Int) {
        // Verifica se la posizione è all'interno dei limiti dell'elenco di incantesimi
        if (position in magie.indices) {
            val incantesimo = magie[position]
            // Esegue il binding dell'incantesimo alla vista
            holder.bind(incantesimo)
        }
    }

    // Restituisce il numero totale di elementi nell'elenco di incantesimi
    override fun getItemCount(): Int {
        return magie.size
    }

    // Aggiorna l'elenco di incantesimi con una nuova lista e notifica l'adattatore
    fun updateMagie(incantesimi: List<Incantesimo>) {
        this.magie = incantesimi
        notifyDataSetChanged()
    }


    // ViewHolder per rappresentare un elemento della lista di incantesimi
    inner class IncantesimoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.textViewIncantesimo)
        private val livelloTextView: TextView = itemView.findViewById(R.id.textViewLivello)
        private val tipoTextView: TextView = itemView.findViewById(R.id.textViewTipo)

        // Associa i dati di un incantesimo alla vista dell'elemento della lista
        fun bind(incantesimo: Incantesimo) {
            // Imposta il nome dell'incantesimo nella vista
            nameTextView.text = incantesimo.nome
            // Imposta il livello dell'incantesimo nella vista
            livelloTextView.text = incantesimo.livello.toString()
            // Imposta il tipo dell'incantesimo nella vista
            tipoTextView.text = incantesimo.tipo

            // Gestisce il click sull'elemento della lista
            itemView.setOnClickListener {
                // Crea un bundle per passare i dati dell'incantesimo al fragment di destinazione
                val args = Bundle().apply {
                    putString("nomeIncantesimo", incantesimo.nome)
                    putString("infoIncantesimo", incantesimo.info)
                    putString("classiIncantesimo", incantesimo.classi)
                }

                // Naviga al fragment di destinazione in base al fragment corrente
                when (currentFragment) {
                    is ListaMagieFragment -> {
                        itemView.findNavController().navigate(R.id.action_listaMagieFragment_to_infoMagiaFragment, args)
                    }
                    is MagieFragment -> {
                        itemView.findNavController().navigate(R.id.action_magieFragment_to_infoMagiaFragment, args)
                    }
                }
            }
        }
    }
}

