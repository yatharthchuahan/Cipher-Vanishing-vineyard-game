package com.example.thevanishingvineyard
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.widget.SearchView

class SettingsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Load the preferences
        val prefManager = androidx.preference.PreferenceManager.getDefaultSharedPreferences(this)
        prefManager.registerOnSharedPreferenceChangeListener { _, _ ->
            // Handle preference changes here
        }

        // Set up search bar
        val searchView = findViewById<SearchView>(R.id.search_bar)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Handle search query submission
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Handle search query change
                return true
            }
        })

        // Set up mute button
        val muteButton = findViewById<ImageButton>(R.id.mute_button)
        muteButton.setOnClickListener {
            // Mute all sounds of the app
            // TODO: Implement sound muting logic here
        }

        // Set up link account button
        val linkAccountButton = findViewById<Button>(R.id.link_account_button)
        linkAccountButton.setOnClickListener {
            // Link account to Gmail
            // TODO: Implement Gmail account linking logic here
        }

        // Set up restart game button
        val restartGameButton = findViewById<Button>(R.id.restart_game_button)
        restartGameButton.setOnClickListener {
            restartApplication()
        }
    }

    private fun restartApplication() {
        val packageName = packageName
        val intent = packageManager.getLaunchIntentForPackage(packageName)
        val componentName = intent!!.component
        val mainIntent = Intent.makeRestartActivityTask(componentName)
        startActivity(mainIntent)
        Runtime.getRuntime().exit(0)
    }
}