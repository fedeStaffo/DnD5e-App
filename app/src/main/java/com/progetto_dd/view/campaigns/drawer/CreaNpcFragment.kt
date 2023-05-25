package com.progetto_dd.view.campaigns.drawer

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.firestore.FirebaseFirestore
import com.progetto_dd.R
import com.progetto_dd.view.campaigns.CampaignsActivity

class CreaNpcFragment : Fragment() {

    private lateinit var nomeNpcEditText: TextInputEditText
    private lateinit var descrizioneNpcEditText: TextInputEditText
    private lateinit var spinnerLegame: Spinner
    private lateinit var aggiungiNpcButton: Button

    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_crea_npc, container, false)

        nomeNpcEditText = view.findViewById(R.id.nome_npc)
        descrizioneNpcEditText = view.findViewById(R.id.descrizione_npc)
        spinnerLegame = view.findViewById(R.id.spinnerLegame)
        aggiungiNpcButton = view.findViewById(R.id.aggiungi_npc)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        aggiungiNpcButton.setOnClickListener {
            val nomeNpc = nomeNpcEditText.text.toString().trim()
            val descrizioneNpc = descrizioneNpcEditText.text.toString().trim()
            val legameNpc = spinnerLegame.selectedItem.toString()

            if (nomeNpc.isEmpty() || descrizioneNpc.isEmpty()) {
                Toast.makeText(requireContext(), "Inserisci il nome e la descrizione dell'NPC", Toast.LENGTH_SHORT).show()
            } else {
                val npc = hashMapOf(
                    "nome" to nomeNpc,
                    "descrizione" to descrizioneNpc,
                    "legame" to legameNpc,
                    "campagna" to campagnaNome,
                    "master" to masterId
                )

                firestore.collection("npc")
                    .add(npc)
                    .addOnSuccessListener {
                        val intent = Intent(activity, MainDrawerCampagnaActivity::class.java)
                        startActivity(intent)
                        activity?.finish()
                    }
            }
        }

        return view
    }
}
