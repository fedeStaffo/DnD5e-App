package com.progetto_dd.view.characters

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentRaceBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

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
        val viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione
        binding.scegliElfo.setOnClickListener {

            binding.scegliElfo.apply {
                text = getString(R.string.scelto).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.black))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.orange))
            }

            binding.scegliUmano.apply {
                text = getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }

            binding.scegliNano.apply {
                text = getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }
        }

        binding.scegliUmano.setOnClickListener {

            binding.scegliUmano.apply {
                text = getString(R.string.scelto).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.black))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.orange))
            }

            binding.scegliElfo.apply {
                text = getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }

            binding.scegliNano.apply {
                text = getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }

        }

        binding.scegliNano.setOnClickListener {

            binding.scegliNano.apply {
                text = getString(R.string.scelto).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.black))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.orange))
            }

            binding.scegliUmano.apply {
                text = getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }

            binding.scegliElfo.apply {
                text = getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }
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
                binding.scegliElfo.text.toString().contains("scegli").not() -> "Elfo"
                binding.scegliUmano.text.toString().contains("scegli").not() -> "Umano"
                binding.scegliNano.text.toString().contains("scegli").not() -> "Nano"
                else -> null
            }

            if (razzaSelezionata == null) {
                Toast.makeText(requireContext(), "Selezionare una razza!", Toast.LENGTH_SHORT).show()
            } else {
                // Avvia la nuova fragment salvando la razza selezionata
                viewModel.setRazzaPersonaggio(razzaSelezionata)
                findNavController().navigate(R.id.action_raceFragment_to_subRaceFragment)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}