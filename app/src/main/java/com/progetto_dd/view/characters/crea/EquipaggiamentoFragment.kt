package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentEquipaggiamentoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class EquipaggiamentoFragment : Fragment() {

    private var _binding: FragmentEquipaggiamentoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    private lateinit var spinner1: Spinner
    private lateinit var spinner2: Spinner
    private lateinit var spinnerG: Spinner
    private lateinit var spinner3: Spinner
    private lateinit var spinner4: Spinner


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEquipaggiamentoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val scelta = binding.scelta3

        spinner1 = binding.spinnerScelta1
        val arrayList1Bardo = resources.getStringArray(R.array.scelta_bardo_1)
        val arrayList1Guerriero = resources.getStringArray(R.array.scelta_guerriero_1)
        val arrayList1Ladro = resources.getStringArray(R.array.scelta_ladro_1)
        val arrayList1Mago = resources.getStringArray(R.array.scelta_mago_1)
        val arrayList1Barbaro = resources.getStringArray(R.array.scelta_barbaro_1)
        val arrayList1Chierico = resources.getStringArray(R.array.scelta_chierico_1)
        val arrayList1Druido = resources.getStringArray(R.array.scelta_druido_1)
        val arrayList1Monaco = resources.getStringArray(R.array.scelta_monaco_1)
        val arrayList1Paladino = resources.getStringArray(R.array.scelta_paladino_1)
        val arrayList1Ranger = resources.getStringArray(R.array.scelta_ranger_1)
        val arrayList1Stregone = resources.getStringArray(R.array.scelta_stregone_1)
        val arrayList1Warlock = resources.getStringArray(R.array.scelta_warlock_1)

        spinner2 = binding.spinnerScelta2
        val arrayList2Bardo = resources.getStringArray(R.array.scelta_bardo_2)
        val arrayList2Guerriero = resources.getStringArray(R.array.scelta_guerriero_2)
        val arrayList2Ladro = resources.getStringArray(R.array.scelta_ladro_2)
        val arrayList2Mago = resources.getStringArray(R.array.scelta_mago_2)
        val arrayList2Barbaro = resources.getStringArray(R.array.scelta_barbaro_2)
        val arrayList2Chierico = resources.getStringArray(R.array.scelta_chierico_2)
        val arrayList2Druido = resources.getStringArray(R.array.scelta_druido_2)
        val arrayList2Monaco = resources.getStringArray(R.array.scelta_monaco_2)
        val arrayList2Paladino = resources.getStringArray(R.array.scelta_paladino_2)
        val arrayList2Ranger = resources.getStringArray(R.array.scelta_ranger_2)
        val arrayList2Stregone = resources.getStringArray(R.array.scelta_stregone_2)
        val arrayList2Warlock = resources.getStringArray(R.array.scelta_warlock_2)

        spinner3 = binding.spinnerScelta3
        val arrayList3Bardo = resources.getStringArray(R.array.scelta_bardo_3)
        val arrayList3Guerriero = resources.getStringArray(R.array.scelta_guerriero_3)
        val arrayList3Ladro = resources.getStringArray(R.array.scelta_ladro_3)
        val arrayList3Mago = resources.getStringArray(R.array.scelta_mago_3)
        val arrayList3Barbaro = resources.getStringArray(R.array.scelta_barbaro_3)
        val arrayList3Chierico = resources.getStringArray(R.array.scelta_chierico_3)
        val arrayList3Druido = resources.getStringArray(R.array.scelta_druido_3)
        val arrayList3Monaco = resources.getStringArray(R.array.scelta_monaco_3)
        val arrayList3Paladino = resources.getStringArray(R.array.scelta_paladino_3)
        val arrayList3Ranger = resources.getStringArray(R.array.scelta_ranger_3)
        val arrayList3Stregone = resources.getStringArray(R.array.scelta_stregone_3)
        val arrayList3Warlock = resources.getStringArray(R.array.scelta_warlock_3)

        spinner4 = binding.spinnerScelta4
        val arrayList4Bardo = resources.getStringArray(R.array.scelta_bardo_4)
        val arrayList4Guerriero = resources.getStringArray(R.array.scelta_guerriero_4)
        val arrayList4Ladro = resources.getStringArray(R.array.scelta_ladro_4)
        val arrayList4Mago = resources.getStringArray(R.array.scelta_mago_4)
        val arrayList4Barbaro = resources.getStringArray(R.array.scelta_barbaro_4)
        val arrayList4Chierico = resources.getStringArray(R.array.scelta_chierico_4)
        val arrayList4Druido = resources.getStringArray(R.array.scelta_druido_4)
        val arrayList4Monaco = resources.getStringArray(R.array.scelta_monaco_4)
        val arrayList4Paladino = resources.getStringArray(R.array.scelta_paladino_4)
        val arrayList4Ranger = resources.getStringArray(R.array.scelta_ranger_4)
        val arrayList4Stregone = resources.getStringArray(R.array.scelta_stregone_4)
        val arrayList4Warlock = resources.getStringArray(R.array.scelta_warlock_4)

        spinnerG = binding.spinnerSceltaExtra
        val arrayList21Guerriero = resources.getStringArray(R.array.scelta_guerriero_G)
        val arrayList21Paladino = resources.getStringArray(R.array.scelta_paladino_G)
        val arrayList21Ranger = resources.getStringArray(R.array.scelta_ranger_G)

        val classe = viewModel.classePersonaggio.value.toString()

        when(classe){
            "Bardo"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Bardo)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Bardo)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Bardo)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Bardo)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Barbaro"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Barbaro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Barbaro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Barbaro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Barbaro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Chierico"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Chierico)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Chierico)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Chierico)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Chierico)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Druido"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Druido)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Druido)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Druido)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Druido)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Stregone"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Stregone)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Stregone)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Stregone)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Stregone)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Warlock"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Warlock)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Warlock)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Warlock)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Warlock)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Guerriero"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Guerriero)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Guerriero)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Guerriero)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Guerriero)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList21Guerriero)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerG.adapter = adapter
                spinnerG.visibility = View.VISIBLE
            }
            "Paladino"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Paladino)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Paladino)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Paladino)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Paladino)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList21Paladino)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerG.adapter = adapter
                spinnerG.visibility = View.VISIBLE
            }
            "Ranger"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Ranger)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Ranger)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Ranger)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Ranger)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList21Ranger)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinnerG.adapter = adapter
                spinnerG.visibility = View.VISIBLE
            }
            "Ladro"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Ladro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Ladro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Ladro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Ladro)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Mago"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Mago)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Mago)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList3Mago)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner3.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Mago)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
            "Monaco"-> {
                var adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList1Monaco)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner1.adapter = adapter

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList2Monaco)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner2.adapter = adapter

                spinner3.visibility = View.GONE
                scelta.visibility = View.GONE

                adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, arrayList4Monaco)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                spinner4.adapter = adapter
            }
        }

        binding.btnAvanti.setOnClickListener {
            val selezione1 = binding.spinnerScelta1.selectedItem as String
            val selezione2 = binding.spinnerScelta2.selectedItem as String
            val selezione3 = binding.spinnerScelta3.selectedItem as? String
            val selezione4 = binding.spinnerScelta4.selectedItem as String
            val selezioneG = binding.spinnerSceltaExtra.selectedItem as? String

            if(classe == "Guerriero" && selezioneG == "-")
                Toast.makeText(activity, "Non lasciare campi vuoti", Toast.LENGTH_SHORT).show()
            else if(classe == "Paladino" && selezioneG == "-")
                Toast.makeText(activity, "Non lasciare campi vuoti", Toast.LENGTH_SHORT).show()
            else if(classe == "Ranger" && selezioneG == "-")
                Toast.makeText(activity, "Non lasciare campi vuoti", Toast.LENGTH_SHORT).show()
            else {
                if(selezione1 == "-" || selezione2 == "-" || selezione3 == "-" || selezione4 == "-")
                    Toast.makeText(activity, "Non lasciare campi vuoti", Toast.LENGTH_SHORT).show()
                else
                {
                    if(classe == "Guerriero"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,selezioneG,
                                    selezione3, "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,selezioneG,
                                    selezione3, "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Paladino"){
                        when(selezione4){
                            "Una dotazione da sacerdote" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3, selezioneG,
                                    "zaino", "coperta", "10 candele","acciarino", "pietra focaia","cassetta per le offerte",
                                    "2 cubetti di incenso", "incensiere", "veste", "2 razioni giornaliere", "otre", "Simbolo Sacro")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,selezione3,selezioneG,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta", "Simbolo sacro")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Ranger"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,selezioneG,
                                    selezione3, "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,selezioneG,
                                    selezione3, "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Bardo"){
                        when(selezione4){
                            "Una dotazione da diplomatico" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "forziere", "2 custodie per mappe e pergamene", "abito pregiato",
                                    "boccietta di inchiostro", "pennino","lampada", "2 ampolle di olio",
                                    "5 fogli di carta", "fiala di profumo", "cera per sigillo",
                                    "sapone")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Barbaro"){
                        when(selezione4){
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Chierico"){
                        when(selezione4){
                            "Una dotazione da sacerdote" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "coperta", "10 candele","acciarino", "pietra focaia","cassetta per le offerte",
                                    "2 cubetti di incenso", "incensiere", "veste", "2 razioni giornaliere", "otre", "Scudo", "Simbolo sacro")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta", "Scudo", "Simbolo sacro")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Druido"){
                        when(selezione4){
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta", "Focus druidico")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Monaco"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,
                                    "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Stregone"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Warlock"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "Armatura di cuoio", "2 pugnali")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da studioso" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "libro di studio", "boccetta di inchiostro",
                                    "pennino","10 fogli di pergamena", "sacchetto di sabbia",
                                    "coltellino", "Armatura di cuoio", "2 pugnali")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Ladro"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da scassinatore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino","piede di porco","martello","10 chiodi da rocciatore",
                                    "acciarino", "pietra focaia", "5 razioni giornaliere",
                                    "otre", "15mt di corda di canapa","sacchetto con 1000 sfere metalliche",
                                    "3mt di spago", "campanella", "5 candele", "lanterna schermabile",
                                    "2 ampolle di olio")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Mago"){
                        when(selezione4){
                            "Una dotazione da studioso" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "libro di studio", "boccetta di inchiostro",
                                    "pennino","10 fogli di pergamena", "sacchetto di sabbia",
                                    "coltellino")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "zaino", "acciarino", "pietra focaia", "10 razioni giornaliere",
                                    "otre", "15mt di corda di canapa", "giaciglio", "gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    findNavController().navigate(R.id.action_equipaggiamentoFragment_to_salvaPersonaggioFragment)
                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}