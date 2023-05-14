package com.progetto_dd.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.memory.personaggio.PersonaggioAdapter
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class HomeCharacterFragment : Fragment() {

    // RecyclerView e adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonaggioAdapter
    private lateinit var layoutManager: LinearLayoutManager

    // ViewModel per ottenere i dati
    private lateinit var viewModel: PersonaggioViewModel

    /**
     * Infla la vista del fragment, inizializza la RecyclerView e ottiene i dati dei personaggi
     * tramite il [PersonaggioViewModel].
     * Inoltre imposta l'adapter alla RecyclerView.
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla la vista del fragment
        val view = inflater.inflate(R.layout.fragment_home_character, container, false)

        // Inizializza la RecyclerView
        recyclerView = view.findViewById(R.id.reyclerViewPers)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Ottiene i dati dei personaggi tramite il PersonaggioViewModel
        viewModel = ViewModelProvider(this).get(PersonaggioViewModel::class.java)
        viewModel.getPersonaggi().observe(viewLifecycleOwner) { personaggi ->
            // Imposta l'adapter alla RecyclerView
            adapter = PersonaggioAdapter(personaggi)
            recyclerView.adapter = adapter
        }

        return view
    }
}

