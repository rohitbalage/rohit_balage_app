package com.rrbofficial.rohitbalage.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rrbofficial.rohitbalage.databinding.ItemGridBinding

data class GridPojo(val title: String, val imageRes: Int)

class GridAdapter(private val data: List<GridPojo>) : RecyclerView.Adapter<GridAdapter.GridViewHolder>() {

    inner class GridViewHolder(private val binding: ItemGridBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GridPojo) {
            binding.gridtitle.text = item.title
            binding.gridimage.setImageResource(item.imageRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val binding = ItemGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size
}
