package com.progetto_dd.view.characters.crea

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentSalvaPersonaggioBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.view.characters.CharacterActivity


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

            // Restarta l'activity personaggio
            val intent = Intent(activity, CharacterActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}