package com.progetto_dd.view.campaigns.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.progetto_dd.R
import java.util.*

class DadoFragment : Fragment() {

    private lateinit var rootView: View
    private var totalModifier = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_dado, container, false)

        val buttonD100: Button = rootView.findViewById(R.id.d100)
        val buttonD20: Button = rootView.findViewById(R.id.d20)
        val buttonD12: Button = rootView.findViewById(R.id.d12)
        val buttonD10: Button = rootView.findViewById(R.id.d10)
        val buttonD8: Button = rootView.findViewById(R.id.d8)
        val buttonD6: Button = rootView.findViewById(R.id.d6)
        val buttonD4: Button = rootView.findViewById(R.id.d4)
        val buttonD3: Button = rootView.findViewById(R.id.d3)
        val buttonD2: Button = rootView.findViewById(R.id.d2)
        val button9: Button = rootView.findViewById(R.id.bottone9)
        val button8: Button = rootView.findViewById(R.id.bottone8)
        val button7: Button = rootView.findViewById(R.id.bottone7)
        val button6: Button = rootView.findViewById(R.id.bottone6)
        val button5: Button = rootView.findViewById(R.id.bottone5)
        val button4: Button = rootView.findViewById(R.id.bottone4)
        val button3: Button = rootView.findViewById(R.id.bottone3)
        val button2: Button = rootView.findViewById(R.id.bottone2)
        val button1: Button = rootView.findViewById(R.id.bottone1)
        val button0: Button = rootView.findViewById(R.id.bottone0)
        val buttonminus: Button = rootView.findViewById(R.id.bottone_meno)
        val buttonplus: Button = rootView.findViewById(R.id.bottone_piu)
        val buttonBackspace: ImageButton = rootView.findViewById(R.id.backspaceButton)
        val buttonRoll: Button = rootView.findViewById(R.id.roll)

        buttonD100.setOnClickListener { onButtonClick("d100") }
        buttonD20.setOnClickListener { onButtonClick("d20") }
        buttonD12.setOnClickListener { onButtonClick("d12") }
        buttonD10.setOnClickListener { onButtonClick("d10") }
        buttonD8.setOnClickListener { onButtonClick("d8") }
        buttonD6.setOnClickListener { onButtonClick("d6") }
        buttonD4.setOnClickListener { onButtonClick("d4") }
        buttonD3.setOnClickListener { onButtonClick("d3") }
        buttonD2.setOnClickListener { onButtonClick("d2") }
        button9.setOnClickListener { onButtonClick("9") }
        button8.setOnClickListener { onButtonClick("8") }
        button7.setOnClickListener { onButtonClick("7") }
        button6.setOnClickListener { onButtonClick("6") }
        button5.setOnClickListener { onButtonClick("5") }
        button4.setOnClickListener { onButtonClick("4") }
        button3.setOnClickListener { onButtonClick("3") }
        button2.setOnClickListener { onButtonClick("2") }
        button1.setOnClickListener { onButtonClick("1") }
        button0.setOnClickListener { onButtonClick("0") }
        buttonminus.setOnClickListener { onButtonClick("-") }
        buttonplus.setOnClickListener { onButtonClick("+") }
        buttonBackspace.setOnClickListener { onBackspaceClick() }
        buttonRoll.setOnClickListener { onRollClick() }

        return rootView
    }

    private fun onButtonClick(buttonText: String) {
        val textDado: TextInputEditText = rootView.findViewById(R.id.textDado)
        val currentText = textDado.text.toString()
        textDado.setText("$currentText$buttonText")
    }

    private fun onBackspaceClick() {
        val textDado: TextInputEditText = rootView.findViewById(R.id.textDado)
        val currentText = textDado.text.toString()
        if (currentText.isNotEmpty()) {
            val newText = when {
                currentText.endsWith("d") -> currentText.dropLast(1)
                currentText.endsWith("+") || currentText.endsWith("-") -> currentText.dropLast(1)
                else -> {
                    val lastIndexOfPlus = currentText.lastIndexOf("+")
                    val lastIndexOfMinus = currentText.lastIndexOf("-")
                    val lastIndex = maxOf(lastIndexOfPlus, lastIndexOfMinus)
                    if (lastIndex >= 0) {
                        currentText.substring(0, lastIndex + 1)
                    } else {
                        ""
                    }
                }
            }
            textDado.setText(newText)
            textDado.setSelection(newText.length) // Imposta il cursore alla fine del testo
        }
    }

    private fun countOccurrencesOfD(text: String): Int {
        var count = 0
        for (char in text) {
            if (char == 'd') {
                count++
            }
        }
        return count
    }

    private fun onRollClick() {
        val textDado: TextInputEditText = rootView.findViewById(R.id.textDado)
        val currentText = textDado.text?.toString()

        if (!currentText.isNullOrEmpty()) {
            val diceList = mutableListOf<String>()
            val modifierList = mutableListOf<Int>()
            var currentDice = StringBuilder()
            var currentModifier = StringBuilder()

            for (char in currentText) {
                if (char.isDigit() || char == 'd') {
                    currentDice.append(char)
                    if (currentModifier.isNotEmpty()) {
                        modifierList.add(currentModifier.toString().toInt())
                        currentModifier = StringBuilder()
                    }
                } else if (char == '+' || char == '-') {
                    if (currentDice.isNotEmpty()) {
                        diceList.add(currentDice.toString())
                        currentDice = StringBuilder()
                    }
                    currentModifier.append(char)
                }
            }

            if (currentDice.isNotEmpty()) {
                diceList.add(currentDice.toString())
            }

            if (currentModifier.isNotEmpty()) {
                modifierList.add(currentModifier.toString().toInt())
            }

            val modifiersSum = modifierList.sum()

            val results = diceList.map { rollDice(it) }.flatten()

            if (results.isNotEmpty()) {
                showRollResult(results, diceList, modifiersSum)
            } else {
                Toast.makeText(requireContext(), "Errore nell'input del dado", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun evaluateExpression(expression: String): Int {
        try {
            val operators = mutableListOf<Char>()
            val operands = mutableListOf<Int>()

            var currentOperand = StringBuilder()

            for (char in expression) {
                if (char.isDigit()) {
                    currentOperand.append(char)
                } else {
                    if (currentOperand.isNotEmpty()) {
                        operands.add(currentOperand.toString().toInt())
                        currentOperand = StringBuilder()
                    }

                    if (char == '+' || char == '-') {
                        while (operators.isNotEmpty() && operators.last() != '(' && operators.last() != '-') {
                            evaluateTopOperator(operators, operands)
                        }
                        operators.add(char)
                    } else if (char == '(') {
                        operators.add(char)
                    } else if (char == ')') {
                        while (operators.isNotEmpty() && operators.last() != '(') {
                            evaluateTopOperator(operators, operands)
                        }
                        if (operators.isNotEmpty() && operators.last() == '(') {
                            operators.removeAt(operators.size - 1)
                        } else {
                            throw Exception("Invalid expression")
                        }
                    }
                }
            }

            if (currentOperand.isNotEmpty()) {
                operands.add(currentOperand.toString().toInt())
            }

            while (operators.isNotEmpty()) {
                evaluateTopOperator(operators, operands)
            }

            if (operands.size != 1 || operators.isNotEmpty()) {
                throw Exception("Invalid expression")
            }

            return operands.first()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return 0
    }

    private fun evaluateTopOperator(operators: MutableList<Char>, operands: MutableList<Int>) {
        val operator = operators.removeAt(operators.size - 1)
        val operand2 = operands.removeAt(operands.size - 1)
        val operand1 = operands.removeAt(operands.size - 1)

        val result = when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            else -> throw Exception("Invalid operator")
        }

        operands.add(result)
    }

    private fun showNumericResult(result: Int) {
        val message = "TOTALE: $result"
        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setMessage(message)
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    private fun rollDice(diceText: String): List<Int> {
        val diceParts = diceText.split("d")
        if (diceParts.size == 2) {
            var numDice = diceParts[0].toIntOrNull()
            val numSides = diceParts[1].toIntOrNull()
            if (numDice == null) {
                numDice = 1
            }
            if (numDice != null && numSides != null && numDice > 0 && numSides > 0) {
                val diceRolls = List(numDice) {
                    val random = Random()
                    random.nextInt(numSides) + 1
                }
                return diceRolls
            }
        }
        return emptyList()
    }

    private fun showRollResult(results: List<Int>, diceList: List<String>, modifiersSum: Int) {
        val diceRolls = results.joinToString(" + ")

        val total = results.sum()
        val totalWithModifiers = total + modifiersSum

        val modifierString = if (modifiersSum != 0) {
            if (modifiersSum >= 0) "+ $modifiersSum" else "- ${-modifiersSum}"
        } else {
            ""
        }

        val message = when {
            diceList.size == 1 && modifiersSum == 0 -> {
                "DADO: $total"
            }
            diceList.isNotEmpty() && modifiersSum != 0 -> {
                "TOTALE: $totalWithModifiers\nTiri singoli: $diceRolls\nModificatore: $modifierString"
            }
            diceList.isNotEmpty() && modifiersSum == 0 -> {
                "TOTALE: $totalWithModifiers\nTiri singoli: $diceRolls"
            }
            modifiersSum != 0 -> {
                "Modificatore: $modifierString\nTOTALE: $totalWithModifiers"
            }
            else -> "ERRORE"
        }

        val alertDialogBuilder = AlertDialog.Builder(requireContext())
        alertDialogBuilder.setMessage(message)
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }


}