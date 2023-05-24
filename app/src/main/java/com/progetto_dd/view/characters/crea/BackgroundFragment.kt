package com.progetto_dd.view.characters.crea

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentBackgroundBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class BackgroundFragment : Fragment() {

    private var _binding: FragmentBackgroundBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBackgroundBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            // Salva tutte le stringhe nel ViewModel
            viewModel.setBackgroundDescrizione(binding.descrizioneEt.text.toString())
            viewModel.setBackgroundStoria(binding.storiaEt.text.toString())
            viewModel.setBackgroundIdeali(binding.idealiEt.text.toString())
            viewModel.setBackgroundDifetti(binding.difettiEt.text.toString())
            viewModel.setBackgroundLegami(binding.legamiEt.text.toString())
            viewModel.setBackgroundTratti(binding.trattiEt.text.toString())

            // Salva l'allineamento scelto dallo spinner
            viewModel.setBackgroundAllineamento(binding.allineamentoSpinner.selectedItem.toString())

            findNavController().navigate(R.id.action_backgroundFragment_to_rollFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}