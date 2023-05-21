package com.progetto_dd.memory.personaggio.competenza

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R

class CompetenzeAdapter(
    private var competenzeList: List<String>,
    private var numCompetenze: Int
) : RecyclerView.Adapter<CompetenzeAdapter.CompetenzaViewHolder>() {

    // Set per tenere traccia degli elementi selezionati
    private val selectedItems = mutableListOf<String>()

    inner class CompetenzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.competenzaCheckBox)
        val competenzaName: TextView = itemView.findViewById(R.id.competenzaName)
    }

    // Infla la vista per l'elemento della competenza
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetenzaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_competenza, parent, false)
        return CompetenzaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CompetenzaViewHolder, position: Int) {
        // Recupera la competenza corrente
        val competenza = competenzeList[position]
        // Imposta il nome della competenza nella vista
        holder.competenzaName.text = competenza
        // Imposta lo stato di selezione del checkbox in base all'elemento selezionato
        holder.checkBox.isChecked = selectedItems.contains(competenza)

        // Aggiunge un listener per il click sull'elemento della competenza
        holder.itemView.setOnClickListener {
            // Inverte lo stato di selezione
            val isChecked = !selectedItems.contains(competenza)

            // Se è stato raggiunto il limite di competenze selezionate, non permettere selezioni aggiuntive
            if (isChecked && selectedItems.size >= numCompetenze) {
                // Se è stato raggiunto il limite di selezioni, non permettere di selezionare ulteriori checkbox
                return@setOnClickListener
            }

            // Aggiunge o rimuove la competenza dalla lista degli elementi selezionati
            if (isChecked) {
                selectedItems.add(competenza)
            } else {
                selectedItems.remove(competenza)
            }

            // Aggiorna lo stato di selezione del checkbox
            holder.checkBox.isChecked = isChecked
        }
    }

    override fun getItemCount(): Int {
        return competenzeList.size
    }

    // Funzione per aggiornare la lista delle competenze
    fun updateCompetenzeNomi(competenzeNomi: List<String>) {
        competenzeList = competenzeNomi
        notifyDataSetChanged()
    }

    // Funzione per aggiornare il numero massimo di competenze selezionabili
    fun updateNumCompetenze(num: Int) {
        numCompetenze = num
        notifyDataSetChanged()
    }

    // Funzione per ottenere le competenze selezionate
    fun getSelectedCompetenze(): List<String> {
        return selectedItems
    }
}
