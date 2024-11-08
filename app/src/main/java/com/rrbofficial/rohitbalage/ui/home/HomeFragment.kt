package com.rrbofficial.rohitbalage.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rrbofficial.rohitbalage.databinding.FragmentHomeBinding
import com.youth.banner.Banner
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.transformer.AlphaPageTransformer
import com.youth.banner.transformer.DepthPageTransformer
import com.youth.banner.transformer.RotateDownPageTransformer
import com.youth.banner.transformer.RotateYTransformer
import com.youth.banner.transformer.ScaleInTransformer
import com.youth.banner.transformer.ZoomOutPageTransformer

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        setupBanner()
        return root
    }

    private fun setupBanner() {
        // Example images
        val imageUrls = listOf(
            "https://iili.io/2IKnqZb.jpg",
            "https://iili.io/2IKnKue.jpg",
            "https://iili.io/2IKnCnj.jpg",
            "https://iili.io/2IKnfwu.jpg",
            "https://iili.io/2IKnnMx.jpg"
        )

        val banner = binding.banner
        banner.setAdapter(BannerImageAdapter(imageUrls)) // Your custom adapter
            .addBannerLifecycleObserver(viewLifecycleOwner) // Auto-manage lifecycle
            .setIndicator(CircleIndicator(requireContext())) // Add circle indicator
            .setIndicatorGravity(IndicatorConfig.Direction.CENTER) // Center indicator
//            .setPageTransformer(ScaleInTransformer())
//        banner.setPageTransformer(AlphaPageTransformer())
//        banner.setPageTransformer(DepthPageTransformer())
//        banner.setPageTransformer(ZoomOutPageTransformer())
//        banner.setPageTransformer(RotateYTransformer())
//        banner.setPageTransformer(RotateDownPageTransformer())



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
