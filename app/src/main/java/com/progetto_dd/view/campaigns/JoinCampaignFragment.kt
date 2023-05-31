package com.progetto_dd.view.campaigns

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.MainActivity
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentJoinCampaignBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel

class JoinCampaignFragment : Fragment() {

    private var _binding: FragmentJoinCampaignBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CampagnaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentJoinCampaignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(CampagnaViewModel::class.java)

        val nomiPersonaggi = viewModel.getNomiPersonaggiUtente()

        nomiPersonaggi.observe(viewLifecycleOwner) { listaNomi ->
            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, listaNomi)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinnerPersonaggi.adapter = adapter

            if(binding.spinnerPersonaggi.isEmpty()){
                binding.spinnerPersonaggi.visibility = View.GONE
                Toast.makeText(requireContext(), "Devi prima creare un personaggio prima di unirti ad una campagna", Toast.LENGTH_SHORT).show()
                binding.buttonPartecipa.visibility = View.GONE
            }

            binding.buttonPartecipa.setOnClickListener {
                val nomePersonaggioSelezionato = binding.spinnerPersonaggi.selectedItem.toString()
                val nomeCampagna = binding.nomecampagnaEt.text.toString()
                val passCampagna = binding.editTextPassword.text.toString()

                if(nomePersonaggioSelezionato != "" && nomeCampagna != "" && passCampagna != ""){
                    // Chiamata alla funzione del view model per aggiungere la campagna al personaggio
                    viewModel.aggiungiCampagnaAPersonaggio(nomePersonaggioSelezionato,nomeCampagna)
                    // Chiamata alla funzione del view model per aggiungere il personaggio alla campagna
                    viewModel.aggiungiPersonaggioACampagna(requireContext(), nomeCampagna, passCampagna, nomePersonaggioSelezionato)

                    // Riporta alla pagina principale
                    findNavController().navigate(R.id.action_joinCampaignFragment_to_homeCampaignsFragment)
                }
                else Toast.makeText(requireContext(), "Non sono ammessi campi vuoti!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
