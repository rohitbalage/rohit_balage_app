package com.rrbofficial.rohitbalage

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rrbofficial.rohitbalage.databinding.ActivityMainBinding
import nl.psdcompany.duonavigationdrawer.views.DuoDrawerLayout
import nl.psdcompany.duonavigationdrawer.views.DuoMenuView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DuoDrawerLayout
    private lateinit var menuView: DuoMenuView
    private lateinit var toolbar: Toolbar
    private lateinit var drawerToggle: DuoDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // Ensure this matches your layout XML file

        // Initialize the DuoDrawerLayout and Toolbar
        drawerLayout = findViewById(R.id.drawer)
        toolbar = findViewById(R.id.toolbar)

        // Set up the toolbar
        setSupportActionBar(toolbar)

        // Set up the DuoDrawerToggle
        drawerToggle = DuoDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )

        // Attach the drawer toggle to the drawer layout
        drawerLayout.setDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Initialize the menu view directly from findViewById
        menuView = findViewById(R.id.menu_view)

        // Create a list of menu options
        val menuItems = listOf("Home", "Profile", "Settings", "Help", "About")

        // Set up the menu adapter
        val menuAdapter = MenuAdapter(menuItems)
        menuView.adapter = menuAdapter

        // Set up click listeners for the menu view
        menuView.setOnMenuClickListener(object : DuoMenuView.OnMenuClickListener {
            override fun onFooterClicked() {
                Toast.makeText(this@MainActivity, "Footer clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onHeaderClicked() {
                Toast.makeText(this@MainActivity, "Header clicked", Toast.LENGTH_SHORT).show()
            }

            override fun onOptionClicked(position: Int, objectClicked: Any) {
                menuAdapter.setViewSelected(position, true) // Highlight selected option

                // Handle navigation based on selected menu item
                when (position) {
                    0 -> Toast.makeText(this@MainActivity, "Home clicked", Toast.LENGTH_SHORT).show()
                    1 -> Toast.makeText(this@MainActivity, "Profile clicked", Toast.LENGTH_SHORT).show()
                    2 -> Toast.makeText(this@MainActivity, "Settings clicked", Toast.LENGTH_SHORT).show()
                    3 -> Toast.makeText(this@MainActivity, "Help clicked", Toast.LENGTH_SHORT).show()
                    4 -> Toast.makeText(this@MainActivity, "About clicked", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen) {
            drawerLayout.closeDrawer() // Close the drawer if it’s open
        } else {
            super.onBackPressed() // Otherwise, handle the back press as normal
        }
    }

    // Optional: Method to open/close the drawer programmatically
    fun openDrawer() {
        drawerLayout.openDrawer()
    }

    fun closeDrawer() {
        drawerLayout.closeDrawer()
    }
}