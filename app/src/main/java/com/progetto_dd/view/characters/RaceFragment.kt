package com.progetto_dd.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentRaceBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class RaceFragment : Fragment() {

    private var _binding: FragmentRaceBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRaceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())

        binding.scegliNano.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliUmano, binding.scegliElfo)
            buttonUtils.updateButtonState(binding.scegliNano, unclickedButtons)
        }

        binding.scegliElfo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliUmano, binding.scegliNano)
            buttonUtils.updateButtonState(binding.scegliElfo, unclickedButtons)
        }

        binding.scegliUmano.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo)
            buttonUtils.updateButtonState(binding.scegliUmano, unclickedButtons)
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoElfo.setOnClickListener {
            viewModel.setRazzaPersonaggio("elfo")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoUmano.setOnClickListener {
            viewModel.setRazzaPersonaggio("umano")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoNano.setOnClickListener {
            viewModel.setRazzaPersonaggio("nano")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }


        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val razzaSelezionata = when {
                binding.scegliElfo.text.toString().contains("SCEGLI").not() -> "Elfo"
                binding.scegliUmano.text.toString().contains("SCEGLI").not() -> "Umano"
                binding.scegliNano.text.toString().contains("SCEGLI").not() -> "Nano"
                else -> null
            }

            if (razzaSelezionata == null) {
                Toast.makeText(requireContext(), "Selezionare una razza!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setRazzaPersonaggio(razzaSelezionata)
                findNavController().navigate(R.id.action_raceFragment_to_classFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}