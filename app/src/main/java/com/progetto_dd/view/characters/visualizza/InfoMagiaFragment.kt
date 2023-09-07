package com.progetto_dd.view.characters.visualizza

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.MainActivity
import com.progetto_dd.databinding.FragmentInfoMagiaBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class InfoMagiaFragment : Fragment() {

    private var _binding: FragmentInfoMagiaBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla il layout per questo frammento
        _binding = FragmentInfoMagiaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        // Ottiene le informazioni dall'adapter degli incantesimi
        val nomeInc = arguments?.getString("nomeIncantesimo")
        val infoInc = arguments?.getString("infoIncantesimo")

        binding.infoMagia.text = infoInc.toString()

        val intent = requireActivity().intent

        val nome = intent.getStringExtra("nome")
        val razza = intent.getStringExtra("razza")
        val classe = intent.getStringExtra("classe")
        val utenteId = intent.getStringExtra("utente_id")


        // Controlla se l'activity corrente è la MainActivity
        if (requireActivity() is MainActivity) {
            // Se la condizione è vera, nascondi i bottoni "elimina" e "aggiungi"
            binding.btnAggiungiIncantesimo.visibility = View.GONE
            binding.btnEliminaIncantesimo.visibility = View.GONE
        } else {
            // Altrimenti, mantieni i bottoni visibili
            binding.btnAggiungiIncantesimo.visibility = View.VISIBLE
            binding.btnEliminaIncantesimo.visibility = View.VISIBLE
        }

        binding.btnAggiungiIncantesimo.setOnClickListener {
            // Verifica se la classe supporta gli incantesimi
            if (classe != "Bardo" && classe != "Mago" && classe != "Guerriero" && classe != "Ladro") {
                Toast.makeText(requireContext(), "Incantesimi non previsti per questa classe!", Toast.LENGTH_SHORT).show()
            } else {
                // Aggiungi l'incantesimo al personaggio utilizzando il view model
                if (nome != null && razza != null && utenteId != null && nomeInc != null) {
                    viewModel.addIncantesimoToPersonaggio(requireContext(), nome, razza, classe, utenteId, nomeInc)
                }
            }
        }

        binding.btnEliminaIncantesimo.setOnClickListener {
            // Verifica se la classe supporta gli incantesimi
            if (classe != "Bardo" && classe != "Mago" && classe != "Guerriero" && classe != "Ladro") {
                Toast.makeText(requireContext(), "Incantesimi non previsti per questa classe!", Toast.LENGTH_SHORT).show()
            } else {
                // Rimuovi l'incantesimo dal personaggio utilizzando il view model
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
