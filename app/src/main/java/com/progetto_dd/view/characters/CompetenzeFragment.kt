package com.progetto_dd.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.databinding.FragmentCompetenzeBinding
import com.progetto_dd.memory.personaggio.*

class CompetenzeFragment : Fragment() {

    private var _binding: FragmentCompetenzeBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: CompetenzeAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var viewModel: CompetenzaViewModel
    private lateinit var viewModelPersonaggio: PersonaggioViewModel
    private lateinit var dao: CompetenzaDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompetenzeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il database e il DAO
        dao = CompetenzaDatabase.getInstance(requireContext()).competenzaDao

        // Inizializza la RecyclerView
        recyclerView = binding.recyclerViewCompetenze
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Inizializza l'adapter
        adapter = CompetenzeAdapter(emptyList()) // Passa una lista vuota inizialmente
        recyclerView.adapter = adapter

        // Inizializza il ViewModel delle competenze
        val viewModelFactory = CompetenzaViewModelFactory(dao)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CompetenzaViewModel::class.java)

        // Inizializza il view model del Personaggio
        viewModelPersonaggio = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Osserva competenzeNomiLiveData per ottenere i risultati
        viewModel.competenzeNomiLiveData.observe(viewLifecycleOwner) { competenzeNomi ->
            // Aggiorna l'adapter con i nomi delle competenze
            adapter.updateCompetenzeNomi(competenzeNomi)
        }

        // Ottieni le competenze per una specifica classe (esempio: "Guerriero")
        val classe = viewModelPersonaggio.classePersonaggio.value
        if (classe != null) {
            viewModel.getCompetenzeNomiByClasse(classe)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
