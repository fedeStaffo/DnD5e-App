package com.progetto_dd.view.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentSalvaPersonaggioBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel


class SalvaPersonaggioFragment : Fragment() {

    private var _binding: FragmentSalvaPersonaggioBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSalvaPersonaggioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Salva il personaggio
        binding.btnSalva.setOnClickListener {
            viewModel.saveCharacterToFirestore()
            findNavController().navigate(R.id.action_salvaPersonaggioFragment_to_homeCharacterFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}