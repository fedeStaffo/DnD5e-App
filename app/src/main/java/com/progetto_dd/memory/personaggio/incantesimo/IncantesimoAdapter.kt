import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.memory.personaggio.incantesimo.Incantesimo

class IncantesimoAdapter(var magie: List<Incantesimo>) :
    RecyclerView.Adapter<IncantesimoAdapter.IncantesimoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IncantesimoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_incantesimo, parent, false)
        return IncantesimoViewHolder(view)
    }

    override fun onBindViewHolder(holder: IncantesimoViewHolder, position: Int) {
        if (position in magie.indices) {
            val incantesimo = magie[position]
            holder.bind(incantesimo)
        }
    }

    override fun getItemCount(): Int {
        return magie.size
    }

    fun updateMagie(incantesimi: List<Incantesimo>) {
        this.magie = incantesimi
        notifyDataSetChanged()
    }


    inner class IncantesimoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val nameTextView: TextView = itemView.findViewById(R.id.textViewIncantesimo)
        private val livelloTextView: TextView = itemView.findViewById(R.id.textViewLivello)
        private val tipoTextView: TextView = itemView.findViewById(R.id.textViewTipo)

        fun bind(incantesimo: Incantesimo) {
            nameTextView.text = incantesimo.nome
            livelloTextView.text = incantesimo.livello.toString()
            tipoTextView.text = incantesimo.tipo

            itemView.setOnClickListener {
                val args = Bundle().apply {
                    putString("nomeIncantesimo", incantesimo.nome)
                    putString("infoIncantesimo", incantesimo.info)
                    putString("classiIncantesimo", incantesimo.classi)
                }
                itemView.findNavController().navigate(R.id.action_listaMagieFragment_to_infoMagiaFragment, args)
            }
        }
    }
}
