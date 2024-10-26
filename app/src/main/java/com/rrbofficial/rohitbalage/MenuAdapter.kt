package com.rrbofficial.rohitbalage

import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MenuAdapter(private val menuItems: List<String>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(), android.widget.Adapter {

    private var selectedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item_layout, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(menuItems[position], position == selectedPosition)
    }

    override fun getItemCount(): Int = menuItems.size

    fun setViewSelected(position: Int, isSelected: Boolean) {
        selectedPosition = if (isSelected) position else -1
        notifyDataSetChanged()
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.menu_item_text)

        fun bind(menuItem: String, isSelected: Boolean) {
            textView.text = menuItem
            // Update UI based on selection state
            itemView.setBackgroundColor(if (isSelected) 0xFFE0E0E0.toInt() else 0xFFFFFF) // Example color
        }
    }

    // Implementing Adapter interface methods
    override fun registerDataSetObserver(observer: DataSetObserver?) {
        // No-op, not needed for RecyclerView
    }

    override fun unregisterDataSetObserver(observer: DataSetObserver?) {
        // No-op, not needed for RecyclerView
    }

    override fun getCount(): Int = menuItems.size

    override fun getItem(position: Int): Any = menuItems[position]

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val holder = onCreateViewHolder(parent ?: throw IllegalArgumentException("Parent cannot be null"), 0)
        onBindViewHolder(holder, position)
        return holder.itemView
    }

    override fun getViewTypeCount(): Int = 1 // You can adjust this if you have different view types

    override fun isEmpty(): Boolean = menuItems.isEmpty()
}
