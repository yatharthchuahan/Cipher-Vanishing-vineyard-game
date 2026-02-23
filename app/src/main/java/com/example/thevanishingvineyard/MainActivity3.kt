package com.example.thevanishingvineyard
import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thevanishingvineyard.databinding.ActivityMain3Binding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Use the correct binding class
        binding = ActivityMain3Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Button actions
        binding.btnStart.setOnClickListener {
            val intent = Intent(this, PlayActivity::class.java)
            startActivity(intent)
        }

        binding.btnGuide.setOnClickListener {
            val intent = Intent(this, GuideActivity::class.java)
            startActivity(intent)
        }

        binding.btnFeedback.setOnClickListener {

            val alphaNumeric: List<Char> = ('A'..'Z') + ('0'..'9')

            var noRef: String
            var valid = false

            do {
                noRef = List(10) { alphaNumeric.random() }.joinToString("")

                valid = true
                if (!noRef.contains("[A-Z]".toRegex())) {
                    valid = false
                }

                if (!noRef.contains("[0-9]".toRegex())) {
                    valid = false
                }

            } while (!valid)

            val sdf = SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault())
            val currentDate = sdf.format(Date())

            val subject = "FEEDBACK GAME 64\n" +
                    "No. Ref : $noRef\n" +
                    "Tgl/Jam : $currentDate\n" +
                    "Nama : \n" +
                    "Feedback : \n"

            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("smsto:081998877665")
                putExtra("sms_body", subject)
            }
            startActivity(intent)
        }
    }
}
