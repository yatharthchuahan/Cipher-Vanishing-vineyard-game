package com.example.thevanishingvineyard

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity2 : AppCompatActivity() {

    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)

        videoView = findViewById(R.id.video_view)

        // Make sure the videoView is not null before using it
        // Set the video URI or resource here
        videoView.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.splash_video2))
        videoView.start()

        // Start the video and navigate to SplashActivity3 when the video finishes
        videoView.setOnCompletionListener {
            val intent = Intent(this, SplashActivity3::class.java)
            startActivity(intent)
            finish() // Finish the current activity
        }
    }
}