package com.progetto_dd

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import com.progetto_dd.view.campaigns.drawer.DadoFragment
import org.junit.Test

class DadoTest {

    /**
     * Verifica che la funzione `rollDice` generi i risultati corretti per diversi lanci di dadi.
     */
    @Test
    fun rollDice_generaRisultatiCorretti() {
        // Prepara gli input di prova
        val diceString = "2d6"  // Lancio di 2 dadi a 6 facce

        // Crea un'istanza di DadoFragment e chiama la funzione `rollDice`
        val dadoFragment = DadoFragment()

        // Chiama la funzione da testare
        val results = dadoFragment.rollDice(diceString)

        // Verifica che i risultati siano corretti
        assertEquals(2, results.size)  // Deve generare 2 risultati (2 dadi lanciati)
        for (result in results) {
            // Ogni risultato deve essere compreso tra 1 e 6 (numero di facce del dado)
            assertTrue(result in 1..6)
        }
    }
}
