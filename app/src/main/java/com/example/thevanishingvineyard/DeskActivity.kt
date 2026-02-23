package com.example.thevanishingvineyard
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridView
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DeskActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var inventoryGridView: GridView
    private lateinit var inventoryItems: List<InventoryItem>
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var phoneImageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_desk)

        // Initialize shared preferences
        sharedPreferences = getSharedPreferences("GamePreferences", MODE_PRIVATE)

        // Initialize views
        inventoryGridView = findViewById(R.id.inventoryGridView)
        phoneImageButton = findViewById(R.id.phoneImageButton) as ImageButton

        // Initialize inventory items
        inventoryItems = listOf(
            InventoryItem(R.drawable.vine_bottle, "Vine Bottle", "Vine Bottle", ItemType.IMAGE),
            InventoryItem(R.drawable.footprints, "Footprints", "Footprints", ItemType.IMAGE),
            InventoryItem(R.drawable.identitycard, "Identity card", "Identity card", ItemType.IMAGE),
            InventoryItem(R.drawable.clipboard, "Clip Board", "Clip Board", ItemType.IMAGE),
            // Add more images and videos as needed
        )

        // Set adapter for GridView
        val adapter = InventoryAdapter(this, inventoryItems, this)
        inventoryGridView.adapter = adapter

        // Check if inventory should be visible
        val isInventoryVisible = sharedPreferences.getBoolean("isInventoryVisible", false)
        inventoryGridView.visibility = if (isInventoryVisible) View.VISIBLE else View.GONE
        Log.d("DeskActivity", "isInventoryVisible: $isInventoryVisible, GridView visibility: ${inventoryGridView.visibility}")

        // Ensure the button is visible and enabled
        phoneImageButton.visibility = View.VISIBLE
        phoneImageButton.isClickable = true
        phoneImageButton.isEnabled = true

        // Set an OnClickListener for the ImageButton
        phoneImageButton.setOnClickListener {
            Log.d("DeskActivity", "PhoneImageButton clicked")
            Toast.makeText(this, "You can access the phone by swiping right on the screen ", Toast.LENGTH_SHORT).show()

            // Start GrapevinePhoneActivity
            val intent = Intent(this, GrapevinePhoneActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onItemClick(item: InventoryItem) {
        displayItem(item)
    }

    private fun displayItem(item: InventoryItem) {
        if (item.type == ItemType.IMAGE) {
            // Start a new activity to display the image full screen
            val intent = Intent(this, FullScreenImageActivity::class.java).apply {
                putExtra("imageResource", item.drawableId) // Use drawableId for image resource
            }
            startActivity(intent)
        }
    }
}