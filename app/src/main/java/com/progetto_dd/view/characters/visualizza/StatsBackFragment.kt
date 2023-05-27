package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentStatsBackBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class StatsBackFragment : Fragment() {

    private var _binding: FragmentStatsBackBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStatsBackBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val intent = requireActivity().intent

        val allineamento = intent.getStringExtra("allineamento")
        val descrizione = intent.getStringExtra("descrizione")
        val legami = intent.getStringExtra("legami")
        val difetti = intent.getStringExtra("difetti")
        val tratti = intent.getStringExtra("tratti")
        val storia = intent.getStringExtra("storia")
        val ideali = intent.getStringExtra("ideali")

        binding.textAllineamento.text = allineamento
        binding.textDescrizione.text = descrizione
        binding.textLegami.text = legami
        binding.textDifetti.text = difetti
        binding.textTratticaratteriali.text = tratti
        binding.textStoria.text = storia
        binding.textIdeali.text = ideali

        binding.btnModifica.setOnClickListener {
            findNavController().navigate(R.id.action_statsBackFragment_to_modificaBackgroundFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}