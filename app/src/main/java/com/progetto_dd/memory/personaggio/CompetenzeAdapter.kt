package com.progetto_dd.memory.personaggio

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

    private val selectedItems = mutableSetOf<String>()

    inner class CompetenzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkBox: CheckBox = itemView.findViewById(R.id.competenzaCheckBox)
        val competenzaName: TextView = itemView.findViewById(R.id.competenzaName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetenzaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_competenza, parent, false)
        return CompetenzaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CompetenzaViewHolder, position: Int) {
        val competenza = competenzeList[position]
        holder.competenzaName.text = competenza
        holder.checkBox.isChecked = selectedItems.contains(competenza)

        holder.itemView.setOnClickListener {
            val isChecked = !selectedItems.contains(competenza)

            if (isChecked && selectedItems.size >= numCompetenze) {
                // Se è stato raggiunto il limite di selezioni, non permettere di selezionare ulteriori checkbox
                return@setOnClickListener
            }

            if (isChecked) {
                selectedItems.add(competenza)
            } else {
                selectedItems.remove(competenza)
            }

            holder.checkBox.isChecked = isChecked
        }
    }

    override fun getItemCount(): Int {
        return competenzeList.size
    }

    fun updateCompetenzeNomi(competenzeNomi: List<String>) {
        competenzeList = competenzeNomi
        notifyDataSetChanged()
    }

    fun updateNumCompetenze(num: Int) {
        numCompetenze = num
        notifyDataSetChanged()
    }

    fun getSelectedCompetenze(): Set<String> {
        return selectedItems
    }
}
