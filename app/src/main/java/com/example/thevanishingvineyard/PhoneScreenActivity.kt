package com.example.thevanishingvineyard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.media.MediaPlayer

class PhoneScreenActivity : AppCompatActivity() {

    private lateinit var backgroundMusic: MediaPlayer

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_screen)

        // Initialize the MediaPlayer with your audio file
        backgroundMusic = MediaPlayer.create(this, R.raw.mystery_sound) // replace with your audio file
        backgroundMusic.isLooping = true // Set to loop the audio
        backgroundMusic.start()

        // Add image button on top left corner
        val backButton = findViewById<ImageButton>(R.id.back_button)
        backButton.setOnClickListener {
            val intent = Intent(this, DisplayActivity::class.java)
            startActivity(intent)
        }

        // Add heading "Messages" on top center
        val messagesHeading = findViewById<TextView>(R.id.messages_heading)
        messagesHeading.text = "Messages"

        // Add WiFi and battery images on top right corner
        val wifiImage = findViewById<ImageView>(R.id.wifi_image)
        wifiImage.setImageResource(R.drawable.wifi)

        val batteryImage = findViewById<ImageView>(R.id.battery_image)
        batteryImage.setImageResource(R.drawable.battery)

        // Get the chat buttons
        val chat1Button = findViewById<Button>(R.id.chat_1_button)
        val chat2Button = findViewById<Button>(R.id.chat_2_button)
        val chat3Button = findViewById<Button>(R.id.chat_3_button)
        val chat4Button = findViewById<Button>(R.id.chat_4_button)
        val chat5Button = findViewById<Button>(R.id.chat_5_button)
        val chat6Button = findViewById<Button>(R.id.chat_6_button)
        val chat7Button = findViewById<Button>(R.id.chat_7_button)

        // Set the chat button click listeners
        chat1Button.setOnClickListener {
            // Open the chat activity for chat 1
            val intent = Intent(this, UnknownChatActivity::class.java)
            intent.putExtra("chatName", "Unknown")
            startActivity(intent)
        }

        chat2Button.setOnClickListener {
            // Open the chat activity for chat 2
            val intent = Intent(this, TimChatActivity::class.java)
            intent.putExtra("chatName", "Tim")
            startActivity(intent)
        }

        chat3Button.setOnClickListener {
            // Open the chat activity for chat 3
            val intent = Intent(this, TomChatActivity::class.java)
            intent.putExtra("chatName", "Tom Smith")
            startActivity(intent)
        }

        chat4Button.setOnClickListener {
            // Open the chat activity for chat 4
            val intent = Intent(this, ContactActivity::class.java)
            intent.putExtra("chatName", "Bob Smith")
            startActivity(intent)
        }

        chat5Button.setOnClickListener {
            // Open the chat activity for chat 5
            val intent = Intent(this, SettingsActivity::class.java)
            intent.putExtra("chatName", "Alice Johnson")
            startActivity(intent)
        }

        chat6Button.setOnClickListener {
            // Open the chat activity for chat 6
            val intent = Intent(this, UnknownChatActivity::class.java)
            intent.putExtra("chatName", "Mike Brown")
            startActivity(intent)
        }

        chat7Button.setOnClickListener {
            // Open the chat activity for chat 7
            val intent = Intent(this, UnknownChatActivity::class.java)
            intent.putExtra("chatName", "Emily Davis")
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        // Pause the background music when the activity is paused
        backgroundMusic.pause()
    }

    override fun onResume() {
        super.onResume()
        // Resume the background music when the activity is resumed
        backgroundMusic.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        // Release the MediaPlayer resources when the activity is destroyed
        backgroundMusic.release()
    }
}
