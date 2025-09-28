package com.rrbofficial.rohitbalage.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rrbofficial.rohitbalage.R

class SettingsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        recyclerView = view.findViewById(R.id.recycler_settings)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val items = listOf(
            SettingsItem(R.drawable.facebookicon, "Facebook"),
            SettingsItem(R.drawable.instagram_social, "Instagram"),
            SettingsItem(R.drawable.xicon, "X (Twitter)"),
            SettingsItem(R.drawable.youtube_icon, "YouTube"),
            SettingsItem(R.drawable.trophy_icon, "Achievements"),
            SettingsItem(R.drawable.photosicon, "My Photos"),
            SettingsItem(R.drawable.dark_mode, "Dark Mode", hasToggle = true)
        )

        recyclerView.adapter = SettingsAdapter(items) { item ->
            // Handle item clicks
        }

        return view
    }
}
