package com.progetto_dd.view.characters.crea

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.progetto_dd.R
import com.progetto_dd.databinding.FragmentNameCharacterBinding
import com.progetto_dd.memory.personaggio.PersonaggioViewModel

class NameCharacterFragment : Fragment() {
    private lateinit var binding: FragmentNameCharacterBinding
    private lateinit var viewModel: PersonaggioViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla il layout della schermata del nome del personaggio
        binding = FragmentNameCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il view model
        viewModel = ViewModelProvider(requireActivity()).get(PersonaggioViewModel::class.java)

        binding.btnAvantiCreaPers.setOnClickListener {
            val nome = binding.nameEt.text.toString().trim()
            if (nome.isNotEmpty()) {
                val utenteId =
                    FirebaseAuth.getInstance().currentUser?.uid

                // Effettua la query per controllare se esiste già un documento con lo stesso nome e utenteId
                val db = FirebaseFirestore.getInstance()
                val personaggioRef = db.collection("personaggi")
                    .whereEqualTo("nome", nome)
                    .whereEqualTo("utenteId", utenteId)

                personaggioRef.get().addOnSuccessListener { querySnapshot ->
                    if (querySnapshot.isEmpty) {
                        // Nessun personaggio trovato con lo stesso nome e utenteId,
                        // quindi è possibile procedere alla creazione del personaggio

                        // Salva il nome inserito nel view model e passa alla schermata della razza del personaggio
                        viewModel.setNomePersonaggio(nome)
                        findNavController().navigate(R.id.action_nameCharacterFragment_to_raceFragment)
                    } else {
                        // È stato trovato un personaggio con lo stesso nome e utenteId,
                        // quindi mostra un messaggio di errore
                        Toast.makeText(requireContext(), "Un personaggio con questo nome esiste già!", Toast.LENGTH_SHORT).show()
                    }
                }.addOnFailureListener { exception ->
                    // Errore durante la query
                    Toast.makeText(requireContext(), "Errore durante il controllo del nome del personaggio!", Toast.LENGTH_SHORT).show()
                    Log.e("Firestore", "Error checking character name: ${exception.message}")
                }
            } else {
                // Mostra un messaggio di errore se non è stato inserito un nome
                Toast.makeText(requireContext(), "Inserisci un nome per il personaggio!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
