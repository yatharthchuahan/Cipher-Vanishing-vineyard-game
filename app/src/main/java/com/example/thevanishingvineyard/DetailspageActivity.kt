package com.example.thevanishingvineyard

import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DetailsPageActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var skipButton: Button
    private lateinit var imageView: ImageView
    private lateinit var otpEditText: EditText
    private lateinit var otpTextView: TextView
    private lateinit var emailEditText: EditText

    private var mediaPlayer: MediaPlayer? = null
    private var generatedOtp: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailspage)

        loginButton = findViewById(R.id.login_button)
        skipButton = findViewById(R.id.skip_button)
        imageView = findViewById(R.id.image_view)
        otpEditText = findViewById(R.id.otp_edit_text)
        otpTextView = findViewById(R.id.otp_text_view)
        emailEditText = findViewById(R.id.email_edit_text)

        setupAudio()

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Invalid email! Please try again.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            generatedOtp = generateOtp()

            otpEditText.visibility = View.VISIBLE
            otpTextView.visibility = View.VISIBLE
            otpEditText.setText("")
            otpEditText.requestFocus()

            otpTextView.text = "Your OTP is: $generatedOtp"

            loginButton.text = "VERIFY OTP"
            mediaPlayer?.start()

            loginButton.setOnClickListener {
                checkOtp()
            }
        }

        skipButton.setOnClickListener {
            openNextPage()
        }

        otpEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_GO) {
                checkOtp()
                true
            } else {
                false
            }
        }
    }

    private fun setupAudio() {
        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.mystery_sound)
            mediaPlayer?.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        } catch (e: Exception) {
            Log.e("AudioError", "Error creating MediaPlayer: $e")
        }
    }

    private fun generateOtp(): String {
        return Random.nextInt(100000, 999999).toString()
    }

    private fun checkOtp() {
        val enteredOtp = otpEditText.text.toString().trim()

        if (generatedOtp.isEmpty()) {
            Toast.makeText(this, "Please generate OTP first.", Toast.LENGTH_SHORT).show()
            return
        }

        if (enteredOtp.isEmpty()) {
            Toast.makeText(this, "Please enter the OTP!", Toast.LENGTH_SHORT).show()
            return
        }

        if (enteredOtp == generatedOtp) {
            openNextPage()
        } else {
            Toast.makeText(this, "Invalid OTP! Please try again.", Toast.LENGTH_SHORT).show()
            otpEditText.setText("")
        }
    }

    private fun openNextPage() {
        val intent = Intent(this, MainGame1::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
