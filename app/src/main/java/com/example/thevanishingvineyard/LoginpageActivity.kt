package com.example.thevanishingvineyard

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class LoginPageActivity : AppCompatActivity() {

    private lateinit var videoView: VideoView
    private lateinit var signUpButton: Button

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        videoView = findViewById<VideoView>(R.id.video_view)
        signUpButton = findViewById<Button>(R.id.sign_up_button)

        val videoUri = Uri.parse("android.resource://${packageName}/${R.raw.login_video}")
        videoView.setVideoURI(videoUri)
        videoView.start()

        signUpButton.setOnClickListener {
            val intent = Intent(this, DetailsPageActivity::class.java)
            startActivity(intent)
        }

        // Add image to signUpButton
        val drawable: Drawable = resources.getDrawable(R.drawable.gmail_logo)
        drawable.setBounds(0, 0, 40, 40) // set the size of the image to 40x40
        signUpButton.setCompoundDrawables(drawable, null, null, null)
        signUpButton.compoundDrawablePadding = 10 // add padding between image and text
        signUpButton.text = "Sign Up with Gmail" // set the text of the button
    }

    class detailspage {

    }
}