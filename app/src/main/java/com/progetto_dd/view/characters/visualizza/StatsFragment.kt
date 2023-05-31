package com.progetto_dd.view.characters.visualizza

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentStatsBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel
import com.progetto_dd.view.characters.CharacterActivity

class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStatsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        val intent = requireActivity().intent

        val nome = intent.getStringExtra("nome")
        val razza = intent.getStringExtra("razza")
        val classe = intent.getStringExtra("classe")
        val vitaMax = intent.getStringExtra("vitaMax")
        val vita = intent.getStringExtra("vita")
        val stato = intent.getStringExtra("stato")
        val classeArmatura = intent.getStringExtra("classeArmatura")
        val campagna = intent.getStringExtra("campagna")
        val utenteId = intent.getStringExtra("utente_id")
        val livello = intent.getStringExtra("livello")

        val forza = intent.getStringExtra("forza")
        val destrezza = intent.getStringExtra("destrezza")
        val costituzione = intent.getStringExtra("costituzione")
        val intelligenza = intent.getStringExtra("intelligenza")
        val carisma = intent.getStringExtra("carisma")
        val saggezza = intent.getStringExtra("saggezza")

        val competenze = intent.getStringArrayListExtra("competenze")

        binding.nome.text = nome
        binding.razza.text = razza
        binding.classe.text = classe
        binding.saluteMassima.text = vitaMax
        binding.saluteAttuale.text = vita
        binding.stato.text = stato
        binding.classeArmatura.text = classeArmatura
        binding.livello.text = livello

        if (forza != null && destrezza != null && carisma != null && saggezza != null &&
                costituzione != null && intelligenza != null) {
            binding.modificatoreForza.text = forza + "(" + getModificatore(forza.toInt()) + ")"
            binding.modificatoreDestrezza.text = destrezza + "(" + getModificatore(destrezza.toInt()) + ")"
            binding.modificatoreCarisma.text = carisma + "(" + getModificatore(carisma.toInt()) + ")"
            binding.modificatoreSaggezza.text = saggezza + "(" + getModificatore(saggezza.toInt()) + ")"
            binding.modificatoreCostituzione.text = costituzione + "(" + getModificatore(costituzione.toInt()) + ")"
            binding.modificatoreIntelligenza.text = intelligenza + "(" + getModificatore(intelligenza.toInt()) + ")"
        }

        if (competenze != null) {
            binding.listaCompetenze.text = competenze.joinToString(separator = ", ")
        }

        if(livello != null){
            binding.bonusCompetenza.text = getBonusComp(livello)
        }

        if(classe != null){
            when(classe){
                "Bardo" -> binding.tiriSalvezza.text = "Destrezza, Carisma"
                "Ladro" -> binding.tiriSalvezza.text = "Destrezza, Intelligenza"
                "Guerriero" -> binding.tiriSalvezza.text = "Forza, Costituzione"
                "Mago" -> binding.tiriSalvezza.text = "Intelligenza, Saggezza"
            }
        }
        
        if(classe != null && livello != null){
            when(classe){
                "Bardo" -> if (carisma != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Ladro" -> if (intelligenza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(intelligenza.toInt())).toString()
                }
                "Guerriero" -> if (intelligenza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(intelligenza.toInt())).toString()
                }
                "Mago" -> if (intelligenza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(intelligenza.toInt())).toString()
                }
            }
        }

        if(classe != null && livello != null){
            when(classe){
                "Bardo" -> if (carisma != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Ladro" -> if (intelligenza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(intelligenza.toInt())).toString()
                }
                "Guerriero" -> if (intelligenza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(intelligenza.toInt())).toString()
                }
                "Mago" -> if (intelligenza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(intelligenza.toInt())).toString()
                }
            }
        }

        binding.btnModifica.setOnClickListener {
            findNavController().navigate(R.id.action_statsFragment_to_modificaStatsFragment)
        }

        binding.btnElimina.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
                .setTitle("Conferma eliminazione")
                .setMessage("Sei sicuro di voler eliminare il personaggio?")
                .setPositiveButton("Elimina") { dialog, _ ->
                    if (campagna == "") {
                        if (nome != null && razza!= null && classe != null && utenteId != null) {
                            viewModel.deletePersonaggio(nome, razza, classe, utenteId, campagna)
                                .observe(viewLifecycleOwner) { isDeleted ->
                                    if (isDeleted) {
                                        Toast.makeText(
                                            requireContext(),
                                            "Personaggio eliminato con successo",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        // Aggiungi qui altre azioni da eseguire dopo l'eliminazione
                                        val intentEnd = Intent(requireContext(), CharacterActivity::class.java)
                                        startActivity(intentEnd)
                                    } else {
                                        Toast.makeText(
                                            requireContext(),
                                            "Errore durante l'eliminazione del personaggio",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }
                        }
                    } else {
                        Toast.makeText(
                            requireContext(),
                            "Impossibile eliminare il personaggio perché è in una campagna",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    dialog.dismiss()
                }
                .setNegativeButton("Annulla") { dialog, _ ->
                    dialog.dismiss()
                }
                .create()

            alertDialog.show()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getModificatore(n: Int): Int {
        var m = 0
        when(n){
            3 -> m = -4
            4 -> m = -3
            5 -> m = -3
            6 -> m = -2
            7 -> m = -2
            8 -> m = -1
            9 -> m = -1
            10 -> m = 0
            11 -> m = 0
            12 -> m = 1
            13 -> m = 1
            14 -> m = 2
            15 -> m = 2
            16 -> m = 3
            17 -> m = 3
            18 -> m = 4
            19 -> m = 4
            20 -> m= 5
            21 -> m = 5
            22 -> m = 6
        }
        return  m
    }

    fun getBonusComp(livello: String): String{
        var m = "0"
        when(livello.toInt()){
            1 -> m = "2"
            2 -> m = "2"
            3 -> m = "2"
            4 -> m = "2"
            5 -> m = "3"
            6 -> m = "3"
            7 -> m = "3"
            8 -> m = "3"
            9 -> m = "4"
            10 -> m = "4"
            11 -> m = "4"
            12 -> m = "4"
            13 -> m = "5"
            14 -> m = "5"
            15 -> m = "5"
            16 -> m = "5"
            17 -> m = "6"
            18 -> m = "6"
            19 -> m = "6"
            20 -> m = "6"
        }
        return m
    }
    
    fun getCD(bonusComp: Int, bonusCaster: Int): Int{
        return (8+bonusComp+bonusCaster)
    }

    fun getBonusAttacco(bonusComp: Int, bonusCaster: Int): Int{
        return (bonusComp+bonusCaster)
    }
}
