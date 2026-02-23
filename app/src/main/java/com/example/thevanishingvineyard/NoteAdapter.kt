package com.example.thevanishingvineyard
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class NoteAdapter(context: Context, private val notes: List<Note>) :
    ArrayAdapter<Note>(context, R.layout.list_item_note, notes) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_note, parent, false)

        val note = notes[position]
        val titleTextView = view.findViewById<TextView>(R.id.note_title)
        val contentTextView = view.findViewById<TextView>(R.id.note_content)

        titleTextView.text = note.title
        contentTextView.text = note.content

        return view
    }
}
