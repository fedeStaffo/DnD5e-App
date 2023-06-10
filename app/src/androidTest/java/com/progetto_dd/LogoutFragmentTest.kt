package com.progetto_dd

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.firebase.auth.FirebaseAuth
import com.progetto_dd.auth.LogoutFragment
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LogoutFragmentTest {

    private lateinit var firebaseAuth: FirebaseAuth

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity>
            = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setup() {
        // Inizializza l'istanza FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
    }

    @After
    fun cleanup() {
        // Effettua il logout dall'account Firebase se l'utente è loggato
        firebaseAuth.signOut()
    }

    @Test
    fun testLogoutButton_shouldSignOutAndStartLoginActivity() {
        // Esegue il fragment nel contesto dell'activity MainActivity
        launchFragmentInContainer<LogoutFragment>()

        // Verifica che il pulsante di logout sia presente e visibile
        onView(withId(R.id.logout_btn)).check(matches(isDisplayed()))

        // Simula il click sul pulsante di logout
        onView(withId(R.id.logout_btn)).perform(click())

        // Verifica che l'utente sia stato effettivamente disconnesso
        assert(firebaseAuth.currentUser == null)
    }
}
