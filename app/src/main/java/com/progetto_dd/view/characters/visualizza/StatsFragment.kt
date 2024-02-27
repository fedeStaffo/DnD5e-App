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
        val linguaggi = intent.getStringArrayListExtra("linguaggi")
        val maestrie = intent.getStringArrayListExtra("maestrie")
        val competenzeEscluse = setOf("Atletica", "Acrobazia", "Rapidità di mano", "Furtività", "Arcano", "Indagare", "Natura", "Religione", "Storia",
                                      "Addestrare Animali", "Intuizione", "Medicina", "Percezione", "Sopravvivenza", "Intimidire", "Inganno", "Intrattenere", "Persuasione")
        val competenzeMostrate = competenze?.filter { !competenzeEscluse.contains(it) } ?: emptyList()

        // Imposta i dati nei componenti dell'UI
        binding.nome.text = nome
        binding.razza.text = razza
        binding.classe.text = classe
        binding.puntiFerita.text = vita
        binding.classeArmatura.text = classeArmatura
        binding.livello.text = livello

        // Calcola e visualizza i modificatori per gli attributi
        if (forza != null && destrezza != null && carisma != null && saggezza != null &&
            costituzione != null && intelligenza != null
        ) {
            binding.statForza.text = forza
            binding.statDestrezza.text = destrezza
            binding.statCostituzione.text = costituzione
            binding.statIntelligenza.text = intelligenza
            binding.statSaggezza.text = saggezza
            binding.statCarisma.text = carisma
            binding.modificatoreForza.text = getModificatore(forza.toInt()).toString()
            binding.modificatoreDestrezza.text = getModificatore(destrezza.toInt()).toString()
            binding.modificatoreCarisma.text = getModificatore(carisma.toInt()).toString()
            binding.modificatoreSaggezza.text = getModificatore(saggezza.toInt()).toString()
            binding.modificatoreCostituzione.text = getModificatore(costituzione.toInt()).toString()
            binding.modificatoreIntelligenza.text = getModificatore(intelligenza.toInt()).toString()
        }

        // Visualizza la lista di competenze
        /*if (competenze != null) {
            binding.listaCompetenze.text = competenze.joinToString(separator = ",\n")
        }*/

        // Calcola e visualizza il bonus di competenza
        if (livello != null) {
            binding.bonusCompetenza.text = getBonusComp(livello)
        }

        competenze?.let {competenzeList ->
            if (competenzeList.contains("Atletica")) { binding.CAtleticafalse.visibility = View.INVISIBLE
            } else { binding.CAtleticatrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Acrobazia")) { binding.CAcrobaziafalse.visibility = View.INVISIBLE
            } else { binding.CAcrobaziatrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Rapidità di mano")) { binding.CRapiditfalse.visibility = View.INVISIBLE
            } else { binding.CRapidittrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Furtività")) { binding.CFurtivitfalse.visibility = View.INVISIBLE
            } else { binding.CFurtivittrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Arcano")) { binding.CArcanofalse.visibility = View.INVISIBLE
            } else { binding.CArcanotrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Indagare")) { binding.CIndagarefalse.visibility = View.INVISIBLE
            } else { binding.CIndagaretrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Natura")) { binding.CNaturafalse.visibility = View.INVISIBLE
            } else { binding.CNaturatrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Religione")) { binding.CReligionefalse.visibility = View.INVISIBLE
            } else { binding.CReligionetrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Storia")) { binding.CStoriafalse.visibility = View.INVISIBLE
            } else { binding.CStoriatrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Addestrare Animali")) { binding.CAddestrarefalse.visibility = View.INVISIBLE
            } else { binding.CAddestraretrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Intuizione")) { binding.CIntuizionefalse.visibility = View.INVISIBLE
            } else { binding.CIntuizionetrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Medicina")) { binding.CMedicinafalse.visibility = View.INVISIBLE
            } else { binding.CMedicinatrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Percezione")) { binding.CPercepirefalse.visibility = View.INVISIBLE
            } else { binding.CPercepiretrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Sopravvivenza")) { binding.CSopravvivenzafalse.visibility = View.INVISIBLE
            } else { binding.CSopravvivenzatrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Intimidire")) { binding.CIntimidirefalse.visibility = View.INVISIBLE
            } else { binding.CIntimidiretrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Inganno")) { binding.CIngannofalse.visibility = View.INVISIBLE
            } else { binding.CIngannotrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Intrattenere")) { binding.CIntrattenerefalse.visibility = View.INVISIBLE
            } else { binding.CIntratteneretrue.visibility = View.INVISIBLE }

            if (competenzeList.contains("Persuasione")) { binding.CPersuasionefalse.visibility = View.INVISIBLE
            } else { binding.CPersuasionetrue.visibility = View.INVISIBLE }
        }

        maestrie?.let {maestrieList ->
            if (maestrieList.contains("Atletica")) { binding.MAtleticafalse.visibility = View.INVISIBLE
            } else { binding.MAtleticatrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Acrobazia")) { binding.MAcrobaziafalse.visibility = View.INVISIBLE
            } else { binding.MAcrobaziatrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Rapidità di mano")) { binding.MRapiditfalse.visibility = View.INVISIBLE
            } else { binding.MRapidittrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Furtività")) { binding.MFurtivitfalse.visibility = View.INVISIBLE
            } else { binding.MFurtivittrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Arcano")) { binding.MArcanofalse.visibility = View.INVISIBLE
            } else { binding.MArcanotrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Indagare")) { binding.MIndagarefalse.visibility = View.INVISIBLE
            } else { binding.MIndagaretrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Natura")) { binding.MNaturafalse.visibility = View.INVISIBLE
            } else { binding.MNaturatrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Religione")) { binding.MReligionefalse.visibility = View.INVISIBLE
            } else { binding.MReligionetrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Storia")) { binding.MStoriafalse.visibility = View.INVISIBLE
            } else { binding.MStoriatrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Addestrare Animali")) { binding.MAddestrarefalse.visibility = View.INVISIBLE
            } else { binding.MAddestraretrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Intuizione")) { binding.MIntuizionefalse.visibility = View.INVISIBLE
            } else { binding.MIntuizionetrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Medicina")) { binding.MMedicinafalse.visibility = View.INVISIBLE
            } else { binding.MMedicinatrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Percezione")) { binding.MPercepirefalse.visibility = View.INVISIBLE
            } else { binding.MPercepiretrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Sopravvivenza")) { binding.MSopravvivenzafalse.visibility = View.INVISIBLE
            } else { binding.MSopravvivenzatrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Intimidire")) { binding.MIntimidirefalse.visibility = View.INVISIBLE
            } else { binding.MIntimidiretrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Inganno")) { binding.MIngannofalse.visibility = View.INVISIBLE
            } else { binding.MIngannotrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Intrattenere")) { binding.MIntrattenerefalse.visibility = View.INVISIBLE
            } else { binding.MIntratteneretrue.visibility = View.INVISIBLE }

            if (maestrieList.contains("Persuasione")) { binding.MPersuasionefalse.visibility = View.INVISIBLE
            } else { binding.MPersuasionetrue.visibility = View.INVISIBLE }
        }

        // Imposta i tiri salvezza in base alla classe
        if (classe != null) {
            when (classe) {
                "Bardo" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzafalse.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismafalse.visibility = View.INVISIBLE
                }

                "Ladro" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzafalse.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzafalse.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Guerriero" -> {
                    binding.TSforzafalse.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionefalse.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Mago" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzafalse.visibility = View.INVISIBLE
                    binding.TSsaggezzafalse.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Barbaro" -> {
                    binding.TSforzafalse.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionefalse.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Chierico" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzafalse.visibility = View.INVISIBLE
                    binding.TScarismafalse.visibility = View.INVISIBLE
                }

                "Druido" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzafalse.visibility = View.INVISIBLE
                    binding.TSsaggezzafalse.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Monaco" -> {
                    binding.TSforzafalse.visibility = View.INVISIBLE
                    binding.TSdestrezzafalse.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Paladino" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzafalse.visibility = View.INVISIBLE
                    binding.TScarismafalse.visibility = View.INVISIBLE
                }

                "Ranger" -> {
                    binding.TSforzafalse.visibility = View.INVISIBLE
                    binding.TSdestrezzafalse.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismatrue.visibility = View.INVISIBLE
                }

                "Stregone" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionefalse.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzatrue.visibility = View.INVISIBLE
                    binding.TScarismafalse.visibility = View.INVISIBLE
                }

                "Warlock" -> {
                    binding.TSforzatrue.visibility = View.INVISIBLE
                    binding.TSdestrezzatrue.visibility = View.INVISIBLE
                    binding.TScostituzionetrue.visibility = View.INVISIBLE
                    binding.TSintelligenzatrue.visibility = View.INVISIBLE
                    binding.TSsaggezzafalse.visibility = View.INVISIBLE
                    binding.TScarismafalse.visibility = View.INVISIBLE
                }
            }
        }


        /*
        //Rimette la vita al valore massimo dopo che si è riposati
        binding.btnDormire.setOnClickListener {
            binding.puntiFerita.text = vitaMax
            Toast.makeText(
                context,
                "Hai riposato. La tua vita è tornata al massimo.",
                Toast.LENGTH_LONG
            ).show()
            val max = binding.editTextVitaMassima.text.toString()
            val num = max.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 1) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "vitaMax",max.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori maggiori di 0!", Toast.LENGTH_SHORT).show()
            }
        }
*/
        // Naviga alla schermata di modifica delle statistiche
        binding.btnModifica.setOnClickListener {
            findNavController().navigate(R.id.action_statsFragment_to_modificaStatsFragment)
        }

        //Naviga alla schermata del dado
        binding.btnDado.setOnClickListener {
            findNavController().navigate(R.id.action_statsBackFragment_to_dadoFragment3)
        }

        binding.btnCompetenzeExtra.setOnClickListener {
            var n = 1
            val competenzeExtraMessage = buildString {
                append("Le mie competenze extra sono:\n\n")
                competenzeMostrate.forEachIndexed { index, competenza ->
                    append("$n - $competenza")
                    if (index < competenzeMostrate.size - 1) {
                        append("\n")
                        n += 1
                    }
                }
                if (linguaggi != null) {
                    n = 1
                    append("\n")
                    append("I miei linguaggi sono:")

                    linguaggi.forEachIndexed { index, linguaggi ->
                        append("$n - $linguaggi")
                        if (index < competenzeMostrate.size - 1) {
                            append("\n")
                            n += 1
                        }
                    }
                }
            }
                // Creazione dell'AlertDialog
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Competenze Extra")
                builder.setMessage(competenzeExtraMessage)

                // Visualizzazione dell'AlertDialog
                val dialog = builder.create()
                dialog.show()
        }

        // Conferma l'eliminazione del personaggio
        binding.btnElimina.setOnClickListener {
            val alertDialog = AlertDialog.Builder(requireContext())
                .setTitle("Conferma eliminazione")
                .setMessage("Sei sicuro di voler eliminare il personaggio?")
                .setPositiveButton("Elimina") { dialog, _ ->
                    if (campagna == "") {
                        if (nome != null && razza != null && classe != null && utenteId != null) {
                            viewModel.deletePersonaggio(nome, razza, classe, utenteId, campagna)
                                .observe(viewLifecycleOwner) { isDeleted ->
                                    if (isDeleted) {
                                        Toast.makeText(
                                            requireContext(),
                                            "Personaggio eliminato con successo",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                        // Aggiungi qui altre azioni da eseguire dopo l'eliminazione
                                        val intentEnd =
                                            Intent(requireContext(), CharacterActivity::class.java)
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
            12 -> m = +1
            13 -> m = +1
            14 -> m = +2
            15 -> m = +2
            16 -> m = +3
            17 -> m = +3
            18 -> m = +4
            19 -> m = +4
            20 -> m = +5
            21 -> m = +5
            22 -> m = +6
        }
        return  m
    }

    // Calcola il bonus di competenza in base al livello
    private fun getBonusComp(livello: String): String{
        var m = "0"
        when(livello.toInt()){
            1 -> m = "+2"
            2 -> m = "+2"
            3 -> m = "+2"
            4 -> m = "+2"
            5 -> m = "+3"
            6 -> m = "+3"
            7 -> m = "+3"
            8 -> m = "+3"
            9 -> m = "+4"
            10 -> m = "+4"
            11 -> m = "+4"
            12 -> m = "+4"
            13 -> m = "+5"
            14 -> m = "+5"
            15 -> m = "+5"
            16 -> m = "+5"
            17 -> m = "+6"
            18 -> m = "+6"
            19 -> m = "+6"
            20 -> m = "+6"
        }
        return m
    }

    // Calcola e visualizza la classe di difficoltà dei tiri salvezza magici
    /*if(classe != null && livello != null){
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
    }*/

    // Calcola e visualizza il bonus di attacco/incantesimo
    /*if(classe != null && livello != null){
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
    }*/

    /*
    // Calcola la classe di difficoltà dei tiri salvezza magici
    private fun getCD(bonusComp: Int, modificatore: Int): Int{
        return 8 + bonusComp + modificatore
    }

    // Calcola il bonus di attacco/incantesimo
    private fun getBonusAttacco(bonusComp: Int, modificatore: Int): Int{
        return bonusComp + modificatore
    }
*/
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
