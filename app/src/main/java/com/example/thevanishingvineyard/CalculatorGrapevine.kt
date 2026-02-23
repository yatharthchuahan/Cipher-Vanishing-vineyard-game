package com.example.thevanishingvineyard
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class CalculatorGrapevine : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var currentInput = ""
    private var operator = ""
    private var firstOperand = 0.0
    private var secondOperand = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator_grapevine)

        resultTextView = findViewById(R.id.resultTextView)

        setupNumberButtons()
        setupOperatorButtons()
        setupEqualButton()
        setupClearButton()
    }

    private fun setupNumberButtons() {
        val numberButtons = listOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9
        )

        for (buttonId in numberButtons) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                currentInput += button.text.toString()
                resultTextView.text = currentInput
            }
        }
    }

    private fun setupOperatorButtons() {
        val operatorButtons = mapOf(
            R.id.buttonAdd to "+",
            R.id.buttonSubtract to "-",
            R.id.buttonMultiply to "*",
            R.id.buttonDivide to "/"
        )

        for ((buttonId, op) in operatorButtons) {
            val button = findViewById<Button>(buttonId)
            button.setOnClickListener {
                if (currentInput.isNotEmpty()) {
                    firstOperand = currentInput.toDouble()
                    operator = op
                    currentInput = ""
                }
            }
        }
    }

    private fun setupEqualButton() {
        val equalButton = findViewById<Button>(R.id.buttonEquals)
        equalButton.setOnClickListener {
            if (currentInput.isNotEmpty()) {
                secondOperand = currentInput.toDouble()

                val result = when (operator) {
                    "+" -> firstOperand + secondOperand
                    "-" -> firstOperand - secondOperand
                    "*" -> firstOperand * secondOperand
                    "/" -> firstOperand / secondOperand
                    else -> 0.0
                }

                if (currentInput == "1978") {
                    // Open VaultActivity if user enters 1978
                    val intent = Intent(this,  MainActivity3::class.java)
                    startActivity(intent)
                } else {
                    resultTextView.text = result.toString()
                    currentInput = result.toString() // Reset to the result
                }
            } else {
                Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupClearButton() {
        val clearButton = findViewById<Button>(R.id.buttonClear)
        clearButton.setOnClickListener {
            currentInput = ""
            firstOperand = 0.0
            secondOperand = 0.0
            operator = ""
            resultTextView.text = "0"
        }
    }
}
