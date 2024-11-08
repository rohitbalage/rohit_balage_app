package com.rrbofficial.rohitbalage

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.rrbofficial.rohitbalage.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        navView.itemIconTintList = null
        val navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_youtube, R.id.nav_achievements
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Handle navigation drawer item clicks
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> {
                    Toast.makeText(this, "Home Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_home)
                    drawerLayout.closeDrawers() // Close the drawer after selection
                    true
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this, "Gallery Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_gallery)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_slideshow -> {
                    Toast.makeText(this, "Slideshow Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_slideshow)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_youtube -> {
                    Toast.makeText(this, "YouTube Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_youtube)
                    drawerLayout.closeDrawers()
                    true
                }
                R.id.nav_achievements -> {
                    Toast.makeText(this, "Achievements Selected", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.nav_achievements)
                    drawerLayout.closeDrawers()
                    true
                }
                else -> false
            }
        }


        val fab = binding.appBarMain.fab
        fab.imageTintList = null
        binding.appBarMain.fab.setOnClickListener {
            // Handle the FAB click
            Toast.makeText(this, "FAB Clicked", Toast.LENGTH_SHORT).show()
            // You can also add navigation or other actions here
        }

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation)
       bottomNav.itemIconTintList = null
        bottomNav.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu) // Inflate the menu
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.notification_icon -> {
                Toast.makeText(this, "Notification Icon Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item -> {
                Toast.makeText(this, "Menu Icon Clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
