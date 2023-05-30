package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoAdapter
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoDatabase
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModel
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModelFactory

class ListaMagieFragment : Fragment() {

    private lateinit var spinnerIncantatore: Spinner
    private lateinit var spinnerLivello: Spinner
    private lateinit var spinnerTipo: Spinner
    private lateinit var buttonCerca: Button
    private lateinit var recyclerViewMagie: RecyclerView
    private lateinit var adapter: IncantesimoAdapter
    private lateinit var viewModel: IncantesimoViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_lista_magie, container, false)
        spinnerIncantatore = rootView.findViewById(R.id.spinnerIncantatore)
        spinnerLivello = rootView.findViewById(R.id.spinnerLivello)
        spinnerTipo = rootView.findViewById(R.id.spinnerTipo)
        buttonCerca = rootView.findViewById(R.id.buttonCerca)
        recyclerViewMagie = rootView.findViewById(R.id.reyclerViewMagie)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = IncantesimoAdapter(emptyList(),this)
        recyclerViewMagie.adapter = adapter
        recyclerViewMagie.layoutManager = LinearLayoutManager(requireContext())

        val database = IncantesimoDatabase.getInstance(requireContext())
        val dao = database.incantesimoDao

        val viewModelFactory = IncantesimoViewModelFactory(dao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(IncantesimoViewModel::class.java)

        viewModel.incantesimi.observe(viewLifecycleOwner, Observer { incantesimi ->
            adapter.updateMagie(incantesimi)
        })

        buttonCerca.setOnClickListener {
            val incantatore = spinnerIncantatore.selectedItem.toString()
            val livello = spinnerLivello.selectedItem.toString()
            val tipo = spinnerTipo.selectedItem.toString()

            if(incantatore == "-") Toast.makeText(requireContext(), "Seleziona un incantatore!", Toast.LENGTH_SHORT).show()

            if(incantatore != "-" && livello == "-" && tipo == "-"){
                viewModel.getIncantesimiByClass(incantatore)
            }

            if(incantatore != "-" && livello != "-" && tipo == "-"){
                viewModel.getIncantesimiByLevelAndClass(livello.toInt(), incantatore)
            }

            if(incantatore != "-" && livello == "-" && tipo!= "-"){
                viewModel.getIncantesimiByTypeAndClass(tipo,incantatore)
            }

            if(incantatore != "-" && livello != "-" && tipo != "-"){
                viewModel.getIncantesimiByParams(livello.toInt(),tipo, incantatore)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerViewMagie.adapter = null
    }
}

