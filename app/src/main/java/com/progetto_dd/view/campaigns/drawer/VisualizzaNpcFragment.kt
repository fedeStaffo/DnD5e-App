package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.memory.npc.NpcAdapter
import com.progetto_dd.memory.npc.NpcViewModel


class VisualizzaNpcFragment : Fragment() {

    // RecyclerView e adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NpcAdapter
    private lateinit var layoutManager: LinearLayoutManager

    // ViewModel per ottenere i dati
    private lateinit var viewModel: NpcViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_visualizza_npc, container, false)

        // Inizializza la RecyclerView
        recyclerView = view.findViewById(R.id.reyclerViewNpc)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Recupera i dati passati dall'adapter
        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        // Ottiene i dati delle campagne tramite il CampagnaViewModel
        viewModel = ViewModelProvider(this).get(NpcViewModel::class.java)
        if (campagnaNome != null && masterId != null) {
            viewModel.getNpc(campagnaNome, masterId).observe(viewLifecycleOwner) { npc ->
                // Imposta l'adapter alla RecyclerView solo se la lista delle campagne non è vuota
                if (npc.isNotEmpty()) {
                    adapter = NpcAdapter(npc)
                    recyclerView.adapter = adapter
                }
            }
        }

        return view
    }

}