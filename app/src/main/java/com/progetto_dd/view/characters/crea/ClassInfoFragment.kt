package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentClassInfoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class ClassInfoFragment : Fragment() {

    private var _binding: FragmentClassInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClassInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il viewmodel
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Inizializza la classe selezionata dall'utente dal viewmodel
        val classe = viewModel.classePersonaggio.value

        if (classe != null) {
            when(classe){
                "Bardo"-> binding.classInfoText.text = getString(R.string.Bardo_info)
                "Guerriero"-> binding.classInfoText.text = getString(R.string.Guerriero_info)
                "Ladro"-> binding.classInfoText.text = getString(R.string.Ladro_info)
                "Mago"-> binding.classInfoText.text = getString(R.string.Mago_info)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}