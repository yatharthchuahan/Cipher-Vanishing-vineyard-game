package com.example.thevanishingvineyard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


class SplashActivity1 : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash1)

        videoView = findViewById<VideoView>(R.id.video_view)

        val uri = Uri.parse("android.resource://${packageName}/${R.raw.splash_video1}")
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnCompletionListener {
            val intent = Intent(this, SplashActivity2::class.java)
            startActivity(intent)
            finish()
        }
    }
}



