package com.progetto_dd.view.characters.crea

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentSalvaPersonaggioBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.view.characters.CharacterActivity


class SalvaPersonaggioFragment : Fragment() {

    private var _binding: FragmentSalvaPersonaggioBinding? = null
    private val binding get() = _binding!!
    private val myListLinguaggi: MutableList<String> = mutableListOf()
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSalvaPersonaggioBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model del Personaggio
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val razza = viewModel.razzaPersonaggio.value

        if (razza != null) {
            when (razza) {
                "Umano" -> {
                    myListLinguaggi.add("Comune")
                }
                "Elfo alto", "Elfo dei boschi", "Elfo oscuro" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Elfico")
                }
                "Nano delle colline", "Nano delle montagne" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Nanico")
                }
                "Halfling piedelesto", "Halfling tozzo" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Halfling")
                }
                "Gnomo delle rocce", "Gnomo delle foreste" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Gnomesco")
                }
                "Mezzorco" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Orchesco")
                }
                "Tiefling" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Infernale")
                }
                "Mezzelfo" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Elfico")
                }
                "Dragonide d'argento", "Dragonide bianco", "Dragonide blu", "Dragonide di bronzo", "Dragonide nero", "Dragonide d'oro", "Dragonide d'ottone", "Dragonide di rame", "Dragonide rosso", "Dragonide verde" -> {
                    myListLinguaggi.add("Comune")
                    myListLinguaggi.add("Draconico")
                }
            }

            // Salva il personaggio
            binding.btnSalva.setOnClickListener {

                val listLinguaggi = viewModel.linguaggiPersonaggio.value
                if (listLinguaggi != null) myListLinguaggi.addAll(listLinguaggi)
                viewModel.setLinguaggiPersonaggio(myListLinguaggi)

                viewModel.saveCharacterToFirestore()

                // Restarta l'activity personaggio
                val intent = Intent(activity, CharacterActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}