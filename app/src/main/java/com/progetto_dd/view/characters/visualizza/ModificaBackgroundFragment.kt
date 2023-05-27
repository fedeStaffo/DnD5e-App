package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentModificaBackgroundBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class ModificaBackgroundFragment : Fragment() {

    private var _binding: FragmentModificaBackgroundBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentModificaBackgroundBinding.inflate(inflater, container, false)
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

        binding.buttonSalvaDescrizione.setOnClickListener {
            val descrizione = binding.editTextDescrizione.text.toString()
            if(descrizione!= ""){
                if (nome != null && razza != null && classe != null && utenteId != null) {
                    viewModel.updateCampoString(nome, razza, classe, utenteId, "descrizione", descrizione)
                }
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(requireContext(),"Non puoi inserire campi vuoti!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSalvaDifetti.setOnClickListener {
            val difetti = binding.editTextDifetti.text.toString()
            if(difetti!= ""){
                if (nome != null && razza != null && classe != null && utenteId != null) {
                    viewModel.updateCampoString(nome, razza, classe, utenteId, "difetti", difetti)
                }
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(requireContext(),"Non puoi inserire campi vuoti!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSalvaLegami.setOnClickListener {
            val legami = binding.editTextLegami.text.toString()
            if(legami!= ""){
                if (nome != null && razza != null && classe != null && utenteId != null) {
                    viewModel.updateCampoString(nome, razza, classe, utenteId, "legami", legami)
                }
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(requireContext(),"Non puoi inserire campi vuoti!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSalvaStoria.setOnClickListener {
            val storia = binding.editTextStoria.text.toString()
            if(storia!= ""){
                if (nome != null && razza != null && classe != null && utenteId != null) {
                    viewModel.updateCampoString(nome, razza, classe, utenteId, "storia", storia)
                }
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(requireContext(),"Non puoi inserire campi vuoti!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSalvaTratticaratteriali.setOnClickListener {
            val tratti = binding.editTextTratticaratteriali.text.toString()
            if(tratti!= ""){
                if (nome != null && razza != null && classe != null && utenteId != null) {
                    viewModel.updateCampoString(nome, razza, classe, utenteId, "tratti", tratti)
                }
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(requireContext(),"Non puoi inserire campi vuoti!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSalvaIdeali.setOnClickListener {
            val ideali = binding.editTextIdeali.text.toString()
            if(ideali!= ""){
                if (nome != null && razza != null && classe != null && utenteId != null) {
                    viewModel.updateCampoString(nome, razza, classe, utenteId, "ideali", ideali)
                }
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(requireContext(),"Non puoi inserire campi vuoti!", Toast.LENGTH_SHORT).show()
        }

        binding.buttonSalvaAllineamento.setOnClickListener {
            val allineamento = binding.spinnerAllineamento.selectedItem as String
            if (nome != null && razza != null && classe != null && utenteId != null){
                viewModel.updateCampoString(nome, razza, classe, utenteId, "allineamento", allineamento)
                Toast.makeText(requireContext(),"Modifica effettuata!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}