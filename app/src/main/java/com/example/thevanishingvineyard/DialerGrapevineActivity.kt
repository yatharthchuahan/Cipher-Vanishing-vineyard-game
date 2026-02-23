package com.example.thevanishingvineyard
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.view.View
import android.widget.TextView

class DialerGrapevineActivity: AppCompatActivity() {
    private lateinit var dialedNumberTextView: TextView
    private lateinit var keypadButtons: List<Button>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dialer_grapevine)

        // Initialize views
        dialedNumberTextView = findViewById(R.id.dialed_number)
        keypadButtons = listOf(
            findViewById(R.id.btn_1),
            findViewById(R.id.btn_2),
            findViewById(R.id.btn_3),
            findViewById(R.id.btn_4),
            findViewById(R.id.btn_5),
            findViewById(R.id.btn_6),
            findViewById(R.id.btn_7),
            findViewById(R.id.btn_8),
            findViewById(R.id.btn_9),
            findViewById(R.id.btn_star),
            findViewById(R.id.btn_0),
            findViewById(R.id.btn_hash)
        )

        // Set up button click listeners
        keypadButtons.forEach { button ->
            button.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    handleButtonClicked(button)
                }
            })
        }

        // Set up backspace and call buttons
        findViewById<Button>(R.id.btn_backspace).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleBackspaceClicked()
            }
        })
        findViewById<Button>(R.id.btn_call).setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                handleCallClicked()
            }
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    @SuppressLint("SetTextI18n")
    private fun handleButtonClicked(button: Button) {
        val dialedNumber = dialedNumberTextView.text.toString()
        val buttonText = button.text.toString()
        dialedNumberTextView.text = "$dialedNumber$buttonText"
    }

    private fun handleBackspaceClicked() {
        val dialedNumber = dialedNumberTextView.text.toString()
        if (dialedNumber.isNotEmpty()) {
            dialedNumberTextView.text = dialedNumber.substring(0, dialedNumber.length - 1)
        }
    }

    private fun handleCallClicked() {
        // TO DO: Implement call functionality
    }
}