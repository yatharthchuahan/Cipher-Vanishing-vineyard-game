package com.example.thevanishingvineyard

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginPage2 : AppCompatActivity() {

    // Declare variables for emailEditText, passwordEditText, and loginButton
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var mediaPlayer: MediaPlayer

    // Variable to keep track of login attempts
    private var loginAttempts = 0

    // Override the onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the content view to Login.xml
        setContentView(R.layout.activity_login_page2)

        // Initialize emailEditText, passwordEditText, and loginButton using findViewById
        emailEditText = findViewById(R.id.email)
        passwordEditText = findViewById(R.id.password)
        loginButton = findViewById(R.id.login_button)

        // Initialize mediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.lp_sound)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        // Set an onClickListener for the loginButton
        loginButton.setOnClickListener {
            // Get the text from emailEditText and passwordEditText
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Check if email or password is empty
            if (email.isEmpty() || password.isEmpty()) {
                // Show a toast message if either field is empty
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Increment login attempts
            loginAttempts++

            // Check if login attempts exceed 3
            if (loginAttempts >= 3) {
                // Show a toast message and redirect to MainActivity
                Toast.makeText(this, "Try to start a new game!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Close the current activity
            } else {
                // Add your login logic here
                // For example, you can call a API to authenticate the user
                // or use a local database to validate the credentials

                // Show a toast message if login is successful
                Toast.makeText(this, "No Profile Found!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Release mediaPlayer resources when the activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()
    }
}