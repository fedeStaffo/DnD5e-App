package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentModificaStatsBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel


class ModificaStatsFragment : Fragment() {

    private var _binding: FragmentModificaStatsBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding =  FragmentModificaStatsBinding.inflate(inflater, container, false)
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
        val utenteId = intent.getStringExtra("utente_id")
        val vitaMax = intent.getStringExtra("vitaMax")
        val livello = intent.getStringExtra("livello")
        val forza = intent.getStringExtra("forza")
        val destrezza = intent.getStringExtra("destrezza")
        val costituzione = intent.getStringExtra("costituzione")
        val intelligenza = intent.getStringExtra("intelligenza")
        val carisma = intent.getStringExtra("carisma")
        val saggezza = intent.getStringExtra("saggezza")
        val classeArmatura = intent.getStringExtra("classeArmatura")
        val competenze = intent.getStringArrayListExtra("competenze")
        val maestrie = intent.getStringArrayListExtra("maestrie")

        binding.classeArmatura.hint = classeArmatura
        binding.puntiFerita.hint = vitaMax
        binding.livello.hint = livello
        binding.modificatoreForza.hint = forza
        binding.modificatoreDestrezza.hint = destrezza
        binding.modificatoreIntelligenza.hint = intelligenza
        binding.modificatoreCostituzione.hint = costituzione
        binding.modificatoreSaggezza.hint = saggezza
        binding.modificatoreCarisma.hint = carisma

        competenze?.let {competenzeList ->
            if (competenzeList.contains("Atletica")) binding.BoxCAtletica.isChecked = true

            if (competenzeList.contains("Acrobazia")) binding.BoxCAcrobazia.isChecked = true

            if (competenzeList.contains("Rapidità di mano")) binding.BoxCFurtivit.isChecked = true

            if (competenzeList.contains("Furtività")) binding.BoxCRapidit.isChecked = true

            if (competenzeList.contains("Arcano")) binding.BoxCArcano.isChecked = true

            if (competenzeList.contains("Indagare")) binding.BoxCIndagare.isChecked = true

            if (competenzeList.contains("Natura")) binding.BoxCNatura.isChecked = true

            if (competenzeList.contains("Religione")) binding.BoxCReligione.isChecked = true

            if (competenzeList.contains("Storia")) binding.BoxCStoria.isChecked = true

            if (competenzeList.contains("Addestrare Animali")) binding.BoxCAddestrare.isChecked = true

            if (competenzeList.contains("Intuizione")) binding.BoxCIntuizione.isChecked = true

            if (competenzeList.contains("Medicina")) binding.BoxCMedicina.isChecked = true

            if (competenzeList.contains("Percezione")) binding.BoxCPercepire.isChecked = true

            if (competenzeList.contains("Sopravvivenza")) binding.BoxCSopravvivenza.isChecked = true

            if (competenzeList.contains("Intimidire")) binding.BoxCIntimidire.isChecked = true

            if (competenzeList.contains("Inganno")) binding.BoxCInganno.isChecked = true

            if (competenzeList.contains("Intrattenere")) binding.BoxCIntrattenere.isChecked = true

            if (competenzeList.contains("Persuasione")) binding.BoxCPersuasione.isChecked = true
        }

        maestrie?.let {maestrieList ->
            if (maestrieList.contains("Atletica")) binding.BoxMAtletica.isChecked = true

            if (maestrieList.contains("Acrobazia")) binding.BoxMAcrobazia.isChecked = true

            if (maestrieList.contains("Rapidità di mano")) binding.BoxMFurtivit.isChecked = true

            if (maestrieList.contains("Furtività")) binding.BoxMRapidit.isChecked = true

            if (maestrieList.contains("Arcano")) binding.BoxMArcano.isChecked = true

            if (maestrieList.contains("Indagare")) binding.BoxMIndagare.isChecked = true

            if (maestrieList.contains("Natura")) binding.BoxMNatura.isChecked = true

            if (maestrieList.contains("Religione")) binding.BoxMReligione.isChecked = true

            if (maestrieList.contains("Storia")) binding.BoxMStoria.isChecked = true

            if (maestrieList.contains("Addestrare Animali")) binding.BoxMAddestrare.isChecked = true

            if (maestrieList.contains("Intuizione")) binding.BoxMIntuizione.isChecked = true

            if (maestrieList.contains("Medicina")) binding.BoxMMedicina.isChecked = true

            if (maestrieList.contains("Percezione")) binding.BoxMPercepire.isChecked = true

            if (maestrieList.contains("Sopravvivenza")) binding.BoxMSopravvivenza.isChecked = true

            if (maestrieList.contains("Intimidire")) binding.BoxMIntimidire.isChecked = true

            if (maestrieList.contains("Inganno")) binding.BoxMInganno.isChecked = true

            if (maestrieList.contains("Intrattenere")) binding.BoxMIntrattenere.isChecked = true

            if (maestrieList.contains("Persuasione")) binding.BoxMPersuasione.isChecked = true
        }
        /*
        binding.buttonSalvaLivello.setOnClickListener {
            val livello = binding.editTextLivello.text.toString()
            val numLivello = livello.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && numLivello >= 1 && numLivello <= 20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "livello",livello.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori da 1 a 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaVitaMassima.setOnClickListener {
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

        binding.buttonSalvaVitaAttuale.setOnClickListener {
            val vita = binding.editTextVitaAttuale.text.toString()
            val num = vita.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && numMax != null && num <= numMax) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "vita",vita.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori numerici inferiori ai punti ferita massimi!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaClasseArmatura.setOnClickListener {
            val ca = binding.editTextClasseArmatura.text.toString()
            val num = ca.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 1) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "classeArmatura",ca.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori maggiori di 0!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaForza.setOnClickListener {
            val mod = binding.editTextForza.text.toString()
            val num = mod.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 3 && num<=20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "forza",mod.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori tra 3 e 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaDestrezza.setOnClickListener {
            val mod = binding.editTextDestrezza.text.toString()
            val num = mod.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 3 && num<=20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "destrezza",mod.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori tra 3 e 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaCostituzione.setOnClickListener {
            val mod = binding.editTextCostituzione.text.toString()
            val num = mod.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 3 && num<=20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "costituzione",mod.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori tra 3 e 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaIntelligenza.setOnClickListener {
            val mod = binding.editTextIntelligenza.text.toString()
            val num = mod.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 3 && num<=20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "intelligenza",mod.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori tra 3 e 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaCarisma.setOnClickListener {
            val mod = binding.editTextCarisma.text.toString()
            val num = mod.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 3 && num<=20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "carisma",mod.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori tra 3 e 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaSaggezza.setOnClickListener {
            val mod = binding.editTextSaggezza.text.toString()
            val num = mod.toInt()
            if (nome != null && razza != null && classe != null && utenteId != null && num >= 3 && num<=20) {
                viewModel.updateCampoNumerico(nome,razza,classe,utenteId, "saggezza",mod.toLong())
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(requireContext(),"Inserisci valori tra 3 e 20!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonSalvaStatus.setOnClickListener {
            val status = binding.spinnerStatus.selectedItem as String
            if (nome != null && razza != null && classe != null && utenteId != null){
                viewModel.updateCampoString(nome, razza, classe, utenteId, "stato", status)
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
        }
        */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}