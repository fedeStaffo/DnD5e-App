package com.progetto_dd.memory.personaggio

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.progetto_dd.R
import com.progetto_dd.view.characters.VisualizzaPersonaggioActivity
import java.util.ArrayList

// Classe adapter per gestire la lista dei personaggi
class PersonaggioAdapter(private val personaggi: List<Personaggio>) :
    RecyclerView.Adapter<PersonaggioAdapter.PersonaggioViewHolder>() {

    // Riferimento all'utente loggato
    private val currentUser = FirebaseAuth.getInstance().currentUser

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

            if(currentUser?.uid == personaggio.utenteId ){
                // Imposta il listener del clic sulla card del personaggio
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, VisualizzaPersonaggioActivity::class.java)

                    intent.putExtra("nome", personaggio.nome)
                    intent.putExtra("razza", personaggio.razza)
                    intent.putExtra("classe", personaggio.classe)
                    intent.putExtra("utente_id", personaggio.utenteId)
                    intent.putExtra("campagna", personaggio.campagna)
                    intent.putStringArrayListExtra("competenze", ArrayList(personaggio.competenze ?: emptyList()))
                    intent.putStringArrayListExtra("equipaggiamento", ArrayList(personaggio.equipaggiamento ?: emptyList()))
                    intent.putExtra("stato", personaggio.stato)
                    intent.putExtra("vitaMax", personaggio.vitaMax.toString())
                    intent.putExtra("vita", personaggio.vita.toString())
                    intent.putExtra("livello", personaggio.livello.toString())
                    intent.putExtra("classeArmatura", personaggio.classeArmatura.toString())

                    intent.putExtra("carisma", personaggio.carisma.toString())
                    intent.putExtra("costituzione", personaggio.costituzione.toString())
                    intent.putExtra("forza", personaggio.forza.toString())
                    intent.putExtra("destrezza", personaggio.destrezza.toString())
                    intent.putExtra("intelligenza", personaggio.intelligenza.toString())
                    intent.putExtra("saggezza", personaggio.saggezza.toString())

                    intent.putExtra("allineamento", personaggio.allineamento)
                    intent.putExtra("descrizione", personaggio.descrizione)
                    intent.putExtra("ideali", personaggio.ideali)
                    intent.putExtra("legami", personaggio.legami)
                    intent.putExtra("storia", personaggio.storia)
                    intent.putExtra("difetti", personaggio.difetti)
                    intent.putExtra("tratti", personaggio.tratti)
                    itemView.context.startActivity(intent)
                }
            }

        }

    }

}