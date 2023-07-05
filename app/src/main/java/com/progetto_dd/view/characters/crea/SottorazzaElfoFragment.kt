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
import com.progetto_dd.databinding.FragmentSottorazzaElfoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class SottorazzaElfoFragment : Fragment() {

    private var _binding: FragmentSottorazzaElfoBinding? = null
    private val binding get() = _binding!!
    private val myList: MutableList<String> = mutableListOf()
    private lateinit var viewModelPersonaggio: PersonaggioViewModel

    // Dichiarazione dei campi booleani per i pulsanti di razza
    private var altoSelected = false
    private var boschiSelected = false
    private var drowSelected = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSottorazzaElfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModelPersonaggio = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Listener che definiscono il comportamento dei bottoni di selezione chiamando il
        // metodo updateButtonState della classe ButtonUtils
        val buttonUtils = ButtonUtils(requireContext())
        binding.testoAlto.visibility = View.GONE

        binding.scegliAlto.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliBoschi, binding.scegliOscuro)
            buttonUtils.updateButtonState(binding.scegliAlto, unclickedButtons)
            altoSelected = true
            boschiSelected = false
            drowSelected = false
            binding.testoAlto.visibility = View.VISIBLE
        }

        binding.scegliBoschi.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliAlto, binding.scegliOscuro)
            buttonUtils.updateButtonState(binding.scegliBoschi, unclickedButtons)
            boschiSelected = true
            altoSelected = false
            drowSelected = false
            binding.testoAlto.visibility = View.GONE

        }

        binding.scegliOscuro.setOnClickListener {
            val unclickedButtons = listOf(binding.scegliBoschi, binding.scegliAlto)
            buttonUtils.updateButtonState(binding.scegliOscuro, unclickedButtons)
            drowSelected = true
            boschiSelected = false
            altoSelected = false
            binding.testoAlto.visibility = View.GONE
        }

        // Listener che definiscono il comportamento dei bottoni di info
        binding.infoAlto.setOnClickListener {
            viewModelPersonaggio.setRazzaPersonaggio("Elfo alto")
            findNavController().navigate(R.id.action_sottorazzaElfoFragment_to_sottorazzaInfoFragment)
        }

        binding.infoBoschi.setOnClickListener {
            viewModelPersonaggio.setRazzaPersonaggio("Elfo dei boschi")
            findNavController().navigate(R.id.action_sottorazzaElfoFragment_to_sottorazzaInfoFragment)
        }

        binding.infoOscuro.setOnClickListener {
            viewModelPersonaggio.setRazzaPersonaggio("Elfo oscuro")
            findNavController().navigate(R.id.action_sottorazzaElfoFragment_to_sottorazzaInfoFragment)
        }



        // Definisce il comportamento del tasto avanti
        binding.btnAvanti.setOnClickListener {
            val scelta = binding.spinnerLingua.selectedItem as String

            val razzaSelezionata = when {
                altoSelected -> "Elfo alto"
                boschiSelected -> "Elfo dei boschi"
                drowSelected -> "Elfo oscuro"
                else -> null
            }
            if (razzaSelezionata == null) {
                Toast.makeText(context,
                    "Selezionare una razza!",
                    Toast.LENGTH_SHORT).
                show()
            }else if(razzaSelezionata == "Elfo alto") {
                if (scelta != "Scegli una lingua"){
                    myList.add(scelta)
                    viewModelPersonaggio.setLinguaggiPersonaggio(myList)
                    viewModelPersonaggio.setRazzaPersonaggio(razzaSelezionata)
                    findNavController().navigate(R.id.action_sottorazzaElfoFragment_to_classFragment)
                } else {
                    Toast.makeText(activity, "Devi scegliere un linguaggio", Toast.LENGTH_SHORT).show()
                }
            }else{
                viewModelPersonaggio.setRazzaPersonaggio(razzaSelezionata)
                findNavController().navigate(R.id.action_sottorazzaElfoFragment_to_classFragment)
            }
        }
    }


    // Resetta i booleani se si torna indietro
    override fun onResume() {
        super.onResume()
        altoSelected = false
        drowSelected = false
        boschiSelected = false

        myList.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}