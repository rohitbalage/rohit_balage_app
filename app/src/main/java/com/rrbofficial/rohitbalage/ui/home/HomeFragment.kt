package com.rrbofficial.rohitbalage.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.rrbofficial.rohitbalage.R
import com.rrbofficial.rohitbalage.databinding.FragmentHomeBinding
import com.youth.banner.indicator.CircleIndicator

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val gridData = listOf(
        GridPojo("Mobile", R.drawable.house_icon_nav),
        GridPojo("Internet", R.drawable.house_icon_nav),
        GridPojo("WiFi", R.drawable.house_icon_nav),
        GridPojo("Database", R.drawable.house_icon_nav),
        GridPojo("Battery", R.drawable.house_icon_nav),
        GridPojo("Alarm", R.drawable.house_icon_nav),
        GridPojo("Signal", R.drawable.house_icon_nav),
        GridPojo("Bluetooth", R.drawable.house_icon_nav),
        GridPojo("Monitor", R.drawable.house_icon_nav),
        GridPojo("Wallpaper", R.drawable.house_icon_nav)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupBanner()
        setupRecyclerView()
        return root
    }

    private fun setupBanner() {
        val imageUrls = listOf(
            "https://iili.io/2IKnqZb.jpg",
            "https://iili.io/2IKnKue.jpg",
            "https://iili.io/2IKnCnj.jpg",
            "https://iili.io/2IKnfwu.jpg",
            "https://iili.io/2IKnnMx.jpg"
        )

        val banner = binding.banner
        banner.setAdapter(BannerImageAdapter(imageUrls))
            .addBannerLifecycleObserver(viewLifecycleOwner)
            .setIndicator(CircleIndicator(requireContext()))
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.recyclerViewGrid
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        recyclerView.adapter = GridAdapter(gridData)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
