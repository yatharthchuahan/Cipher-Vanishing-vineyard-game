package com.example.thevanishingvineyard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContactDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_detail)

        val name = intent.getStringExtra("contactName")
        val phoneNumber = intent.getStringExtra("contactPhoneNumber")

        val nameTextView = findViewById<TextView>(R.id.detail_name)
        val phoneTextView = findViewById<TextView>(R.id.detail_phone)

        nameTextView.text = name
        phoneTextView.text = phoneNumber
    }
}
