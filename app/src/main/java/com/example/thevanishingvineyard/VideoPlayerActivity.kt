// src/main/java/com/example/thevanishingvineyard/VideoPlayerActivity.kt
package com.example.thevanishingvineyard

import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class VideoPlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_player)

        val videoResId = intent.getIntExtra("videoResId", 0)
        val videoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoPath("android.resource://$packageName/$videoResId")
        videoView.start()
    }
}
