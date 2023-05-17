package com.progetto_dd.memory.personaggio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R

class CompetenzeAdapter(private var competenzeList: List<String>) : RecyclerView.Adapter<CompetenzeAdapter.CompetenzaViewHolder>() {

    private var selectedPosition = -1

    inner class CompetenzaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val radioButton: RadioButton = itemView.findViewById(R.id.competenzaRadioButton)
        val competenzaName: TextView = itemView.findViewById(R.id.competenzaName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetenzaViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_competenza, parent, false)
        return CompetenzaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CompetenzaViewHolder, position: Int) {
        val competenza = competenzeList[position]
        holder.competenzaName.text = competenza
        holder.radioButton.isChecked = position == selectedPosition

        holder.itemView.setOnClickListener {
            selectedPosition = holder.absoluteAdapterPosition
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return competenzeList.size
    }

    fun updateCompetenzeNomi(competenzeNomi: List<String>) {
        competenzeList = competenzeNomi
        notifyDataSetChanged()
    }
}
