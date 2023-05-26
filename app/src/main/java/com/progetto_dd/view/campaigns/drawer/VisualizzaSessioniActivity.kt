package com.progetto_dd.view.campaigns.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.progetto_dd.databinding.ActivityVisualizzaSessioneBinding
import com.progetto_dd.memory.sessione.SessioneViewModel
import com.progetto_dd.view.campaigns.CampaignsActivity

class VisualizzaSessioniActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVisualizzaSessioneBinding

    private lateinit var sessioneViewModel: SessioneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisualizzaSessioneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessioneViewModel = ViewModelProvider(this).get(SessioneViewModel::class.java)

        val sessioneNumero = this.intent.getStringExtra("numero_sessione")
        val sessioneGiorno = this.intent.getStringExtra("giorno_sessione")
        val sessioneDescrizione = this.intent.getStringExtra("descrizione_sessione")
        val master = this.intent.getStringExtra("master_id")
        val campagna = this.intent.getStringExtra("campagna")

        binding.Numero.text = sessioneNumero
        binding.Giorno.text = sessioneGiorno
        binding.Descrizione.text = sessioneDescrizione

        binding.eliminaSessione.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Elimina sessione")
            builder.setMessage("Sei sicuro di voler eliminare questa sessione?")
            builder.setPositiveButton("Elimina") { _, _ ->
                if (master != null) {
                    if (campagna != null) {
                        if (sessioneNumero != null) {
                            sessioneViewModel.eliminaSessione(campagna, master, sessioneNumero)
                            val intent = Intent(this, CampaignsActivity::class.java)
                            startActivity(intent)
                        }
                    }
                }
            }
            builder.setNegativeButton("Annulla", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
    }
}