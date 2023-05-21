package com.progetto_dd.view.characters

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

        spinner1 = binding.spinnerScelta1
        val arrayList1Bardo = resources.getStringArray(R.array.scelta_bardo_1)
        val arrayList1Guerriero = resources.getStringArray(R.array.scelta_guerriero_1)
        val arrayList1Ladro = resources.getStringArray(R.array.scelta_ladro_1)
        val arrayList1Mago = resources.getStringArray(R.array.scelta_mago_1)
        
        spinner2 = binding.spinnerScelta2
        val arrayList2Bardo = resources.getStringArray(R.array.scelta_bardo_2)
        val arrayList2Guerriero = resources.getStringArray(R.array.scelta_guerriero_2)
        val arrayList2Ladro = resources.getStringArray(R.array.scelta_ladro_2)
        val arrayList2Mago = resources.getStringArray(R.array.scelta_mago_2)

        spinner3 = binding.spinnerScelta3
        val arrayList3Bardo = resources.getStringArray(R.array.scelta_bardo_3)
        val arrayList3Guerriero = resources.getStringArray(R.array.scelta_guerriero_3)
        val arrayList3Ladro = resources.getStringArray(R.array.scelta_ladro_3)
        val arrayList3Mago = resources.getStringArray(R.array.scelta_mago_3)

        spinner4 = binding.spinnerScelta4
        val arrayList4Bardo = resources.getStringArray(R.array.scelta_bardo_4)
        val arrayList4Guerriero = resources.getStringArray(R.array.scelta_guerriero_4)
        val arrayList4Ladro = resources.getStringArray(R.array.scelta_ladro_4)
        val arrayList4Mago = resources.getStringArray(R.array.scelta_mago_4)
        
        spinnerG = binding.spinnerSceltaGuerriero
        val arrayList21Guerriero = resources.getStringArray(R.array.scelta_guerriero_G)

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
        }

        binding.btnAvanti.setOnClickListener {
            val selezione1 = binding.spinnerScelta1.selectedItem as String
            val selezione2 = binding.spinnerScelta2.selectedItem as String
            val selezione3 = binding.spinnerScelta3.selectedItem as String
            val selezione4 = binding.spinnerScelta4.selectedItem as String
            val selezioneG = binding.spinnerSceltaGuerriero.selectedItem as? String

            if(classe == "Guerriero" && selezioneG == "-")
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
                                    selezione3, "1 Zaino","1 Piede di porco","1 Martello","10 chiodi da rocciatore",
                                    "1 acciarino", "1 pietra focaia", "10 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2,selezioneG,
                                    selezione3, "1 Zaino", "1 acciarino", "1 pietra focaia", "10 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa", "1 giaciglio", "1 gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Bardo"){
                        when(selezione4){
                            "Una dotazione da diplomatico" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                "1 forziere", "2 custodie per mappe e pergamene", "1 abito pregiato",
                                "1 boccietta di inchiostro", "1 pennino","1 lampada", "2 ampolle di olio",
                                "5 fogli di carta", "1 fiala di profumo", "1 cera per sigillo",
                                "1 sapone")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "1 Zaino", "1 acciarino", "1 pietra focaia", "10 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa", "1 giaciglio", "1 gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Ladro"){
                        when(selezione4){
                            "Una dotazione da avventuriero" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "1 Zaino","1 Piede di porco","1 Martello","10 chiodi da rocciatore",
                                    "1 acciarino", "1 pietra focaia", "10 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "1 Zaino", "1 acciarino", "1 pietra focaia", "10 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa", "1 giaciglio", "1 gavetta")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da scassinatore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "1 Zaino","1 Piede di porco","1 Martello","10 chiodi da rocciatore",
                                    "1 acciarino", "1 pietra focaia", "5 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa","1 sacchetto con 1000 sfere metalliche",
                                    "3mt di spago", "1 campanella", "5 candele", "1 lanterna schermabile",
                                    "2 ampolle di olio")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                        }
                    }
                    if(classe == "Mago"){
                        when(selezione4){
                            "Una dotazione da studioso" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "1 zaino", "1 libro di studio", "1 boccetta di inchiostro",
                                    "1 pennino","10 fogli di pergamena", "1 sacchetto di sabbia",
                                    "1 coltellino")
                                viewModel.setEquipaggiamento(nuovoEquipaggiamento)
                            }
                            "Una dotazione da esploratore" -> {
                                val nuovoEquipaggiamento = listOf(selezione1,selezione2, selezione3,
                                    "1 Zaino", "1 acciarino", "1 pietra focaia", "10 razioni giornaliere",
                                    "1 otre", "15mt di corda di canapa", "1 giaciglio", "1 gavetta")
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