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
import com.progetto_dd.databinding.FragmentRaceBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class RaceFragment : Fragment() {

    private var _binding: FragmentRaceBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    // Dichiarazione dei campi booleani per i pulsanti di razza
    private var elfoSelected = false
    private var umanoSelected = false
    private var nanoSelected = false
    private var dragonideSelected = false
    private var gnomoSelected = false
    private var halflingSelected = false
    private var tieflingSelected = false
    private var mezzorcoSelected = false
    private var mezzelfoSelected = false

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
            val unclickedButtons = listOf(binding.scegliUmano, binding.scegliElfo, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliNano, unclickedButtons)
            nanoSelected = true
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        binding.scegliElfo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliUmano, binding.scegliNano, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliElfo, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = true
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        binding.scegliUmano.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliUmano, unclickedButtons)
            nanoSelected = false
            umanoSelected = true
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        binding.scegliDragonide.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliUmano, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliDragonide, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = true
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        binding.scegliGnomo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliDragonide, binding.scegliUmano,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliGnomo, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = true
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        binding.scegliHalfling.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliUmano, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliHalfling, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = true
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        binding.scegliMezzelfo.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliUmano, binding.scegliMezzorco, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliMezzelfo, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = true
            mezzorcoSelected = false
        }

        binding.scegliMezzorco.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliUmano, binding.scegliTiefling)
            buttonUtils.updateButtonState(binding.scegliMezzorco, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = false
            mezzelfoSelected = false
            mezzorcoSelected = true
        }

        binding.scegliTiefling.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliNano, binding.scegliElfo, binding.scegliDragonide, binding.scegliGnomo,
                binding.scegliHalfling, binding.scegliMezzelfo, binding.scegliMezzorco, binding.scegliUmano)
            buttonUtils.updateButtonState(binding.scegliTiefling, unclickedButtons)
            nanoSelected = false
            umanoSelected = false
            elfoSelected = false
            gnomoSelected = false
            dragonideSelected = false
            halflingSelected = false
            tieflingSelected = true
            mezzelfoSelected = false
            mezzorcoSelected = false
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoElfo.setOnClickListener {
            viewModel.setRazzaPersonaggio("Elfo")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoUmano.setOnClickListener {
            viewModel.setRazzaPersonaggio("Umano")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoNano.setOnClickListener {
            viewModel.setRazzaPersonaggio("Nano")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoDragonide.setOnClickListener {
            viewModel.setRazzaPersonaggio("Dragonide")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoGnomo.setOnClickListener {
            viewModel.setRazzaPersonaggio("Gnomo")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoHalfling.setOnClickListener {
            viewModel.setRazzaPersonaggio("Halfling")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoTiefling.setOnClickListener {
            viewModel.setRazzaPersonaggio("Tiefling")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoMezzorco.setOnClickListener {
            viewModel.setRazzaPersonaggio("Mezzorco")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }

        binding.infoMezzelfo.setOnClickListener {
            viewModel.setRazzaPersonaggio("Mezzelfo")
            findNavController().navigate(R.id.action_raceFragment_to_raceInfoFragment)
        }


        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val razzaSelezionata = when {
                elfoSelected -> "Elfo"
                umanoSelected -> "Umano"
                nanoSelected -> "Nano"
                dragonideSelected -> "Dragonide"
                gnomoSelected -> "Gnomo"
                halflingSelected -> "Halfling"
                tieflingSelected -> "Tiefling"
                mezzelfoSelected -> "Mezzelfo"
                mezzorcoSelected -> "Mezzorco"
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

    // Resetta i booleani se si torna indietro
    override fun onResume() {
        super.onResume()
        nanoSelected = false
        umanoSelected = false
        elfoSelected = false
        gnomoSelected = false
        dragonideSelected = false
        halflingSelected = false
        tieflingSelected = false
        mezzelfoSelected = false
        mezzorcoSelected = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}