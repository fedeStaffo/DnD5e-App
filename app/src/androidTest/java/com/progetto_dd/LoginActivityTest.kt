package com.progetto_dd

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.firebase.auth.FirebaseAuth
import com.progetto_dd.auth.LoginActivity
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    private lateinit var firebaseAuth: FirebaseAuth

    @Before
    fun setup() {
        // Inizializza l'istanza FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()
    }

    @Test
    fun testNoRegButton_shouldStartRegisterActivity() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        // Simula il click sul pulsante "Non sei registrato"
        onView(withId(R.id.no_reg)).perform(click())

        // Verifica che l'Activity RegisterActivity sia stata avviata correttamente
        onView(withId(R.id.activityRegister)).check(matches(isDisplayed()))
    }

    @Test
    fun testPassDimenticataButton_shouldStartResetPasswordActivity() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        // Simula il click sul pulsante "Password dimenticata"
        onView(withId(R.id.pass_dimenticata)).perform(click())

        // Verifica che l'Activity ResetPasswordActivity sia stata avviata correttamente
        onView(withId(R.id.reset_password_activity_layout)).check(matches(isDisplayed()))
    }

    @Test
    fun testLoginButton_withValidCredentials_shouldStartMainActivity() {

        val activityScenario = ActivityScenario.launch(LoginActivity::class.java)

        // Simula l'inserimento delle credenziali
        onView(withId(R.id.emailEt)).perform(typeText("example@gmail.com"))
        onView(withId(R.id.passET)).perform(typeText("password"))

        // Chiude la tastiera
        closeSoftKeyboard()

        // Simula il click sul pulsante di accesso
        onView(withId(R.id.button)).perform(click())

        Thread.sleep(2000)

        // Verifica che l'Activity MainActivity sia stata avviata correttamente
        onView(withId(R.id.drawer_layout)).check(matches(isDisplayed()))
    }

    @After
    fun cleanup() {
        // Effettua il logout dall'account Firebase se l'utente è loggato
        firebaseAuth.signOut()
    }
}


