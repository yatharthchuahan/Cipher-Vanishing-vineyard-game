package com.example.thevanishingvineyard

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class NotesActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private val notes = listOf(
        Note("Meeting Notes", "Discussed project milestones and deadlines."),
        Note("Grocery List", "Milk, Bread, Eggs, Fruits."),
        Note("Birthday Ideas for lauren", "cake , movie , gift"),
        Note("Important Dates", "Project deadline: 31st Aug, Team meeting: 15th Aug.")
        // Add more notes as needed
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        listView = findViewById(R.id.notes_list_view)

        val adapter = NoteAdapter(this, notes)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val selectedNote = notes[position]
            val intent = Intent(this, NoteDetailActivity::class.java).apply {
                putExtra("noteTitle", selectedNote.title)
                putExtra("noteContent", selectedNote.content)
            }
            startActivity(intent)
        }
    }
}
