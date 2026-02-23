package com.example.thevanishingvineyard
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class GrapevinePhoneActivity : AppCompatActivity() {

    private lateinit var passwordInput: EditText
    private lateinit var unlockButton: Button
    private lateinit var keypadGrid: GridLayout
    private lateinit var timeTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var mediaPlayer: MediaPlayer

    private val correctPassword = "1787"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grapevine_phone)

        // Initialize Views
        passwordInput = findViewById(R.id.password_input)
        unlockButton = findViewById(R.id.unlock_button)
        keypadGrid = findViewById(R.id.keypad_grid)
        timeTextView = findViewById(R.id.time_text_view)
        dateTextView = findViewById(R.id.date_text_view)

        // Setup MediaPlayer for background music
        mediaPlayer = MediaPlayer.create(this, R.raw.horror_sound)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        // Setup Keypad
        setupKeypad()

        // Update Time and Date
        updateTimeAndDate()

        // Unlock Button Click Listener
        unlockButton.setOnClickListener {
            checkPassword()
        }

        // Add TextWatcher to passwordInput
        passwordInput.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                unlockButton.isEnabled = s.length == correctPassword.length
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun setupKeypad() {
        val buttonIds = intArrayOf(
            R.id.button_1, R.id.button_2, R.id.button_3,
            R.id.button_4, R.id.button_5, R.id.button_6,
            R.id.button_7, R.id.button_8, R.id.button_9,
            R.id.button_0, R.id.button_clear
        )

        for (buttonId in buttonIds) {
            findViewById<Button>(buttonId).setOnClickListener {
                handleKeypadInput((it as Button).text.toString())
            }
        }

        findViewById<Button>(R.id.button_enter).setOnClickListener {
            checkPassword()
        }
    }

    private fun handleKeypadInput(input: String) {
        when (input) {
            "C" -> {
                passwordInput.text.clear()
            }
            else -> {
                passwordInput.append(input)
            }
        }
    }

    private fun checkPassword() {
        if (passwordInput.text.toString() == correctPassword) {
            Log.d("GrapevinePhoneActivity", "Correct password entered: $correctPassword")
            openPhoneGrapevineActivity()
        } else {
            Log.d("GrapevinePhoneActivity", "Incorrect password: ${passwordInput.text}")
            passwordInput.error = "Incorrect Password"
        }
    }

    private fun openPhoneGrapevineActivity() {
        val intent = Intent(this, PhoneGrapevineActivity::class.java)
        startActivity(intent)
        // Stop the background music when leaving the activity
        mediaPlayer.stop()
        mediaPlayer.release()
    }

    private fun updateTimeAndDate() {
        val currentTime = Calendar.getInstance().time
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val dateFormat = SimpleDateFormat("EEE, MMM d", Locale.getDefault())
        timeTextView.text = timeFormat.format(currentTime)
        dateTextView.text = dateFormat.format(currentTime)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer resources when the activity is destroyed
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }
}
