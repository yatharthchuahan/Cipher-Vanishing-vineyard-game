package com.example.thevanishingvineyard
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class DisplayActivity : AppCompatActivity() {

    private lateinit var timeTextView: TextView
    private lateinit var dateTextView: TextView
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable
    private lateinit var gestureDetector: GestureDetector

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        // Initialize Time and Date TextViews
        timeTextView = findViewById(R.id.time_text_view)
        dateTextView = findViewById(R.id.date_text_view)

        // Initialize GestureDetector
        gestureDetector = GestureDetector(this, GestureListener())

        // Set up touch listener
        findViewById<View>(R.id.activity_display_root).setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            true
        }

        // Update time and date every second
        runnable = object : Runnable {
            override fun run() {
                updateTimeAndDate()
                handler.postDelayed(this, 1000)
            }
        }
        handler.post(runnable)

        // App Button Setup
        val phoneButton = findViewById<ImageButton>(R.id.phone_button)
        val messagesButton = findViewById<ImageButton>(R.id.messages_button)
        val calculatorButton = findViewById<ImageButton>(R.id.contacts_button)
        val browserButton = findViewById<ImageButton>(R.id.browser_button)
        val notesButton = findViewById<ImageButton>(R.id.notes_button)
        val settingsButton = findViewById<ImageButton>(R.id.settings_button)

        // Set click listeners for the app buttons
        phoneButton.setOnClickListener {
            val intent = Intent(this, DialerActivity::class.java)
            startActivity(intent)
        }

        messagesButton.setOnClickListener {
            val intent = Intent(this, PhoneScreenActivity::class.java)
            startActivity(intent)
        }

        calculatorButton.setOnClickListener {
            val intent = Intent(this, ContactActivity::class.java)
            startActivity(intent)
        }

        browserButton.setOnClickListener {
            val intent = Intent(this, CalculatorActivity::class.java)
            startActivity(intent)
        }

        notesButton.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }

        settingsButton.setOnClickListener {
            val intent = Intent(/* packageContext = */ this, /* cls = */ SettingsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateTimeAndDate() {
        val currentTime = Calendar.getInstance().time
        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val dateFormat = SimpleDateFormat("EEE, MMM d", Locale.getDefault())
        timeTextView.text = timeFormat.format(currentTime)
        dateTextView.text = dateFormat.format(currentTime)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(runnable)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val SWIPE_THRESHOLD = 100
            val SWIPE_VELOCITY_THRESHOLD = 100

            if (e1 != null && e2 != null) {
                val diffX = e2.x - e1.x
                val diffY = e2.y - e1.y

                if (Math.abs(diffX) > Math.abs(diffY)) {
                    // Horizontal swipe
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            // Swipe right
                            openGrapevinePhoneActivity()
                        } else {
                            // Swipe left
                            openDeskActivity()
                        }
                        return true
                    }
                } else {
                    // Vertical swipe
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            // Swipe down
                            openNotificationActivity()
                        } else {
                            // Swipe up
                            // Add your code here for swipe up
                        }
                        return true
                    }
                }
            }
            return false
        }
    }

    private fun openGrapevinePhoneActivity() {
        val intent = Intent(this, GrapevinePhoneActivity::class.java)
        startActivity(intent)
    }

    private fun openDeskActivity() {
        val intent = Intent(this, DeskActivity::class.java)
        startActivity(intent)
    }

    private fun openNotificationActivity() {
        val intent = Intent(this, NotificationActivity::class.java)
        startActivity(intent)

    }
}