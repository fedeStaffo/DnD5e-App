package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentZainoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class ZainoFragment : Fragment() {

    private var _binding: FragmentZainoBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentZainoBinding.inflate(inflater, container, false)
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
        val equipaggiamento = intent.getStringArrayListExtra("equipaggiamento")

        if (equipaggiamento != null) {
            binding.textViewInventario.text = equipaggiamento.joinToString(separator = "\n")
        }

        binding.btnAggiungiOggetto.setOnClickListener {
            val nuovoOggetto = binding.inputOggetto.text.toString()

            if (nome != null && classe != null && razza != null && utenteId != null) {
                viewModel.addEquipaggiamentoToPersonaggio(
                    nome,
                    razza,
                    classe,
                    utenteId,
                    nuovoOggetto
                )
            }

            // Mostra un toast per confermare l'aggiunta dell'oggetto
            Toast.makeText(
                requireContext(),
                "Oggetto aggiunto all'equipaggiamento!",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.btnEliminaOggetto.setOnClickListener {
            val oggettoDaRimuovere = binding.inputOggetto.text.toString()

            if (nome != null && classe != null && razza != null && utenteId != null && oggettoDaRimuovere != "") {
                val oggettoRimossoLiveData = viewModel.removeEquipaggiamentoFromPersonaggio(
                    nome,
                    razza,
                    classe,
                    utenteId,
                    oggettoDaRimuovere
                )

                oggettoRimossoLiveData.observe(viewLifecycleOwner) { oggettoRimosso ->
                    if (oggettoRimosso == true) {
                        // Mostra un toast per confermare la rimozione dell'oggetto
                        Toast.makeText(
                            requireContext(),
                            "Oggetto rimosso dall'equipaggiamento!",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        // Mostra un toast per segnalare che l'oggetto da rimuovere non è stato trovato nell'equipaggiamento
                        Toast.makeText(
                            requireContext(),
                            "L'oggetto da rimuovere non è presente nell'equipaggiamento!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            else  Toast.makeText(
                requireContext(),
                "Non lasciare campi vuoti!",
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}