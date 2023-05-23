package com.progetto_dd.view.campaigns

import com.progetto_dd.memory.campagna.CampagnaViewModel
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.FragmentAddCampaignBinding

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

                if(password == confPassword){
                    // Crea la campagna con il nome e password scelti
                    viewModel.creaCampagna(nome,password,master)
                    // Restarta l'activity campagna
                    val intent = Intent(activity, CampaignsActivity::class.java)
                    startActivity(intent)
                    activity?.finish()
                }
                else{ // Lancia un Toast se password e confPassword sono diverse
                    Toast.makeText(context, "Le due password non coincidono !", Toast.LENGTH_SHORT).show()
                }
            } else { // Lancia un Toast se uno dei campi è vuoto
                Toast.makeText(context, "Non sono ammessi campi vuoti !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}