package com.progetto_dd.utils

import android.content.Context
import android.content.res.ColorStateList
import android.widget.Button
import androidx.core.content.ContextCompat
import com.progetto_dd.R

// Classe per modificare l'aspetto e le funzionalità dei bottoni, prende come argomento
// il riferimento al context dove viene evocata
class ButtonUtils(private val context: Context) {

    fun updateButtonState(clickedButton: Button, unclickedButtons: List<Button>) {
        clickedButton.apply {
            text = context.getString(R.string.scelto).uppercase()
            setTextColor(ContextCompat.getColor(context, R.color.black))
            backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.orange))
        }

        unclickedButtons.forEach { button ->
            button.apply {
                text = context.getString(R.string.scegli).uppercase()
                setTextColor(ContextCompat.getColor(context, R.color.white))
                backgroundTintList = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.black))
            }
        }
    }
}