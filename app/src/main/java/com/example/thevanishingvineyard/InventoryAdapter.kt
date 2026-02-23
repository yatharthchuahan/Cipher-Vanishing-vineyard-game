package com.example.thevanishingvineyard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

interface ItemClickListener {
    fun onItemClick(item: InventoryItem)
}

class InventoryAdapter(private val context: Context, private val items: List<InventoryItem>, private val itemClickListener: ItemClickListener) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val item = items[position]
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_inventory, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.itemImageView)
        val textView = view.findViewById<TextView>(R.id.itemTextView)

        imageView.setImageResource(item.drawableId)
        textView.text = item.title

        view.setOnClickListener {
            itemClickListener.onItemClick(item)
        }

        return view
    }
}