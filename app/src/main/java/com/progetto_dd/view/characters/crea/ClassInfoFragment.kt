package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        // Chiama la funzione getInfoClasse del viewmodel per ottenere le informazioni sulla classe
        if (classe != null) {
            viewModel.getInfoClasse(classe).observe(viewLifecycleOwner, Observer { infoClasse ->
                // Aggiorna la TextView con le informazioni sulla razza
                binding.classInfoText.text = infoClasse.orEmpty()
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}