package com.example.thevanishingvineyard
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetailsPageActivity : AppCompatActivity() {

    private lateinit var loginButton: Button
    private lateinit var imageView: ImageView
    private lateinit var otpEditText: EditText
    private lateinit var otpTextView: TextView
    private lateinit var emailEditText: EditText
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailspage)

        loginButton = findViewById(R.id.login_button)
        imageView = findViewById(R.id.image_view)
        otpEditText = findViewById(R.id.otp_edit_text)
        otpTextView = findViewById(R.id.otp_text_view)
        emailEditText = findViewById(R.id.email_edit_text)

        try {
            mediaPlayer = MediaPlayer.create(this, R.raw.mystery_sound)
            mediaPlayer.setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
        } catch (e: Exception) {
            Log.e("AudioError", "Error creating MediaPlayer: $e")
        }
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()

            if (email.isNotEmpty()) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    sendOtpToUser(email)

                    otpEditText.visibility = View.VISIBLE
                    otpTextView.visibility = View.VISIBLE

                    loginButton.isEnabled = false

                    mediaPlayer.start() // Start playing the audio
                } else {
                    Toast.makeText(this, "Invalid email! Please try again.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter your email!", Toast.LENGTH_SHORT).show()
            }
        }

        otpEditText.setOnEditorActionListener { _, _, _ ->
            val otp = otpEditText.text.toString()

            if (otp.isNotEmpty()) {
                if (verifyOtp(otp)) {
                    val intent = Intent(this, MainGame1::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid OTP! Please try again.", Toast.LENGTH_SHORT).show()
                    otpEditText.setText("")
                }
            } else {
                Toast.makeText(this, "Please enter the OTP!", Toast.LENGTH_SHORT).show()
            }

            true
        }
    }

    private fun sendOtpToUser(email: String) {
        // Replace with your actual OTP sending logic
        otpTextView.text = "Your OTP is: 123456"
    }

    private fun verifyOtp(otp: String): Boolean {
        // Replace with your actual OTP verification logic
        return otp == "123456"
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mediaPlayer != null) {
            mediaPlayer.release() // Release the media player resources
        }
    }
}