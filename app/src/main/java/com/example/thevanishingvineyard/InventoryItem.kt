package com.example.thevanishingvineyard

data class InventoryItem(
    val drawableId: Int, // Property for image resource ID
    val title: String, // Added title property
    val name: String,
    val type: ItemType
)