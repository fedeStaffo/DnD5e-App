package com.progetto_dd.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.progetto_dd.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.registrato.setOnClickListener{
            // Manda al menu di accesso se clicchi il bottone "Già registrato"
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Definisce il comportamento del tasto REGISTRATI
        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()
            val confirmPass = binding.confirmPassEt.text.toString()

            // Controllo sui campi inseriti durante la registrazione
            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            // Se la registrazione è effettuata con successo manda
                            // al menu di accesso
                            val intent = Intent(this, LoginActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                        }
                    }
                } else { // Manda in output un Toast se i due campi delle password hanno valori diversi
                    Toast.makeText(this, "Le due password non coincidono!", Toast.LENGTH_SHORT).show()
                }
            } else { // Manda in output un Toast se uno dei campi risulta vuoto
                Toast.makeText(this, "Non sono permessi campi vuoti!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}