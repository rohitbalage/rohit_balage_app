package com.rrbofficial.rohitbalage.ui.home

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rrbofficial.rohitbalage.R
import com.rrbofficial.rohitbalage.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Start rotation animation for the update text
        val updateTextView: TextView = binding.root.findViewById(R.id.update_text)
        startRotationAnimation(updateTextView)

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    private fun startRotationAnimation(view: View) {
        val animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f)
        animator.duration = 2000 // Animation duration in milliseconds
        animator.repeatCount = ObjectAnimator.INFINITE // Repeat indefinitely
        animator.start() // Start the animation
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
