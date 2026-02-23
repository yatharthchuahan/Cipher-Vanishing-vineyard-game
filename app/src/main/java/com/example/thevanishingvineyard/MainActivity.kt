package com.example.thevanishingvineyard

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newGameButton = findViewById<Button>(R.id.new_game_button)
        val loadGameButton = findViewById<Button>(R.id.load_game_button)

        mediaPlayer = MediaPlayer.create(this, R.raw.main_audio1)
        mediaPlayer.isLooping = true // Set to true if you want the audio to loop

        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start() // Start the audio as soon as the activity is created
        }

        newGameButton.setOnClickListener {
            stopAudio()
            val intent = Intent(this, LoginPageActivity::class.java)
            startActivity(intent)
        }

        loadGameButton.setOnClickListener {
            stopAudio()
            val intent = Intent(this, LoginPage2::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start() // Start the audio when the activity is resumed
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.release()
        }
    }

    private fun stopAudio() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.stop()
            mediaPlayer.prepare()
            mediaPlayer.seekTo(0)
        }
    }
}