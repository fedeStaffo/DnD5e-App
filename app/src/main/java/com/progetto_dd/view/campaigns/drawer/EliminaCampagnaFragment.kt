package com.progetto_dd.view.campaigns.drawer

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.MainActivity
import com.progetto_dd.R
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.memory.npc.NpcViewModel
import com.progetto_dd.memory.sessione.SessioneViewModel


class EliminaCampagnaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_elimina_campagna, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inizializza il ViewModel
        val viewModelCamp = ViewModelProvider(this).get(CampagnaViewModel::class.java)
        val viewModelNpc = ViewModelProvider(this).get(NpcViewModel::class.java)
        val viewModelSessione = ViewModelProvider(this).get(SessioneViewModel::class.java)

        val btnElimina = view.findViewById<Button>(R.id.btnEliminaCampagna)

        val campagnaNome = requireActivity().intent.getStringExtra("campagna_nome")
        val masterId = requireActivity().intent.getStringExtra("master_id")

        btnElimina.setOnClickListener {
            val alertDialogBuilder = AlertDialog.Builder(requireContext())
            alertDialogBuilder.setTitle("Conferma eliminazione")
            alertDialogBuilder.setMessage("Vuoi confermare l'eliminazione della campagna??")
            alertDialogBuilder.setPositiveButton("Conferma") { dialog, _ ->
                if (campagnaNome != null && masterId != null) {

                    viewModelCamp.eliminaCampagna(campagnaNome, masterId)
                    viewModelNpc.deleteNPCsFromCampaign(campagnaNome, masterId)
                    viewModelSessione.deleteSessionsFromCampaign(campagnaNome, masterId)

                    val intent = Intent(requireContext(), MainActivity::class.java)
                    requireContext().startActivity(intent)
                }
                dialog.dismiss()

            }
            alertDialogBuilder.setNegativeButton("Annulla") { dialog, _ ->
                dialog.dismiss()
            }

            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()
        }
    }
}
