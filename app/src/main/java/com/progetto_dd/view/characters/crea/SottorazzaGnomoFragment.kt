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
import com.progetto_dd.databinding.FragmentSottorazzaGnomoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class SottorazzaGnomoFragment : Fragment() {

    private var _binding: FragmentSottorazzaGnomoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    // Dichiarazione dei campi booleani per i pulsanti di razza
    private var foresteSelected = false
    private var rocceSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSottorazzaGnomoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())

        binding.scegliForeste.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliRocce)
            buttonUtils.updateButtonState(binding.scegliForeste, unclickedButtons)
            foresteSelected = true
            rocceSelected = false
        }

        binding.scegliRocce.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliForeste)
            buttonUtils.updateButtonState(binding.scegliRocce, unclickedButtons)
            foresteSelected = false
            rocceSelected = true
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoForeste.setOnClickListener {
            viewModel.setRazzaPersonaggio("Gnomo delle foreste")
            findNavController().navigate(R.id.action_sottorazzaGnomoFragment_to_sottorazzaInfoFragment)
        }

        binding.infoRocce.setOnClickListener {
            viewModel.setRazzaPersonaggio("Gnomo delle rocce")
            findNavController().navigate(R.id.action_sottorazzaGnomoFragment_to_sottorazzaInfoFragment)
        }

        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val razzaSelezionata = when {
                rocceSelected -> "Gnomo delle rocce"
                foresteSelected -> "Gnomo delle foreste"
                else -> null
            }

            if (razzaSelezionata == null) {
                Toast.makeText(requireContext(), "Selezionare una razza!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setRazzaPersonaggio(razzaSelezionata)
                findNavController().navigate(R.id.action_sottorazzaGnomoFragment_to_classFragment)
            }
        }
    }

    // Resetta i booleani se si torna indietro
    override fun onResume() {
        super.onResume()
        foresteSelected = false
        rocceSelected = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}