package com.progetto_dd.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.progetto_dd.databinding.FragmentHomeBinding
import com.progetto_dd.view.campaigns.CampaignsActivity
import com.progetto_dd.view.characters.CharacterActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Definisce il comportamento dell'immagine del cavaliere che
        // porta alla sezione dei personaggi
        binding.imageKnight.setOnClickListener {

            // Crea un Intent per avviare la LoginActivity
            val intent = Intent(activity, CharacterActivity::class.java)

            // Chiama il metodo startActivity() per avviare la CharacterActivity
            startActivity(intent)

            // Chiude il Fragment
            activity?.finish()
        }

        // Definisce il comportamento dell'immagine della mappa che
        // porta alla sezione dei personaggi
        binding.imageMap.setOnClickListener {

            // Crea un Intent per avviare la LoginActivity
            val intent = Intent(activity, CampaignsActivity::class.java)

            // Chiama il metodo startActivity() per avviare la CampaignsActivity
            startActivity(intent)

            // Chiude il Fragment
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}