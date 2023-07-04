package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentSottorazzaNanoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class SottorazzaNanoFragment : Fragment() {

    private var _binding: FragmentSottorazzaNanoBinding? = null
    private val binding get() = _binding!!
    private val myList: MutableList<String> = mutableListOf()
    private lateinit var viewModelPersonaggio: PersonaggioViewModel

    // Dichiarazione dei campi booleani per i pulsanti di razza
    private var montagneSelected = false
    private var collineSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSottorazzaNanoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModelPersonaggio = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())

        binding.scegliColline.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliMontagne)
            buttonUtils.updateButtonState(binding.scegliColline, unclickedButtons)
            collineSelected = true
            montagneSelected = false
        }

        binding.scegliMontagne.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliColline)
            buttonUtils.updateButtonState(binding.scegliMontagne, unclickedButtons)
            collineSelected = false
            montagneSelected = true
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoColline.setOnClickListener {
            viewModelPersonaggio.setRazzaPersonaggio("Nano delle colline")
            findNavController().navigate(R.id.action_sottorazzaNanoFragment_to_sottorazzaInfoFragment)
        }

        binding.infoMontagne.setOnClickListener {
            viewModelPersonaggio.setRazzaPersonaggio("Nano delle montagne")
            findNavController().navigate(R.id.action_sottorazzaNanoFragment_to_sottorazzaInfoFragment)
        }

        binding.fabbroCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Strumenti da fabbro")
        )

        binding.mescitoreCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Strumenti da mescitore")
        )

        binding.costruttoreCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Strumenti da costruttore")
        )

        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val razzaSelezionata = when {
                collineSelected -> "Nano delle colline"
                montagneSelected -> "Nano delle montagne"
                else -> null
            }

            if (razzaSelezionata == null) {
                Toast.makeText(context,
                    "Selezionare una razza!",
                    Toast.LENGTH_SHORT).
                show()
            } else if(myList.size != 1){
                Toast.makeText(
                    context,
                    "Seleziona il numero richiesto di competenze!",
                    Toast.LENGTH_LONG
                ).show()
            }else{
                viewModelPersonaggio.setRazzaPersonaggio(razzaSelezionata)
                viewModelPersonaggio.setCompetenzePersonaggio(myList)
                findNavController().navigate(R.id.action_sottorazzaNanoFragment_to_classFragment)
            }
        }
    }

    // Resetta i booleani se si torna indietro
    override fun onResume() {
        super.onResume()
        collineSelected = false
        montagneSelected = false

        myList.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createCompetenzaCheckBoxListener(
        competenza: String
    ): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (!myList.contains(competenza)) {
                    myList.add(competenza)
                }
            } else {
                myList.remove(competenza)
            }
        }
    }
}