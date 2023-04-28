package com.progetto_dd.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import com.progetto_dd.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.progetto_dd.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


        firebaseAuth = FirebaseAuth.getInstance()

        // Definisce il comportamento del bottone "Non sei registrato"
        binding.noReg.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Definisce il comportamento del bottone "Password dimenticata"
        binding.passDimenticata.setOnClickListener {
            val intent = Intent(this, ResetPasswordActivity::class.java)
            startActivity(intent)
        }

        // Definisce il comportamento del bottone Accedi
        binding.button.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            // Controlla i campi inseriti
            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()

                    }
                }
            } else { // Lancia un Toast se uno dei campi di email e password è vuoto
                Toast.makeText(this, "Non sono ammessi campi vuoti !", Toast.LENGTH_SHORT).show()

            }
        }
    }
/*
    override fun onStart() {
        super.onStart()

        // Evita di chiedere ogni volta le credenziali all'utente
        if(firebaseAuth.currentUser != null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }*/
}