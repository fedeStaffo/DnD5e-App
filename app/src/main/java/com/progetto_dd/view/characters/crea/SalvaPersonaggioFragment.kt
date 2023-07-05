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
    private val myListCompetenze: MutableList<String> = mutableListOf()
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
        val classe = viewModel.classePersonaggio.value

        // Salva il personaggio
        binding.btnSalva.setOnClickListener {

            if (razza != null && classe != null) {
                getManuale(razza, classe)
            }
            val listLinguaggi = viewModel.linguaggiPersonaggio.value
            if (listLinguaggi != null) myListLinguaggi.addAll(listLinguaggi)
            viewModel.setLinguaggiPersonaggio(myListLinguaggi)

            val listCompetenze = viewModel.competenzePersonaggio.value
            if(listCompetenze != null) myListCompetenze.addAll(listCompetenze)
            viewModel.setCompetenzePersonaggio(myListCompetenze)

            viewModel.saveCharacterToFirestore()

            // Restarta l'activity personaggio
            val intent = Intent(activity, CharacterActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    
    private fun getManuale(razza: String, classe: String){
        when (razza) {
            "Umano" -> {
                myListLinguaggi.add("Comune")
            }
            "Elfo alto", "Elfo dei boschi" -> {
                myListLinguaggi.add("Comune")
                myListLinguaggi.add("Elfico")
                myListCompetenze.add("Spade corte")
                myListCompetenze.add("Spade lunghe")
                myListCompetenze.add("Archi corti")
                myListCompetenze.add("Archi lunghi")
            }
            "Elfo oscuro" ->{
                myListLinguaggi.add("Comune")
                myListLinguaggi.add("Elfico")
                myListCompetenze.add("Spade corte")
                myListCompetenze.add("Stocchi")
                myListCompetenze.add("Balestre a mano")
            }
            "Nano delle colline" -> {
                myListLinguaggi.add("Comune")
                myListLinguaggi.add("Nanico")
                myListCompetenze.add("Asce")
                myListCompetenze.add("Asce da battaglia")
                myListCompetenze.add("Martelli da guerra")
                myListCompetenze.add("Martelli leggeri")
            }
            "Nano delle montagne" -> {
                myListLinguaggi.add("Comune")
                myListLinguaggi.add("Nanico")
                myListCompetenze.add("Asce")
                myListCompetenze.add("Asce da battaglia")
                myListCompetenze.add("Martelli da guerra")
                myListCompetenze.add("Martelli leggeri")
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armature medie")
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
        when(classe){
            "Barbaro" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armature medie")
                myListCompetenze.add("Scudi")
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Armi da guerra")
            }
            "Bardo" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Balestre a mano")
                myListCompetenze.add("Spade corte")
                myListCompetenze.add("Spade lunghe")
                myListCompetenze.add("Stocchi")
            }
            "Chierico" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armature medie")
                myListCompetenze.add("Scudi")
                myListCompetenze.add("Armi semplici")
            }
            "Druido" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armature medie")
                myListCompetenze.add("Scudi")
                myListCompetenze.add("Bastoni ferrati")
                myListCompetenze.add("Dardi")
                myListCompetenze.add("Falcetti")
                myListCompetenze.add("Fionde")
                myListCompetenze.add("Giavellotti")
                myListCompetenze.add("Lance")
                myListCompetenze.add("Mazze")
                myListCompetenze.add("Pugnali")
                myListCompetenze.add("Randelli")
                myListCompetenze.add("Scimitarre")
                myListCompetenze.add("Strumenti da erborista")
            }
            "Guerriero" -> {
                myListCompetenze.add("Tutte le armature")
                myListCompetenze.add("Scudi")
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Armi da guerra")
            }
            "Ladro" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Balestre a mano")
                myListCompetenze.add("Spade corte")
                myListCompetenze.add("Spade lunghe")
                myListCompetenze.add("Stocchi")
                myListCompetenze.add("Arnesi da scasso")
            }
            "Mago" -> {
                myListCompetenze.add("Balestre leggere")
                myListCompetenze.add("Bastoni ferrati")
                myListCompetenze.add("Dardi")
                myListCompetenze.add("Fionde")
                myListCompetenze.add("Pugnali")
            }
            "Monaco" -> {
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Spade corte")
            }
            "Paladino" -> {
                myListCompetenze.add("Tutte le armature")
                myListCompetenze.add("Scudi")
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Armi da guerra")
            }
            "Ranger" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armature medie")
                myListCompetenze.add("Scudi")
                myListCompetenze.add("Armi semplici")
                myListCompetenze.add("Armi da guerra")
            }
            "Stregone" -> {
                myListCompetenze.add("Balestre leggere")
                myListCompetenze.add("Bastoni ferrati")
                myListCompetenze.add("Dardi")
                myListCompetenze.add("Fionde")
                myListCompetenze.add("Pugnali")
            }
            "Warlock" -> {
                myListCompetenze.add("Armature leggere")
                myListCompetenze.add("Armi semplici")
            }
        }
    }
}