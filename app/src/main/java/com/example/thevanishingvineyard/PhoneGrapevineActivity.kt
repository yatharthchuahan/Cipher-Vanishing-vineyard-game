package com.example.thevanishingvineyard
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.abs

class PhoneGrapevineActivity : AppCompatActivity() {

    private lateinit var timeTextView: TextView
    private lateinit var dateTextView: TextView
    private lateinit var browserButton: ImageButton
    private lateinit var phoneButton: ImageButton
    private lateinit var messagesButton: ImageButton
    private lateinit var contactsButton: ImageButton
    private lateinit var settingsButton: ImageButton
    private lateinit var notesButton: ImageButton

    private lateinit var gestureDetector: GestureDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_grapevine)

        // Initialize views
        timeTextView = findViewById(R.id.time_text_view)
        dateTextView = findViewById(R.id.date_text_view)
        browserButton = findViewById(R.id.browser_button)
        phoneButton = findViewById(R.id.phone_button)
        messagesButton = findViewById(R.id.messages_button)
        contactsButton = findViewById(R.id.contacts_button)
        settingsButton = findViewById(R.id.settings_button)
        notesButton = findViewById(R.id.notes_button)

        // Initialize GestureDetector with a custom SimpleOnGestureListener
        gestureDetector = GestureDetector(this, object : GestureDetector.SimpleOnGestureListener() {
            override fun onFling(e1: MotionEvent?, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
                if (e1 != null) {
                    when {
                        e1.x - e2.x > 100 && abs(velocityX) > 100 -> {
                            startActivity(Intent(this@PhoneGrapevineActivity, DisplayActivity::class.java))
                            return true
                        }
                        e2.x - e1.x > 100 && abs(velocityX) > 100 -> {
                            startActivity(Intent(this@PhoneGrapevineActivity, DeskActivity::class.java))
                            return true
                        }
                        e2.y - e1.y > 100 && abs(velocityY) > 100 -> {
                            startActivity(Intent(this@PhoneGrapevineActivity, NotificationActivity::class.java))
                            return true
                        }
                    }
                }
                return false
            }
        })

        // Set up real-time clock
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val currentTime = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date())
                    timeTextView.text = currentTime
                }
            }
        }, 0, 1000) // update every second

        // Set up date
        val currentDate = SimpleDateFormat("EEE, MMM d", Locale.getDefault()).format(Date())
        dateTextView.text = currentDate

        // Set up button click listeners
        browserButton.setOnClickListener {
            startActivity(Intent(this, CalculatorGrapevine::class.java))
        }

        phoneButton.setOnClickListener {
            startActivity(Intent(this, DialerGrapevineActivity::class.java))
        }

        messagesButton.setOnClickListener {
            Log.d("PhoneGrapevineActivity", "messagesButton clicked")
            startActivity(Intent(this, GrapevineMessageActivity::class.java))
        }

        contactsButton.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }

        settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        notesButton.setOnClickListener {
            startActivity(Intent(this, NotesActivity::class.java))
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }
}
