package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
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
    private lateinit var editTextNomeIncantesimo: EditText
    private lateinit var imageViewLente: ImageView
    private lateinit var imageViewFiltro: ImageView
    private lateinit var textIncantatore: TextView
    private lateinit var textLivello: TextView
    private lateinit var textTipo: TextView

    private var isFilterVisible = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla il layout per questo frammento
        val rootView = inflater.inflate(R.layout.fragment_lista_magie, container, false)
        spinnerIncantatore = rootView.findViewById(R.id.spinnerIncantatore)
        spinnerLivello = rootView.findViewById(R.id.spinnerLivello)
        spinnerTipo = rootView.findViewById(R.id.spinnerTipo)
        buttonCerca = rootView.findViewById(R.id.buttonCerca)
        recyclerViewMagie = rootView.findViewById(R.id.reyclerViewMagie)
        editTextNomeIncantesimo = rootView.findViewById(R.id.nomeIncantesimo)
        imageViewLente = rootView.findViewById(R.id.lente)
        imageViewFiltro = rootView.findViewById(R.id.filtro)
        textIncantatore = rootView.findViewById(R.id.textIncantatore)
        textLivello = rootView.findViewById(R.id.textLivello)
        textTipo = rootView.findViewById(R.id.textTipo)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inizializza l'adapter e il layout manager per la RecyclerView
        adapter = IncantesimoAdapter(emptyList(), this)
        recyclerViewMagie.adapter = adapter
        recyclerViewMagie.layoutManager = LinearLayoutManager(requireContext())

        // Inizializza il view model
        val database = IncantesimoDatabase.getInstance(requireContext())
        val dao = database.incantesimoDao
        val viewModelFactory = IncantesimoViewModelFactory(dao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(IncantesimoViewModel::class.java)

        // Aggiorna la lista degli incantesimi nella RecyclerView
        viewModel.incantesimi.observe(viewLifecycleOwner, Observer { incantesimi ->
            adapter.updateMagie(incantesimi)
        })

        //
        imageViewLente.setOnClickListener {
            val nomeIncantesimo = editTextNomeIncantesimo.text.toString().trim()
            if (nomeIncantesimo.isNotEmpty()) {
                val incantesimi = viewModel.searchIncantesimiByKeyword(nomeIncantesimo)
                adapter.updateMagie(incantesimi)
            } else {
                Toast.makeText(requireContext(), "Inserisci un nome per la ricerca.", Toast.LENGTH_SHORT).show()
            }
        }


        // Gestisce il click sull'immagine del filtro (Mostra/Nascondi filtri)
        imageViewFiltro.setOnClickListener {
            isFilterVisible = !isFilterVisible
            toggleFilterVisibility()
        }

        // Gestisce il click sul pulsante "Cerca"
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

        // Inizialmente nascondi gli spinner e il pulsante
        toggleFilterVisibility()
    }

    private fun toggleFilterVisibility() {
        if (isFilterVisible) {
            spinnerIncantatore.visibility = View.VISIBLE
            spinnerLivello.visibility = View.VISIBLE
            spinnerTipo.visibility = View.VISIBLE
            buttonCerca.visibility = View.VISIBLE
            textTipo.visibility = View.VISIBLE
            textIncantatore.visibility = View.VISIBLE
            textLivello.visibility = View.VISIBLE

        } else {
            spinnerIncantatore.visibility = View.GONE
            spinnerLivello.visibility = View.GONE
            spinnerTipo.visibility = View.GONE
            buttonCerca.visibility = View.GONE
            textTipo.visibility = View.GONE
            textIncantatore.visibility = View.GONE
            textLivello.visibility = View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        recyclerViewMagie.adapter = null
    }
}

