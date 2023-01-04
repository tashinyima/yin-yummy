package com.example.yinyummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.yinyummy.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityBinder: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinder = DataBindingUtil.setContentView(this,R.layout.activity_main)
        toolbar = activityBinder.toolbar
        setSupportActionBar(toolbar)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        val botomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        // links navcontroller with bottom navigation view
        botomNav.setupWithNavController(navController)
        // sets up actionbar with nav see title changes
        setupActionBarWithNavController(navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}