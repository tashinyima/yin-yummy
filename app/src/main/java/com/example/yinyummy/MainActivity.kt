package com.example.yinyummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.yinyummy.appInit.AppInitializer
import com.example.yinyummy.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appinitializer: AppInitializer

    private lateinit var activityBinder: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityBinder = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initApp()
        toolbar = activityBinder.toolbar
        setSupportActionBar(toolbar)
        setupBottomNavigation()
    }

    private fun initApp() {

        val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
            throwable.printStackTrace()
            Log.i("AppCrash", throwable.message.toString())
        }
        GlobalScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
            appinitializer.initializeApp()

            Log.i("AppCrash", coroutineExceptionHandler.toString())

        }
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