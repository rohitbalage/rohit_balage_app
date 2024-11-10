package com.rrbofficial.rohitbalage.ui.github

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GithubViewModel: ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    // Track if the page is fully loaded
    var isPageLoaded: Boolean = false

    /**
     * Sets the loading state.
     */
    fun setLoading(loading: Boolean) {
        _isLoading.value = loading
    }
}