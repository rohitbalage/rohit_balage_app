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
import com.rrbofficial.rohitbalage.MyBaseActivity
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
        // Inflate the layout
        _binding = FragmentGithubBinding.inflate(inflater, container, false)

        // Initialize ViewModel
        githubViewModel = ViewModelProvider(this).get(GithubViewModel::class.java)

        // Observe loading state
        githubViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            val activity = requireActivity() as? MyBaseActivity
            activity?.let {
                if (isLoading) it.showProgressBar() else it.hideProgressBar()
            }
        }

        // Configure WebView
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true
            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean = false
            }

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    if (newProgress < 100) githubViewModel.setLoading(true)
                    else githubViewModel.setLoading(false)
                }
            }

            loadUrl("https://github.com/rohitbalage?tab=repositories")
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}