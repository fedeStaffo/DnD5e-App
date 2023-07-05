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
import com.progetto_dd.databinding.FragmentCaratteristicheMezzelfoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class CaratteristicheMezzelfoFragment: Fragment() {

    private var _binding: FragmentCaratteristicheMezzelfoBinding? = null
    private val binding get() = _binding!!
    private val myListLin: MutableList<String> = mutableListOf()
    private val myListCom: MutableList<String> = mutableListOf()
    private val myListCar: MutableList<String> = mutableListOf()
    private lateinit var viewModelPersonaggio: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCaratteristicheMezzelfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onResume()

        // Inizializza il view model del Personaggio
        viewModelPersonaggio = ViewModelProvider(requireActivity())[PersonaggioViewModel::class.java]

        binding.atleticaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Atletica")
        )

        binding.acrobaziaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Acrobazia")
        )

        binding.rapiditamanoCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Rapidità di mano")
        )

        binding.furtivitaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Furtività")
        )

        binding.arcanoCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Arcano")
        )

        binding.indagareCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Indagare")
        )

        binding.naturaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Natura")
        )

        binding.religioneCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Religione")
        )

        binding.storiaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Storia")
        )

        binding.addanimaliCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Addestrare Animali")
        )

        binding.intuizioneCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Intuizione")
        )

        binding.medicinaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Medicina")
        )

        binding.percezioneCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Percezione")
        )

        binding.sopravvivenzaCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Sopravvivenza")
        )

        binding.intimidazioneCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Intimidire")
        )

        binding.ingannoCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Inganno")
        )

        binding.intrattenereCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Intrattenere")
        )

        binding.persuasioneCheckBox.setOnCheckedChangeListener(
            createCompetenzaCheckBoxListener("Persuasione")
        )

        binding.forzaCheckBox.setOnCheckedChangeListener(
            createCaratteristicaCheckBoxListener("Forza")
        )

        binding.destrezzaCheckBox.setOnCheckedChangeListener(
            createCaratteristicaCheckBoxListener("Destrezza")
        )

        binding.costituzioneCheckBox.setOnCheckedChangeListener(
            createCaratteristicaCheckBoxListener("Costituzione")
        )

        binding.intelligenzaCheckBox.setOnCheckedChangeListener(
            createCaratteristicaCheckBoxListener("Intelligenza")
        )

        binding.saggezzaCheckBox.setOnCheckedChangeListener(
            createCaratteristicaCheckBoxListener("Saggezza")
        )

        binding.carismaCheckBox.setOnCheckedChangeListener(
            createCaratteristicaCheckBoxListener("Carisma")
        )

        binding.btnAvanti.setOnClickListener {
            val sceltaLin = binding.spinnerLingua.selectedItem as String

            if(sceltaLin == "Scegli una lingua"){
                Toast.makeText(activity, "Devi scegliere un linguaggio", Toast.LENGTH_SHORT).show()
            }else if (myListCar.size != 2) {
                Toast.makeText(activity, "Devi scegliere 2 caratteristiche", Toast.LENGTH_SHORT).show()
            }else if (myListCom.size != 2) {
                Toast.makeText(activity, "Devi scegliere 2 competenze", Toast.LENGTH_SHORT).show()
            }else {
                myListLin.add(sceltaLin)
                viewModelPersonaggio.setLinguaggiPersonaggio(myListLin)
                viewModelPersonaggio.setCompetenzeMezzelfoPersonaggio(myListCom)
                viewModelPersonaggio.setcaratteristicaMezzelfoPersonaggio(myListCar)
                findNavController().navigate(R.id.action_caratteristicheMezzelfoFragment_to_classFragment)
            }
        }
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
                if (!myListCom.contains(competenza)) {
                    myListCom.add(competenza)
                }
            } else {
                myListCom.remove(competenza)
            }
        }
    }

    private fun createCaratteristicaCheckBoxListener(
        competenza: String
    ): CompoundButton.OnCheckedChangeListener {
        return CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                if (!myListCar.contains(competenza)) {
                    myListCar.add(competenza)
                }
            } else {
                myListCar.remove(competenza)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        // Resetta lo stato di tutti i checkbox
        binding.atleticaCheckBox.isChecked = false
        binding.acrobaziaCheckBox.isChecked = false
        binding.rapiditamanoCheckBox.isChecked = false
        binding.furtivitaCheckBox.isChecked = false
        binding.arcanoCheckBox.isChecked = false
        binding.indagareCheckBox.isChecked = false
        binding.naturaCheckBox.isChecked = false
        binding.religioneCheckBox.isChecked = false
        binding.storiaCheckBox.isChecked = false
        binding.addanimaliCheckBox.isChecked = false
        binding.intuizioneCheckBox.isChecked = false
        binding.medicinaCheckBox.isChecked = false
        binding.percezioneCheckBox.isChecked = false
        binding.sopravvivenzaCheckBox.isChecked = false
        binding.intimidazioneCheckBox.isChecked = false
        binding.ingannoCheckBox.isChecked = false
        binding.intrattenereCheckBox.isChecked = false
        binding.persuasioneCheckBox.isChecked = false
        binding.forzaCheckBox.isChecked = false
        binding.destrezzaCheckBox.isChecked = false
        binding.costituzioneCheckBox.isChecked = false
        binding.intelligenzaCheckBox.isChecked = false
        binding.saggezzaCheckBox.isChecked = false
        binding.carismaCheckBox.isChecked = false

        // Rimuovi tutti gli elementi dalla lista myList
        myListCom.clear()
        myListCar.clear()
        myListLin.clear()
    }
}