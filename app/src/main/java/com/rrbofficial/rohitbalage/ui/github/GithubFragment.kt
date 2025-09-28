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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rrbofficial.rohitbalage.MyBaseActivity
import com.rrbofficial.rohitbalage.R
import com.rrbofficial.rohitbalage.databinding.FragmentGithubBinding

class GithubFragment : Fragment() {
    private var _binding: FragmentGithubBinding? = null
    private val binding get() = _binding!!

    private lateinit var githubViewModel: GithubViewModel
    private var isInitialLoad: Boolean = true // Track initial WebView load

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGithubBinding.inflate(inflater, container, false)

        // Initialize ViewModel
        githubViewModel = ViewModelProvider(this).get(GithubViewModel::class.java)

        // Observe loading state for the initial WebView load
        githubViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            val activity = requireActivity() as? MyBaseActivity
            activity?.let {
                if (isLoading && isInitialLoad) {
                    binding.webView.visibility = View.GONE
                    it.showProgressBar()
                } else {
                    it.hideProgressBar()
                    binding.webView.visibility = View.VISIBLE
                }
            }
        }

        // Setup WebView
        setupWebView(savedInstanceState)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Add GithubHeaderFragment to the FrameLayout
        childFragmentManager.beginTransaction()
            .replace(R.id.headerFragmentContainer, GithubHeaderFragment())
            .commit()
    }

    private fun setupWebView(savedInstanceState: Bundle?) {
        binding.webView.apply {
            settings.javaScriptEnabled = true
            settings.domStorageEnabled = true

            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView,
                    request: WebResourceRequest
                ): Boolean = false

                override fun onPageFinished(view: WebView?, url: String?) {
                    if (isInitialLoad) {
                        githubViewModel.setLoading(false)
                        isInitialLoad = false
                    }
                }
            }

            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView?, newProgress: Int) {
                    if (isInitialLoad && newProgress < 100) {
                        githubViewModel.setLoading(true)
                    }
                }
            }

            // Restore state or load URL
            if (savedInstanceState == null) {
                loadUrl("https://github.com/rohitbalage?tab=repositories")
            } else {
                restoreState(savedInstanceState)
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.webView.saveState(outState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
