package com.progetto_dd.view.campaigns

import com.progetto_dd.memory.campagna.CampagnaViewModel
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.memory.campagna.CampagnaAdapter

class HomeCampaignsFragment : Fragment() {

    // RecyclerView e adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CampagnaAdapter
    private lateinit var layoutManager: LinearLayoutManager

    // ViewModel per ottenere i dati
    private lateinit var viewModel: CampagnaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Infla la vista del fragment
        val view = inflater.inflate(R.layout.fragment_home_campaigns, container, false)

        // Inizializza la RecyclerView
        recyclerView = view.findViewById(R.id.reyclerViewCamp)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Ottiene i dati delle campagne tramite il CampagnaViewModel
        viewModel = ViewModelProvider(this).get(CampagnaViewModel::class.java)
        viewModel.getCampagne().observe(viewLifecycleOwner) { campagne ->
            // Imposta l'adapter alla RecyclerView solo se la lista delle campagne non è vuota
            if (campagne.isNotEmpty()) {
                adapter = CampagnaAdapter(campagne)
                recyclerView.adapter = adapter
            }
        }

        return view
    }
}
