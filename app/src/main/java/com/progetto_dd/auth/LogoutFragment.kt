package com.progetto_dd.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent
import com.progetto_dd.databinding.FragmentLogoutBinding


class LogoutFragment : Fragment() {

    private var _binding: FragmentLogoutBinding? = null
    private val binding get() = _binding!!
    private lateinit var auth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLogoutBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inizializza FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Aggiunge un listener al pulsante di logout
        binding.logoutBtn.setOnClickListener {
            auth.signOut()

            // Crea un Intent per avviare la LoginActivity
            val intent = Intent(activity, LoginActivity::class.java)

            // Chiama il metodo startActivity() per avviare la LoginActivity
            startActivity(intent)

            // Chiude il Fragment
            activity?.finish()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
