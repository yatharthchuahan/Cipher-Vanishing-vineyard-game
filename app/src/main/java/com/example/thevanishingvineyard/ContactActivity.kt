package com.example.thevanishingvineyard

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

data class Contact(val name: String, val phoneNumber: String)

class ContactActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val contacts = listOf(
        Contact("John Doe", "123-456-7890"),
        Contact("Jane Smith", "234-567-8901"),
        Contact("Bob Johnson", "345-678-9012"),
        Contact("Alice Williams", "456-789-0123")
        // Add more contacts as needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        listView = findViewById(R.id.contact_list_view)

        val adapter = ContactAdapter(this, contacts)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedContact = contacts[position]
            val intent = Intent(this, ContactDetailActivity::class.java).apply {
                putExtra("contactName", selectedContact.name)
                putExtra("contactPhoneNumber", selectedContact.phoneNumber)
            }
            startActivity(intent)
        }
    }
}
