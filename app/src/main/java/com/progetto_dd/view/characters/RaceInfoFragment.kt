package com.progetto_dd.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentRaceInfoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class RaceInfoFragment : Fragment() {

    private var _binding: FragmentRaceInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRaceInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il viewmodel
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Inizializza la razza selezionata dall'utente dal viewmodel
        val razza = viewModel.razzaPersonaggio.value

        // Chiama la funzione getInfoRazza del viewmodel per ottenere le informazioni sulla razza
        if (razza != null) {
            viewModel.getInfoRazza(razza).observe(viewLifecycleOwner, Observer { infoRazza ->
                // Aggiorna la TextView con le informazioni sulla razza
                binding.raceInfoText.text = infoRazza ?: ""
            })
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}