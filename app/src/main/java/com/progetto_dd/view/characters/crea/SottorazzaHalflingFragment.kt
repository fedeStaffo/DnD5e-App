package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentSottorazzaHalflingBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class SottorazzaHalflingFragment : Fragment() {

    private var _binding: FragmentSottorazzaHalflingBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    // Dichiarazione dei campi booleani per i pulsanti di razza
    private var piedelestoSelected = false
    private var tozzoSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSottorazzaHalflingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())

        binding.scegliPiedelesto.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliTozzo)
            buttonUtils.updateButtonState(binding.scegliPiedelesto, unclickedButtons)
            piedelestoSelected = true
            tozzoSelected = false
        }

        binding.scegliTozzo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliPiedelesto)
            buttonUtils.updateButtonState(binding.scegliTozzo, unclickedButtons)
            piedelestoSelected = false
            tozzoSelected = true
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoPiedelesto.setOnClickListener {
            viewModel.setRazzaPersonaggio("Halfling piedelesto")
            findNavController().navigate(R.id.action_sottorazzaHalflingFragment_to_sottorazzaInfoFragment)
        }

        binding.infoTozzo.setOnClickListener {
            viewModel.setRazzaPersonaggio("Halfling tozzo")
            findNavController().navigate(R.id.action_sottorazzaHalflingFragment_to_sottorazzaInfoFragment)
        }

        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val razzaSelezionata = when {
                tozzoSelected -> "Halfling tozzo"
                piedelestoSelected -> "Halfling piedelesto"
                else -> null
            }

            if (razzaSelezionata == null) {
                Toast.makeText(requireContext(), "Selezionare una razza!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setRazzaPersonaggio(razzaSelezionata)
                findNavController().navigate(R.id.action_sottorazzaHalflingFragment_to_classFragment)
            }
        }
    }

    // Resetta i booleani se si torna indietro
    override fun onResume() {
        super.onResume()
        piedelestoSelected = false
        tozzoSelected = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}