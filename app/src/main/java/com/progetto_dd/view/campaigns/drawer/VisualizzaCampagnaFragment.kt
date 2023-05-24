package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentAddCampaignBinding
import com.progetto_dd.databinding.FragmentVisualizzaCampagnaBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.personaggio.PersonaggioAdapter

class VisualizzaCampagnaFragment : Fragment() {


    // RecyclerView e adapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonaggioAdapter
    private lateinit var layoutManager: LinearLayoutManager

    // ViewModel per ottenere i dati
    private lateinit var viewModel: CampagnaViewModel

    // Binding
    private var _binding: FragmentVisualizzaCampagnaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentVisualizzaCampagnaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(CampagnaViewModel::class.java)

        // Inizializza la RecyclerView
        recyclerView = view.findViewById(R.id.reyclerViewPers)
        layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager

        // Recupera i dati passati dall'adapter
        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")
        val masterNome = requireActivity().intent.getStringExtra("master_nome")

        // Salva tutto nel ViewModel
        if (campagnaNome != null && masterId!=null && masterNome!=null) {
            viewModel.setNomeCampagna(campagnaNome)
            viewModel.setNomeMaster(masterNome)
            viewModel.setNomeMasterId(masterId)
        }

        // Ottiene i dati dei personaggi tramite il PersonaggioViewModel
        viewModel = ViewModelProvider(this).get(CampagnaViewModel::class.java)
        if (campagnaNome != null) {
            viewModel.getPersonaggiByCampagna(campagnaNome).observe(viewLifecycleOwner) { personaggi ->
                // Imposta l'adapter alla RecyclerView
                adapter = PersonaggioAdapter(personaggi)
                recyclerView.adapter = adapter
            }
        }

        binding.nomeMaster.text = masterNome
    }


}