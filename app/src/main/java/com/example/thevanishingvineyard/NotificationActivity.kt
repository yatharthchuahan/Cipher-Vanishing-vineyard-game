package com.example.thevanishingvineyard
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotificationActivity : AppCompatActivity() {

    private lateinit var messageTextView: TextView
    private lateinit var buttons: List<Button>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        // Initialize views
        messageTextView = findViewById(R.id.messageTextView)
        buttons = listOf(
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),  // Adding more buttons
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9),
            findViewById(R.id.button10),
            findViewById(R.id.button11),
            findViewById(R.id.button12),
            findViewById(R.id.button13),
            findViewById(R.id.button14),
            findViewById(R.id.button15)
        )

        // Set up button click listeners
        setupButtonClickListeners()
    }

    private fun setupButtonClickListeners() {
        buttons.forEachIndexed { index, button ->
            button.setOnClickListener {
                // Display the message based on the button index
                when (index) {
                    0 -> showMessage("Go chat with TIM")
                    1 -> {
                        showMessage("A parcel has been arrived at your desk. Go back and swipe right on your screen to open Desk!")
                        unlockInventory()
                    }
                    2 -> showMessage("Unlock the phone")
                    3 -> showMessage("Chat with Tom")
                    4 -> showMessage("Chat with Sandy")
                    5 -> showMessage("Check new emails in the Inbox")
                    6 -> showMessage("New mission available, check the Tasks section!")
                    7 -> showMessage("You have a new voicemail from Sarah")
                    8 -> showMessage("System update required. Please restart your phone.")
                    9 -> showMessage("A new clue has been added to the Case Files.")
                    10 -> showMessage("Backup the phone's data")
                    11 -> showMessage("Contact James about the new lead")
                    12 -> showMessage("You have 3 unread messages from Alice")
                    13 -> showMessage("An important document is waiting on your desk.")
                    14 -> showMessage("Reminder: Check the security footage from yesterday.")
                    // Add more cases for additional buttons as needed
                }

                // Reveal the next button if available
                if (index + 1 < buttons.size) {
                    buttons[index + 1].visibility = View.VISIBLE
                }

                // Hide the current button
                button.visibility = View.GONE
            }
        }
    }

    private fun showMessage(message: String) {
        messageTextView.text = message
        messageTextView.visibility = View.VISIBLE
    }

    private fun unlockInventory() {
        val sharedPreferences = getSharedPreferences("GamePreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isInventoryVisible", true)
        editor.apply()
    }
}
