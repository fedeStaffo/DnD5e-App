package com.progetto_dd.view.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentNameCharacterBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class NameCharacterFragment : Fragment() {
    private lateinit var binding: FragmentNameCharacterBinding
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla il layout della schermata del nome del personaggio
        binding = FragmentNameCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Aggiunge un listener al bottone "Avanti" per controllare se è stato inserito un nome
        binding.btnAvantiCreaPers.setOnClickListener {
            val nome = binding.nameEt.text.toString().trim()
            if (nome.isNotEmpty()) {
                // Salva il nome inserito nel view model e passa alla schermata della razza del personaggio
                viewModel.setNomePersonaggio(nome)
                findNavController().navigate(R.id.action_nameCharacterFragment_to_raceFragment)
            } else {
                // Mostra un messaggio di errore se non è stato inserito un nome
                Toast.makeText(requireContext(), "Inserisci un nome per il personaggio!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
