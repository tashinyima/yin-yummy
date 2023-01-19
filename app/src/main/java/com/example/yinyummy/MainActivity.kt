package com.example.yinyummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.yinyummy.appInit.AppInitializer
import com.example.yinyummy.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var appInitializer: AppInitializer

    private lateinit var activityBinder: ActivityMainBinding
    private lateinit var navController: NavController
  //  private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityBinder = DataBindingUtil.setContentView(this, R.layout.activity_main)
       // toolbar = activityBinder.toolbar
       // setSupportActionBar(toolbar)
        setupBottomNavigation()
        fetchRemoteApiData()

    }

    private fun fetchRemoteApiData() {
        lifecycleScope.launch{
            appInitializer.initializeApp()
        }
    }


    private fun setupBottomNavigation() {

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController

        activityBinder.bottomNavigationView.setupWithNavController(navController)


    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}