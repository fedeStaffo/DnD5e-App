package com.progetto_dd.view.campaigns.drawer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView
import com.progetto_dd.R
import com.progetto_dd.memory.campagna.CampagnaViewModel
import com.progetto_dd.view.campaigns.CampaignsActivity

class MainDrawerCampagnaActivity : AppCompatActivity() {

    private lateinit var viewModelCampagna: CampagnaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_drawer_campagna)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbarCampagna)
        setSupportActionBar(toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_campagna) as NavHostFragment
        val navController = navHostFragment.navController
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout_campagna)
        val builder = AppBarConfiguration.Builder(navController.graph)
        builder.setOpenableLayout(drawer)
        val appBarConfiguration = builder.build()
        toolbar.setupWithNavController(navController, appBarConfiguration)
        val navView = findViewById<NavigationView>(R.id.nav_view_campagna)
        NavigationUI.setupWithNavController(navView, navController)

        // Inizializza il CampagnaViewModel
        viewModelCampagna = ViewModelProvider(this).get(CampagnaViewModel::class.java)

        // Prende l'id del master
        val masterId = this.intent.getStringExtra("master_id")

        val isMaster = masterId?.let { viewModelCampagna.isCurrentPlayerMaster(it) }

        if (isMaster == false) {
            // L'utente loggato non è il master della campagna
            // Nasconde le sezioni del drawer
            val menu = navView.menu

            // Nasconde la sezione "Master"
            menu.findItem(R.id.master_group).isVisible = false

            // Nasconde la sezione "Gestione campagna"
            menu.findItem(R.id.gestione_campagna_group).isVisible = false
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.view_campagna_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_campagna)
        return item.onNavDestinationSelected(navController)
                ||super.onOptionsItemSelected(item)
    }

    fun openCampaignActivityFromView(menuItem: MenuItem) {
        val intent = Intent(this, CampaignsActivity::class.java)
        startActivity(intent)
    }
}