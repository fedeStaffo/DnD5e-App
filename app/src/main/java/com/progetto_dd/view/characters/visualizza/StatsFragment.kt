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

        // Ottieni i dati passati dall'activity
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

        // Imposta i dati nei componenti dell'UI
        binding.nome.text = nome
        binding.razza.text = razza
        binding.classe.text = classe
        binding.saluteMassima.text = vitaMax
        binding.saluteAttuale.text = vita
        binding.stato.text = stato
        binding.classeArmatura.text = classeArmatura
        binding.livello.text = livello

        // Calcola e visualizza i modificatori per gli attributi
        if (forza != null && destrezza != null && carisma != null && saggezza != null &&
            costituzione != null && intelligenza != null) {
            binding.modificatoreForza.text = forza + "(" + getModificatore(forza.toInt()) + ")"
            binding.modificatoreDestrezza.text = destrezza + "(" + getModificatore(destrezza.toInt()) + ")"
            binding.modificatoreCarisma.text = carisma + "(" + getModificatore(carisma.toInt()) + ")"
            binding.modificatoreSaggezza.text = saggezza + "(" + getModificatore(saggezza.toInt()) + ")"
            binding.modificatoreCostituzione.text = costituzione + "(" + getModificatore(costituzione.toInt()) + ")"
            binding.modificatoreIntelligenza.text = intelligenza + "(" + getModificatore(intelligenza.toInt()) + ")"
        }

        // Visualizza la lista di competenze
        if (competenze != null) {
            binding.listaCompetenze.text = competenze.joinToString(separator = ",\n")
        }

        // Calcola e visualizza il bonus di competenza
        if(livello != null){
            binding.bonusCompetenza.text = getBonusComp(livello)
        }

        // Imposta i tiri salvezza in base alla classe
        if(classe != null){
            when(classe){
                "Bardo" -> binding.tiriSalvezza.text = "Destrezza, Carisma"
                "Ladro" -> binding.tiriSalvezza.text = "Destrezza, Intelligenza"
                "Guerriero" -> binding.tiriSalvezza.text = "Forza, Costituzione"
                "Mago" -> binding.tiriSalvezza.text = "Intelligenza, Saggezza"
                "Barbaro" -> binding.tiriSalvezza.text = "Forza, Costituzione"
                "Chierico" -> binding.tiriSalvezza.text = "Saggezza, Carisma"
                "Druido" -> binding.tiriSalvezza.text = "Intelligenza, Saggezza"
                "Monaco" -> binding.tiriSalvezza.text = "Forza, Destrezza"
                "Paladino" -> binding.tiriSalvezza.text = "Saggezza, Carisma"
                "Ranger" -> binding.tiriSalvezza.text = "Forza, Destrezza"
                "Stregone" -> binding.tiriSalvezza.text = "Costituzione, Carisma"
                "Warlock" -> binding.tiriSalvezza.text = "Saggezza, Carisma"
            }
        }

        // Calcola e visualizza la classe di difficoltà dei tiri salvezza magici
        if(classe != null && livello != null){
            when(classe){
                "Bardo" -> if (carisma != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Warlock" -> if (carisma != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Stregone" -> if (carisma != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Barbaro" -> if (saggezza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Chierico" -> if (saggezza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Ranger" -> if (saggezza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Druido" -> if (saggezza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
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
                "Monaco" -> if (saggezza != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Paladino" -> if (carisma != null) {
                    binding.cdTiroSalvezzaMagia.text =
                        getCD(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
            }
        }

        // Calcola e visualizza il bonus di attacco/incantesimo
        if(classe != null && livello != null){
            when(classe){
                "Bardo" -> if (carisma != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Warlock" -> if (carisma != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Stregone" -> if (carisma != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Paladino" -> if (carisma != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(carisma.toInt())).toString()
                }
                "Barbaro" -> if (saggezza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Chierico" -> if (saggezza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Ranger" -> if (saggezza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
                "Druido" -> if (saggezza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
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
                "Monaco" -> if (saggezza != null) {
                    binding.bonusAttaccoIncantesimo.text =
                        getBonusAttacco(getBonusComp(livello).toInt(),getModificatore(saggezza.toInt())).toString()
                }
            }
        }

        // Naviga alla schermata di modifica delle statistiche
        binding.btnModifica.setOnClickListener {
            findNavController().navigate(R.id.action_statsFragment_to_modificaStatsFragment)
        }

        // Conferma l'eliminazione del personaggio
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

    // Calcola il modificatore di un attributo
    private fun getModificatore(n: Int): Int {
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
            20 -> m = 5
            21 -> m = 5
            22 -> m = 6
        }
        return  m
    }

    // Calcola il bonus di competenza in base al livello
    private fun getBonusComp(livello: String): String{
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

    // Calcola la classe di difficoltà dei tiri salvezza magici
    private fun getCD(bonusComp: Int, modificatore: Int): Int{
        return 8 + bonusComp + modificatore
    }

    // Calcola il bonus di attacco/incantesimo
    private fun getBonusAttacco(bonusComp: Int, modificatore: Int): Int{
        return bonusComp + modificatore
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
