package com.progetto_dd.memory.personaggio

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.view.characters.visualizza.VisualizzaPersonaggioActivity

// Classe adapter per gestire la lista dei personaggi
class PersonaggioAdapter(private val personaggi: List<Personaggio>) :
    RecyclerView.Adapter<PersonaggioAdapter.PersonaggioViewHolder>() {

    // Crea una nuova istanza di PersonaggioViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaggioViewHolder {
        // Infla il layout per l'elemento della lista
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personaggio, parent, false)
        // Restituisce la nuova istanza di PersonaggioViewHolder
        return PersonaggioViewHolder(view)
    }

    // Associa i dati di un personaggio alla relativa view
    override fun onBindViewHolder(holder: PersonaggioViewHolder, position: Int) {
        // Ottiene il personaggio alla posizione specificata
        val character = personaggi[position]
        // Chiama il metodo bind di PersonaggioViewHolder per associare i dati alla view
        holder.bind(character)
    }

    // Restituisce il numero di elementi nella lista
    override fun getItemCount(): Int {
        return personaggi.size
    }

    // Classe che contiene la view per ogni elemento della lista
    inner class PersonaggioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Inizializza le view
        private val nameTextView: TextView = itemView.findViewById(R.id.listap_nome)
        private val raceTextView: TextView = itemView.findViewById(R.id.listap_razza)
        private val classTextView: TextView = itemView.findViewById(R.id.listap_classe)

        // Associa i dati del personaggio alle view
        fun bind(personaggio: Personaggio) {
            // Imposta il nome del personaggio
            nameTextView.text = personaggio.nome
            // Imposta la razza del personaggio
            raceTextView.text = personaggio.razza
            // Imposta la classe del personaggio
            classTextView.text = personaggio.classe

            // Imposta il listener del clic sulla card del personaggio
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, VisualizzaPersonaggioActivity::class.java)
                // Passa il nome della campagna e l'id del master alla nuova activity
                intent.putExtra("nome", personaggio.nome)
                intent.putExtra("razza", personaggio.razza)
                intent.putExtra("classe", personaggio.classe)
                itemView.context.startActivity(intent)
            }

        }

    }

}