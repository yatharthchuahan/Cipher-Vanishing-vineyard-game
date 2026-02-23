package com.example.thevanishingvineyard

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.media.MediaPlayer

class GrapevineMessageActivity : AppCompatActivity() {

    private lateinit var backgroundMusic: MediaPlayer

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grapevine_message) // Ensure the layout file is correct

        // Initialize the MediaPlayer with your audio file
        backgroundMusic = MediaPlayer.create(this, R.raw.mystery_sound) // Ensure this file exists
        backgroundMusic.isLooping = true // Set to loop the audio
        backgroundMusic.start()

        // Add image button on top left corner
        val backButton = findViewById<ImageButton>(R.id.back_button)
        backButton?.setOnClickListener {
            val intent = Intent(this, PhoneGrapevineActivity::class.java)
            startActivity(intent)
        }

        // Add heading "Messages" on top center
        val messagesHeading = findViewById<TextView>(R.id.messages_heading)
        messagesHeading?.text = "Messages"

        // Add WiFi and battery images on top right corner
        val wifiImage = findViewById<ImageView>(R.id.wifi_image)
        wifiImage?.setImageResource(R.drawable.wifi)

        val batteryImage = findViewById<ImageView>(R.id.battery_image)
        batteryImage?.setImageResource(R.drawable.battery)

        // Get the chat buttons
        val chat1Button = findViewById<Button>(R.id.chat_1_button)
        val chat2Button = findViewById<Button>(R.id.chat_2_button)
        val chat3Button = findViewById<Button>(R.id.chat_3_button)
        val chat4Button = findViewById<Button>(R.id.chat_4_button)
        val chat5Button = findViewById<Button>(R.id.chat_5_button)
        val chat6Button = findViewById<Button>(R.id.chat_6_button)
        val chat7Button = findViewById<Button>(R.id.chat_7_button)

        // Set the chat button click listeners
        chat1Button?.setOnClickListener {
            val intent = Intent(this, JamesChatActivity::class.java)
            intent.putExtra("chatName", "James")
            startActivity(intent)
        }

        chat2Button?.setOnClickListener {
            val intent = Intent(this, SandyChatActivity::class.java)
            intent.putExtra("chatName", "RJ")
            startActivity(intent)
        }

        chat3Button?.setOnClickListener {
            // Ensure that SandyChatActivity exists and is correctly named in the manifest
            val intent = Intent(this, TimChatActivity::class.java)
            intent.putExtra("chatName", "Sandy")
            startActivity(intent)
        }

        chat4Button?.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            intent.putExtra("chatName", "Tom Smith")
            startActivity(intent)
        }

        chat5Button?.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            intent.putExtra("chatName", "April")
            startActivity(intent)
        }

        chat6Button?.setOnClickListener {
            val intent = Intent(this, UnknownChatActivity::class.java)
            intent.putExtra("chatName", "Alice")
            startActivity(intent)
        }

        chat7Button?.setOnClickListener {
            val intent = Intent(this, UnknownChatActivity::class.java)
            intent.putExtra("chatName", "Brown")
            startActivity(intent)
        }
    }

    override fun onPause() {
        super.onPause()
        backgroundMusic.pause()
    }

    override fun onResume() {
        super.onResume()
        backgroundMusic.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        backgroundMusic.release()
    }
}
