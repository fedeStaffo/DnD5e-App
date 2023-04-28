package com.progetto_dd.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.progetto_dd.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResetPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Definisce il comportamento della freccia per tornare indietro
        binding.forgetPasswordBackBtn.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Definisce il comportamento del bottone di reset
        // una volta che si è inserita la mail
        binding.resetButton.setOnClickListener {
            val email: String = binding.emailPerReset.text.toString().trim { it <= ' '}

            // Controlla se il campo della mail è vuoto
            if (email.isEmpty()) Toast.makeText(this, "Non sono ammessi campi vuoti !",
                Toast.LENGTH_SHORT).show()
            // Invia all'utente la mail per il reset
            else FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{task->
                    if(task.isSuccessful) {
                        Toast.makeText(this, "Email inviata correttamente!",
                            Toast.LENGTH_LONG).show()

                        finish()
                    }
                    // Lancia un'eccezione se la mail inserita non risulta nel database
                    else Toast.makeText(this, task.exception!!.message.toString(),
                        Toast.LENGTH_LONG).show()
                }
        }
    }
}