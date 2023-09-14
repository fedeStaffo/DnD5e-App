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
import com.progetto_dd.databinding.FragmentCaratteristicaUmanoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class CaratteristicaUmanoFragment : Fragment() {

    private var _binding: FragmentCaratteristicaUmanoBinding? = null
    private val binding get() = _binding!!
    private val myList: MutableList<String> = mutableListOf()
    private lateinit var viewModelPersonaggio: PersonaggioViewModel

    // Variabile temporanea per salvare le lingue originali
    private var lingueOriginali: List<String> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCaratteristicaUmanoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModelPersonaggio = ViewModelProvider(requireActivity())[PersonaggioViewModel::class.java]

        onResume()

        // Salva le lingue originali quando si crea la vista
        lingueOriginali = viewModelPersonaggio.linguaggiPersonaggio.value ?: emptyList()

        binding.btnAvanti.setOnClickListener {
            val scelta = binding.spinnerLingua.selectedItem as String

            if (scelta != "Scegli una lingua"){
                myList.add(scelta)
                viewModelPersonaggio.setLinguaggiPersonaggio(myList)
                findNavController().navigate(R.id.action_caratteristicaUmanoFragment_to_classFragment)
            } else {
                Toast.makeText(activity, "Devi scegliere un linguaggio", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()

        // ...

        // Ripristina le lingue originali nel ViewModel
        viewModelPersonaggio.setLinguaggiPersonaggio(lingueOriginali.toMutableList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}