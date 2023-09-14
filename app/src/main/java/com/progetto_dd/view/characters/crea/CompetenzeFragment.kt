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
import com.progetto_dd.databinding.FragmentCompetenzeBinding
import com.progetto_dd.memory.personaggio.*

class CompetenzeFragment : Fragment() {

    private var _binding: FragmentCompetenzeBinding? = null
    private val binding get() = _binding!!
    private val myList: MutableList<String> = mutableListOf()
    private lateinit var viewModelPersonaggio: PersonaggioViewModel

    // Variabile temporanea per salvare le competenze originali
    private var competenzeOriginali: List<String> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompetenzeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModelPersonaggio = ViewModelProvider(requireActivity())[PersonaggioViewModel::class.java]

        onResume()

        // Salva le competenze originali quando si crea la vista
        competenzeOriginali = viewModelPersonaggio.competenzePersonaggio.value ?: emptyList()

        // Ottieni le competenze per una specifica classe (esempio: "Guerriero")
        val classe = viewModelPersonaggio.classePersonaggio.value
        val mezzelfo = viewModelPersonaggio.competenzeMezzelfoPersonaggio.value
        val razza = viewModelPersonaggio.razzaPersonaggio.value


        if (classe != null) {

            // Prende il numero di competenze in base alla classe passata
            var numCompetenze = getNumCompetenzeByClasse(classe)
            binding.numCompetenze = numCompetenze

            // Setta le competenze per ogni classe
            when (classe) {
                "Bardo" -> {
                    binding.competenzeMonaco.visibility = View.GONE
                }
                "Barbaro" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.intuizione.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.religione.visibility = View.GONE
                    binding.storia.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }

                "Chierico" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.atletica.visibility = View.GONE
                    binding.intimidazione.visibility = View.GONE
                    binding.percezione.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.addestrareanimali.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                }

