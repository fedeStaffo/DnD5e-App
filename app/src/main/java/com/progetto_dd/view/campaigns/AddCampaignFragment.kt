package com.progetto_dd.view.campaigns

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentAddCampaignBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel

class AddCampaignFragment : Fragment() {

    private var _binding: FragmentAddCampaignBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: CampagnaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddCampaignBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(CampagnaViewModel::class.java)

        // Definisce il comportamento della creazione
        binding.buttonCrea.setOnClickListener {
            val nome = binding.nameEt.text.toString()
            val password = binding.passEt.text.toString()
            val confPassword = binding.confirmPassEt.text.toString()
            val master = binding.masterEt.text.toString()

            // Controlla i campi inseriti
            if (nome.isNotEmpty() && password.isNotEmpty() && confPassword.isNotEmpty() && master.isNotEmpty()) {
                if (password == confPassword) {
                    // Esegui la query per verificare l'esistenza della campagna
                    viewModel.checkExistingCampaign(nome).observe(viewLifecycleOwner) { existingCampaign ->
                        if (existingCampaign) {
                            Toast.makeText(
                                context,
                                "Hai già una campagna con lo stesso nome!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // La campagna non esiste, puoi procedere con la creazione
                            viewModel.creaCampagna(nome, password, master)
                            findNavController().navigate(R.id.action_addCampaignFragment_to_homeCampaignsFragment)
                        }
                    }
                } else {
                    Toast.makeText(context, "Le due password non coincidono!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(context, "Non sono ammessi campi vuoti!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}