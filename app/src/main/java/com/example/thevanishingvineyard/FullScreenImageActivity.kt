package com.example.thevanishingvineyard

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class FullScreenImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_screen_image)

        val imageView: ImageView = findViewById(R.id.fullScreenImageView)

        // Get the image resource ID from the intent
        val imageResourceId = intent.getIntExtra("imageResource", 0)

        // Set the image in the ImageView
        imageView.setImageResource(imageResourceId)
    }
}
