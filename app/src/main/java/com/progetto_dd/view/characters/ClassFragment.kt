package com.progetto_dd.view.characters

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentClassBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils


class ClassFragment : Fragment() {

    private var _binding: FragmentClassBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        _binding = FragmentClassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())

        binding.scegliBardo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliMago)
            buttonUtils.updateButtonState(binding.scegliBardo, unclickedButtons)
        }

        binding.scegliLadro.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliBardo, binding.scegliMago)
            buttonUtils.updateButtonState(binding.scegliLadro, unclickedButtons)
        }

        binding.scegliGuerriero.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliBardo, binding.scegliLadro, binding.scegliMago)
            buttonUtils.updateButtonState(binding.scegliGuerriero, unclickedButtons)
        }

        binding.scegliMago.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliGuerriero, binding.scegliLadro, binding.scegliBardo)
            buttonUtils.updateButtonState(binding.scegliMago, unclickedButtons)
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoBardo.setOnClickListener {
            viewModel.setClassePersonaggio("bardo")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoGuerriero.setOnClickListener {
            viewModel.setClassePersonaggio("guerriero")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoLadro.setOnClickListener {
            viewModel.setClassePersonaggio("ladro")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        binding.infoMago.setOnClickListener {
            viewModel.setClassePersonaggio("mago")
            findNavController().navigate(R.id.action_classFragment_to_classInfoFragment)
        }

        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val classeSelezionata = when {
                binding.scegliBardo.text.toString().contains("SCEGLI").not() -> "Bardo"
                binding.scegliLadro.text.toString().contains("SCEGLI").not() -> "Ladro"
                binding.scegliGuerriero.text.toString().contains("SCEGLI").not() -> "Guerriero"
                binding.scegliMago.text.toString().contains("SCEGLI").not() -> "Mago"
                else -> null
            }

            if (classeSelezionata == null) {
                Toast.makeText(requireContext(), "Selezionare una classe!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setClassePersonaggio(classeSelezionata)
                findNavController().navigate(R.id.action_classFragment_to_competenzeFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}