package com.example.thevanishingvineyard

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity3 : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash3)

        videoView = findViewById<VideoView>(R.id.video_view)
        button = findViewById<Button>(R.id.get_started_button)

        val uri = Uri.parse("android.resource://${packageName}/${R.raw.splash_video3}")
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnCompletionListener {
            button.isEnabled = true
        }

        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}