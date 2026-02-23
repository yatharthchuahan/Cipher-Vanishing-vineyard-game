package com.example.thevanishingvineyard

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var input = ""
    private var operator = ""
    private var operand1 = ""
    private var operand2 = ""
    private var isOperatorPressed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        display = findViewById(R.id.calculator_display)

        val button0 = findViewById<Button>(R.id.button_0)
        val button1 = findViewById<Button>(R.id.button_1)
        val button2 = findViewById<Button>(R.id.button_2)
        val button3 = findViewById<Button>(R.id.button_3)
        val button4 = findViewById<Button>(R.id.button_4)
        val button5 = findViewById<Button>(R.id.button_5)
        val button6 = findViewById<Button>(R.id.button_6)
        val button7 = findViewById<Button>(R.id.button_7)
        val button8 = findViewById<Button>(R.id.button_8)
        val button9 = findViewById<Button>(R.id.button_9)
        val buttonDecimal = findViewById<Button>(R.id.button_decimal)
        val buttonClear = findViewById<Button>(R.id.button_clear)
        val buttonDivide = findViewById<Button>(R.id.button_divide)
        val buttonMultiply = findViewById<Button>(R.id.button_multiply)
        val buttonSubtract = findViewById<Button>(R.id.button_subtract)
        val buttonAdd = findViewById<Button>(R.id.button_add)
        val buttonEquals = findViewById<Button>(R.id.button_equals)

        val numberButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        numberButtons.forEach { button ->
            button.setOnClickListener {
                onNumberClick(button.text.toString())
            }
        }

        buttonDecimal.setOnClickListener { onDecimalClick() }
        buttonClear.setOnClickListener { onClearClick() }
        buttonDivide.setOnClickListener { onOperatorClick("/") }
        buttonMultiply.setOnClickListener { onOperatorClick("*") }
        buttonSubtract.setOnClickListener { onOperatorClick("-") }
        buttonAdd.setOnClickListener { onOperatorClick("+") }
        buttonEquals.setOnClickListener { onEqualsClick() }
    }

    private fun onNumberClick(number: String) {
        if (isOperatorPressed) {
            input = number
            isOperatorPressed = false
        } else {
            input += number
        }
        display.text = input
    }

    private fun onDecimalClick() {
        if (!input.contains(".")) {
            input += "."
            display.text = input
        }
    }

    private fun onClearClick() {
        input = ""
        operand1 = ""
        operand2 = ""
        operator = ""
        isOperatorPressed = false
        display.text = "0"
    }

    private fun onOperatorClick(op: String) {
        if (operator.isEmpty()) {
            operand1 = input
            operator = op
            input = ""
        } else {
            operand2 = input
            val result = calculate(operand1, operator, operand2)
            operand1 = result
            operator = op
            input = ""
            display.text = result
        }
        isOperatorPressed = true
    }

    private fun onEqualsClick() {
        if (operator.isNotEmpty()) {
            operand2 = input
            val result = calculate(operand1, operator, operand2)
            display.text = result
            operand1 = result
            operator = ""
            input = ""
        }
    }

    private fun calculate(operand1: String, operator: String, operand2: String): String {
        return try {
            val op1 = operand1.toDouble()
            val op2 = operand2.toDouble()
            val result = when (operator) {
                "+" -> op1 + op2
                "-" -> op1 - op2
                "*" -> op1 * op2
                "/" -> {
                    if (op2 != 0.0) op1 / op2 else "Error"
                }
                else -> "Error"
            }
            result.toString()
        } catch (e: NumberFormatException) {
            "Error"
        }
    }
}
