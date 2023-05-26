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
import com.progetto_dd.memory.sessione.SessioneAdapter
import com.progetto_dd.memory.sessione.SessioneViewModel


class VisualizzaSessioneFragment : Fragment() {

    // RecyclerView e adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SessioneAdapter
    private lateinit var layoutManager: LinearLayoutManager

    // ViewModel per ottenere i dati
    private lateinit var viewModel: SessioneViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_visualizza_sessione, container, false)

        // Inizializza la RecyclerView
        recyclerView = view.findViewById(R.id.recylerViewSessioni)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Recupera i dati passati dall'adapter
        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        // Ottiene i dati delle campagne tramite il CampagnaViewModel
        viewModel = ViewModelProvider(this).get(SessioneViewModel::class.java)
        if (campagnaNome != null && masterId != null) {
            viewModel.getSessione(campagnaNome, masterId).observe(viewLifecycleOwner) { sessione ->
                // Imposta l'adapter alla RecyclerView solo se la lista delle campagne non è vuota
                if (sessione.isNotEmpty()) {
                    adapter = SessioneAdapter(sessione)
                    recyclerView.adapter = adapter
                }
            }
        }

        return view
    }
}