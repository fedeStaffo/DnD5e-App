package com.progetto_dd.view.characters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.progetto_dd.R

class CharacterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)

        // Imposta la toolbar personalizzata
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_char)
        setSupportActionBar(toolbar)

        // Configurazione del controller per navigare tra i fragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_characters) as NavHostFragment
        val navController = navHostFragment.navController

        val builder = AppBarConfiguration.Builder(navController.graph)

        // Abilita la navigazione quando un oggetto è cliccato sulla toolbar
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    // Aggiunge gli item del menu alla toolbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.characters_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Naviga sul fragment di destinazione quando un item è cliccato
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_characters)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }
}