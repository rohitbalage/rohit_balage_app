package com.rrbofficial.rohitbalage

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.amazonaws.mobile.client.AWSMobileClient
import com.amazonaws.mobile.client.Callback
import com.amazonaws.mobile.client.UserStateDetails
import com.rrbofficial.rohitbalage.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : MyBaseActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val navController by lazy { findNavController(R.id.nav_host_fragment) }  // Correctly using `val`

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        // Initialize AWS Mobile Client
//        AWSMobileClient.getInstance().initialize(this, object : Callback<UserStateDetails> {
//            override fun onResult(result: UserStateDetails?) {
//                Log.d("AWS", "AWSMobileClient initialized: ${result?.userState}")
//            }
//
//            override fun onError(e: Exception?) {
//                Log.e("AWS", "Initialization error", e)
//            }
//        })

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Set up Bottom Navigation with the same NavController
        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNav.itemIconTintList = null  // Optional: Set to null to disable icon tint
        bottomNav.setupWithNavController(navController)  // Link Bottom Navigation with NavController

        // Handle Bottom Navigation Item Clicks
        bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    navController.navigate(R.id.nav_home)
                    true
                }
                R.id.nav_github -> {
                    navController.navigate(R.id.nav_github)
                    true
                }
                R.id.nav_projects -> {
                    navController.navigate(R.id.nav_projects)
                    true
                }
                R.id.nav_achievements -> {
                    navController.navigate(R.id.nav_achievements)
                    true
                }
                R.id.nav_youtube -> {
                    navController.navigate(R.id.nav_youtube)
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.notification_icon -> {
                Toast.makeText(this, "Notification Icon Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}