package com.example.thevanishingvineyard
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SandyChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sandy_chat)

        // Get the back button
        val backButton: Button = findViewById(R.id.back_button)

        // Set an onClick listener for the back button
        backButton.setOnClickListener {
            // Handle the back button click here
            // For example, you could finish the activity to go back to the previous screen
            finish()
        }
    }
}