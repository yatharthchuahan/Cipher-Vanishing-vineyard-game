package com.example.thevanishingvineyard

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainGame1 : AppCompatActivity() {

    private lateinit var timeTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var wifiImageView: ImageView
    private lateinit var batteryImageView: ImageView
    private lateinit var notificationButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_game1)

        timeTextView = findViewById(R.id.time_text_view)
        dateTextView = findViewById(R.id.date_text_view)
        wifiImageView = findViewById(R.id.wifi_image_view)
        batteryImageView = findViewById(R.id.battery_image_view)
        notificationButton = findViewById(R.id.notification_button)

        // Set initial time and date
        updateTimeAndDate()

        // Update time every second
        val handler = android.os.Handler()
        val runnable = object : Runnable {
            override fun run() {
                updateTimeAndDate()
                handler.postDelayed(this, 1000)
            }
        }
        handler.postDelayed(runnable, 1000)

        // Set notification button click listener
        notificationButton.setOnClickListener {
            // Start GameActivity when button is clicked
            val intent = Intent(this, PhoneScreenActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateTimeAndDate() {
        val currentTime = SimpleDateFormat("hh:mm a", Locale.US).format(Date())
        val currentDate = SimpleDateFormat("EEEE, MMM d, yyyy", Locale.US).format(Date())

        timeTextView.text = currentTime
        dateTextView.text = currentDate
    }
}