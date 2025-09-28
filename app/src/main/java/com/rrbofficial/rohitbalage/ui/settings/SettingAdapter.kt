package com.rrbofficial.rohitbalage.ui.settings

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rrbofficial.rohitbalage.R

class SettingsAdapter(
    private val items: List<SettingsItem>,
    private val onItemClick: (SettingsItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.item_icon)
        val title: TextView = view.findViewById(R.id.item_title)
        val toggle: Switch = view.findViewById(R.id.item_toggle)

        fun bind(item: SettingsItem) {
            icon.setImageResource(item.iconRes)
            title.text = item.title

            if (item.hasToggle) {
                toggle.visibility = View.VISIBLE
            } else {
                toggle.visibility = View.GONE
            }

            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_settings, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ItemViewHolder).bind(items[position])
    }
}
