package com.example.thevanishingvineyard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NoteDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_detail)

        val title = intent.getStringExtra("noteTitle")
        val content = intent.getStringExtra("noteContent")

        val titleTextView = findViewById<TextView>(R.id.note_detail_title)
        val contentTextView = findViewById<TextView>(R.id.note_detail_content)

        titleTextView.text = title
        contentTextView.text = content
    }
}
