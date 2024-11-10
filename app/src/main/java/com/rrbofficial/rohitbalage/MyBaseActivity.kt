package com.rrbofficial.rohitbalage

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

abstract class MyBaseActivity : AppCompatActivity() {

    private var progressDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Additional setup for all activities can go here
    }

    /**
     * Show the global progress bar
     */
    fun showProgressBar() {
        if (progressDialog?.isShowing == true) return // Avoid showing multiple dialogs

        progressDialog = Dialog(this).apply {
            setCancelable(false) // Prevent back press
            setContentView(LayoutInflater.from(this@MyBaseActivity).inflate(R.layout.global_progress_bar, null))
            window?.setBackgroundDrawableResource(android.R.color.transparent) // Transparent background
            show()
        }
    }

    fun logEvent(tag: String, message: String) {
        // Add centralized logging logic here
        android.util.Log.d(tag, message)
    }


    fun showSnackBar(message: String) {
        val rootView = window.decorView.findViewById<View>(android.R.id.content)
        Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).show()
    }

    /**
     * Hide the global progress bar
     */
    fun hideProgressBar() {
        progressDialog?.dismiss()
        progressDialog = null
    }
}
