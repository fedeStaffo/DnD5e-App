package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentSottorazzaInfoBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel


class SottorazzaInfoFragment : Fragment() {

    private var _binding: FragmentSottorazzaInfoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSottorazzaInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il viewmodel
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Inizializza la razza selezionata dall'utente dal viewmodel
        val razza = viewModel.razzaPersonaggio.value

        if (razza != null) {
            when(razza){
                "Elfo alto"-> binding.subraceInfoText.text = getString(R.string.elfo_alto_info)
                "Elfo dei boschi"-> binding.subraceInfoText.text = getString(R.string.elfo_dei_boschi_info)
                "Elfo oscuro"-> binding.subraceInfoText.text = getString(R.string.elfo_oscuro_info)
                "Nano delle montagne"-> binding.subraceInfoText.text = getString(R.string.nano_delle_montagne_info)
                "Nano delle colline"-> binding.subraceInfoText.text = getString(R.string.nano_delle_colline_info)
                "Halfling piedelesto"-> binding.subraceInfoText.text = getString(R.string.halfling_piedelesto_info)
                "Halfling tozzo"-> binding.subraceInfoText.text = getString(R.string.halfling_tozzo_info)
                "Gnomo delle rocce"-> binding.subraceInfoText.text = getString(R.string.gnomo_delle_rocce_info)
                "Gnomo delle foreste"-> binding.subraceInfoText.text = getString(R.string.gnomo_delle_foreste_info)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}