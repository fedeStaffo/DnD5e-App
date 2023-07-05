package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.fragment.app.Fragment
import com.progetto_dd.R
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.databinding.FragmentRaceBinding
import com.progetto_dd.databinding.FragmentTipoDragonideBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.utils.ButtonUtils

class TipoDragonideFragment : Fragment() {

    private var _binding: FragmentTipoDragonideBinding? = null
    private val binding get() = _binding!!
    private val myList: MutableList<String> = mutableListOf()
    private lateinit var viewModelPersonaggio: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTipoDragonideBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onResume()

        // Inizializza il view model
        viewModelPersonaggio = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        binding.argentoCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide d'argento")
        )

        binding.biancoCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide bianco")
        )

        binding.bluCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide blu")
        )

        binding.bronzoCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide di bronzo")
        )

        binding.neroCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide nero")
        )

        binding.oroCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide d'oro")
        )

        binding.ottoneCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide d'ottone")
        )

        binding.rameCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide di rame")
        )

        binding.rossoCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide rosso")
        )

        binding.verdeCheckBox.setOnCheckedChangeListener(
            createSubraceCheckBoxListener("Dragonide verde")
        )

        binding.btnAvanti.setOnClickListener {
            if(myList.size > 1) {
                Toast.makeText(
                    context,
                    "Puoi selezionare solo un tipo di drago",
                    Toast.LENGTH_LONG
                ).show()
            }else if(myList.size == 0) {
                Toast.makeText(
                    context,
                    "Devi selezionare un tipo di drago",
                    Toast.LENGTH_LONG
                ).show()
            }else {
                val razza = myList[0]
                viewModelPersonaggio.setRazzaPersonaggio(razza)
                findNavController().navigate(R.id.action_tipoDragonideFragment_to_classFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onResume() {
        super.onResume()

        // Resetta lo stato di tutti i checkbox
        binding.argentoCheckBox.isChecked = false
        binding.biancoCheckBox.isChecked = false
        binding.bluCheckBox.isChecked = false
        binding.bronzoCheckBox.isChecked = false
        binding.neroCheckBox.isChecked = false
        binding.oroCheckBox.isChecked = false
        binding.ottoneCheckBox.isChecked = false
        binding.rameCheckBox.isChecked = false
        binding.rossoCheckBox.isChecked = false
        binding.verdeCheckBox.isChecked = false

        myList.clear()
    }

    private fun createSubraceCheckBoxListener(
        sottorazza: String
    ): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (!myList.contains(sottorazza)) {
                    myList.add(sottorazza)
                }
            } else {
                myList.remove(sottorazza)
            }
        }
    }
}