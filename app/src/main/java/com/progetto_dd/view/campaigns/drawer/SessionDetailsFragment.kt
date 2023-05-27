package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentSessionDetailsBinding
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.sessione.SessioneViewModel


class SessionDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSessionDetailsBinding
    private lateinit var sessioneViewModel: SessioneViewModel
    private lateinit var viewModelCampagna: CampagnaViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSessionDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sessioneViewModel = ViewModelProvider(requireActivity()).get(SessioneViewModel::class.java)

        val sessioneNumero = arguments?.getString("numero_sessione")
        val sessioneGiorno = arguments?.getString("giorno_sessione")
        val sessioneDescrizione = arguments?.getString("descrizione_sessione")
        val master = arguments?.getString("master_id")
        val campagna = arguments?.getString("campagna")

        binding.Numero.text = sessioneNumero
        binding.Giorno.text = sessioneGiorno
        binding.Descrizione.text = sessioneDescrizione

        // Inizializza il CampagnaViewModel
        viewModelCampagna = ViewModelProvider(requireActivity()).get(CampagnaViewModel::class.java)

        // Prende l'id del master
        val masterId = arguments?.getString("master_id")

        val isMaster = masterId?.let { viewModelCampagna.isCurrentPlayerMaster(it) }

        if (isMaster == false) {
            binding.eliminaSessione.isVisible = false
        }

        binding.eliminaSessione.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setTitle("Elimina sessione")
            builder.setMessage("Sei sicuro di voler eliminare questa sessione?")
            builder.setPositiveButton("Elimina") { _, _ ->
                if (master != null && campagna != null && sessioneNumero != null) {
                    sessioneViewModel.eliminaSessione(campagna, master, sessioneNumero)
                    findNavController().navigate(R.id.action_sessionDetailsFragment_to_visualizzasessioniFragment)
                }
            }
            builder.setNegativeButton("Annulla", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}
