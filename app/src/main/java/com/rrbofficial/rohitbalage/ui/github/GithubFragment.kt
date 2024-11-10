package com.rrbofficial.rohitbalage.ui.github

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.rrbofficial.rohitbalage.R
import com.rrbofficial.rohitbalage.databinding.FragmentGithubBinding

class GithubFragment : Fragment() {
    private var _binding: FragmentGithubBinding? = null
    private val binding get() = _binding!!

    private lateinit var githubViewModel: GithubViewModel

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout using data binding
        _binding = FragmentGithubBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Initialize the ViewModel
        githubViewModel = ViewModelProvider(this).get(GithubViewModel::class.java)

        // Load the header fragment into the FrameLayout
        childFragmentManager.commit {
            replace(R.id.headerFragmentContainer, GithubHeaderFragment())
        }

        // Configure the WebView
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean {
                    return false // Allow URL loading within WebView
                }
            }
            webChromeClient = WebChromeClient() // For advanced WebView features
            loadUrl("https://github.com/rohitbalage?tab=repositories")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}