                "Druido" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.atletica.visibility = View.GONE
                    binding.intimidazione.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.storia.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }

                "Guerriero" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.religione.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }
                "Ladro" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.religione.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                }
                "Mago" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.atletica.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.addestrareanimali.visibility = View.GONE
                    binding.percezione.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.intimidazione.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }

                "Monaco" ->{
                    binding.competenzeBardo.visibility = View.GONE
                    binding.intimidazione.visibility = View.GONE
                    binding.percezione.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.addestrareanimali.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }

                "Paladino" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.percezione.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.storia.visibility = View.GONE
                    binding.addestrareanimali.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                }

                "Ranger" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.intimidazione.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.arcano.visibility = View.GONE
                    binding.religione.visibility = View.GONE
                    binding.storia.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.inganno.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }

                "Stregone" -> {
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.atletica.visibility = View.GONE
                    binding.percezione.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.indagare.visibility = View.GONE
                    binding.natura.visibility = View.GONE
                    binding.storia.visibility = View.GONE
                    binding.addestrareanimali.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                }

                "Warlock" ->{
                    binding.competenzeBardo.visibility = View.GONE
                    binding.competenzeMonaco.visibility = View.GONE
                    binding.acrobazia.visibility = View.GONE
                    binding.atletica.visibility = View.GONE
                    binding.intuizione.visibility = View.GONE
                    binding.percezione.visibility = View.GONE
                    binding.sopravvivenza.visibility = View.GONE
                    binding.furtivita.visibility = View.GONE
                    binding.rapiditadimano.visibility = View.GONE
                    binding.addestrareanimali.visibility = View.GONE
                    binding.medicina.visibility = View.GONE
                    binding.intrattenere.visibility = View.GONE
                    binding.persuasione.visibility = View.GONE
                }
            }

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

            binding.btnAvanti.setOnClickListener {
                val selezione1 = binding.spinner1.selectedItem as? String
                val selezione2 = binding.spinner2.selectedItem as? String
                val selezione3 = binding.spinner3.selectedItem as? String
                val selezioneMus = binding.spinnerMusicale.selectedItem as? String
                val selezioneArt = binding.spinnerArtigiano.selectedItem as? String
                val list = viewModelPersonaggio.competenzePersonaggio.value

                if (mezzelfo != null) {
                    if(mezzelfo.size != 0){
                        myList.addAll(mezzelfo)
                        numCompetenze += 2
                    }
                }

                if(razza != null) {
                    if (classe == "Bardo") {
                        if(myList.size != numCompetenze){
                            Toast.makeText(
                                context,
                                "Seleziona il numero richiesto di competenze!",
                                Toast.LENGTH_LONG
                            ).show()
                        }else if (selezione1 == selezione2 || selezione2 == selezione3 || selezione1 == selezione3){
                            Toast.makeText(
                                context,
                                "Le competenze musicali devono essere diverse tra di loro",
                                Toast.LENGTH_LONG
                            ).show()
                        }else if (selezione1 == "Scegli una competenza musicale" || selezione2 == "Scegli una competenza musicale" || selezione3 == "Scegli una competenza musicale"){
                            Toast.makeText(
                                context,
                                "Non hai selezionato tutte le competenze musicali",
                                Toast.LENGTH_LONG
                            ).show()
                        }else{
                            if (selezione1 != null && selezione2 != null && selezione3 != null) {
                                myList.add(selezione1)
                                myList.add(selezione2)
                                myList.add(selezione3)
                                if (list != null) myList.addAll(list)
                            }
                            if(razza == "Elfo alto" || razza == "Elfo dei boschi" || razza == "Elfo oscuro") myList.add("Percezione")
                            viewModelPersonaggio.setCompetenzePersonaggio(myList)
                            findNavController().navigate(R.id.action_competenzeFragment_to_backgroundFragment)
                        }
                    }else if (classe == "Monaco"){
                        if(myList.size != numCompetenze){
                            Toast.makeText(
                                context,
                                "Seleziona il numero richiesto di competenze!",
                                Toast.LENGTH_LONG
                            ).show()
                        }else if (selezioneMus == "Scegli una competenza musicale" && selezioneArt == "Scegli una competenza da artigiano"){
                            Toast.makeText(
                                context,
                                "Devi selezionare una competenza aggiuntiva",
                                Toast.LENGTH_LONG
                            ).show()
                        }else if (selezioneMus != "Scegli una competenza musicale" && selezioneArt != "Scegli una competenza da artigiano"){
                            Toast.makeText(
                                context,
                                "Devi selezionare solo una competenza. Rimetti (Scegli una competenza musicale) o (Scegli una competenza da artigiano) per andare avanti",
                                Toast.LENGTH_LONG
                            ).show()
                        }else {
                            if (selezioneMus != null && selezioneArt != null) {
                                if(selezioneMus != "Scegli una competenza musicale") {
                                    myList.add(selezioneMus)
                                    if (list != null) myList.addAll(list)
                                }
                                else {
                                    myList.add(selezioneArt)
                                    if (list != null) myList.addAll(list)
                                }
                            }
                            if(razza == "Elfo alto" || razza == "Elfo dei boschi" || razza == "Elfo oscuro") myList.add("Percezione")
                            viewModelPersonaggio.setCompetenzePersonaggio(myList)
                            findNavController().navigate(R.id.action_competenzeFragment_to_backgroundFragment)
                        }
                    }else if (myList.size == numCompetenze) {
                        if (list != null) myList.addAll(list)
                        if(razza == "Elfo alto" || razza == "Elfo dei boschi" || razza == "Elfo oscuro") myList.add("Percezione")
                        viewModelPersonaggio.setCompetenzePersonaggio(myList)
                        findNavController().navigate(R.id.action_competenzeFragment_to_backgroundFragment)
                    } else {
                        Toast.makeText(
                            context,
                            "Seleziona il numero richiesto di competenze!",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    // Prende il numero massimo di competenze selezionabili per la classe scelta
    private fun getNumCompetenzeByClasse(classe: String): Int {
        return when (classe) {
            "Barbaro" -> 2
            "Bardo" -> 3
            "Chierico" -> 2
            "Druido" -> 2
            "Guerriero" -> 2
            "Ladro" -> 4
            "Mago" -> 2
            "Monaco" -> 2
            "Paladino" -> 2
            "Ranger" -> 3
            "Stregone" -> 2
            "Warlock" -> 2
            else -> throw IllegalArgumentException("Classe sconosciuta!")
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

        // Rimuovi tutti gli elementi dalla lista myList
        myList.clear()

        // Ripristina le competenze originali nel ViewModel
        viewModelPersonaggio.setCompetenzePersonaggio(competenzeOriginali.toMutableList())
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
