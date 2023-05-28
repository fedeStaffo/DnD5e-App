package com.progetto_dd.view.characters.visualizza

import IncantesimoAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentMagieBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoDatabase
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModel
import com.progetto_dd.memory.personaggio.incantesimo.IncantesimoViewModelFactory

class MagieFragment : Fragment() {

    private var _binding: FragmentMagieBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel
    private lateinit var viewModelInc: IncantesimoViewModel

    private lateinit var trucchettiAdapter: IncantesimoAdapter
    private lateinit var livello1Adapter: IncantesimoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMagieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        trucchettiAdapter = IncantesimoAdapter(emptyList())
        livello1Adapter = IncantesimoAdapter(emptyList())

        binding.recyclerViewTrucchetti.adapter = trucchettiAdapter
        binding.recyclerViewLiv1.adapter = livello1Adapter

        binding.recyclerViewTrucchetti.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewLiv1.layoutManager = LinearLayoutManager(requireContext())

        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val database = IncantesimoDatabase.getInstance(requireContext())
        val dao = database.incantesimoDao

        val viewModelFactory = IncantesimoViewModelFactory(dao)
        viewModelInc = ViewModelProvider(this, viewModelFactory).get(IncantesimoViewModel::class.java)

        val nomePersonaggio = arguments?.getString("nomePersonaggio")
        val utenteId = arguments?.getString("utenteId")

        if (nomePersonaggio != null && utenteId != null) {
            viewModel.getMagieFromFirestore(nomePersonaggio, utenteId).observe(viewLifecycleOwner) { magie ->
                viewModelInc.getIncantesimiByNomi(magie)
                val listaIncantesimi = viewModelInc.incantesimi.value

                listaIncantesimi?.let { incantesimi ->
                    val trucchetti = incantesimi.filter { it.livello == 0 }
                    val livello1 = incantesimi.filter { it.livello == 1 }
                    // ... filtra gli incantesimi per gli altri livelli

                    trucchettiAdapter.updateMagie(trucchetti)
                    livello1Adapter.updateMagie(livello1)
                    // ... aggiorna gli adapter per gli altri livelli con gli incantesimi filtrati
                }
            }
        }


        binding.btnAggiungiIncantesimo.setOnClickListener {
            findNavController().navigate(R.id.action_magieFragment_to_listaMagieFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
