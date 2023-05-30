package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentInfoMagiaBinding
import com.progetto_dd.databinding.FragmentMagieBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class InfoMagiaFragment : Fragment() {

    private var _binding: FragmentInfoMagiaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentInfoMagiaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Info ottenute dall'adapter degli incantesimi
        val nomeInc = arguments?.getString("nomeIncantesimo")
        val infoInc = arguments?.getString("infoIncantesimo")

        binding.infoMagia.text = infoInc.toString()

        val intent = requireActivity().intent

        val nome = intent.getStringExtra("nome")
        val razza = intent.getStringExtra("razza")
        val classe = intent.getStringExtra("classe")
        val utenteId = intent.getStringExtra("utente_id")

        binding.btnAggiungiIncantesimo.setOnClickListener {
            if(classe!= "Bardo" && classe != "Mago" && classe != "Guerriero" && classe != "Ladro"){
                Toast.makeText(requireContext(), "Incantesimi non previsti per questa classe!", Toast.LENGTH_SHORT).show()
            }
            else {
                if (nome != null && razza != null && utenteId != null && nomeInc != null) {
                    viewModel.addIncantesimoToPersonaggio(requireContext(), nome, razza, classe, utenteId, nomeInc)
                }
            }
        }

        binding.btnEliminaIncantesimo.setOnClickListener {
            if(classe!= "Bardo" && classe != "Mago" && classe != "Guerriero" && classe != "Ladro"){
                Toast.makeText(requireContext(), "Incantesimi non previsti per questa classe!", Toast.LENGTH_SHORT).show()
            }
            else {
                if (nome != null && razza != null && utenteId != null && nomeInc != null) {
                    viewModel.removeIncantesimoFromPersonaggio(requireContext(), nome, razza, classe, utenteId, nomeInc)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}