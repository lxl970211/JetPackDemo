package com.bx.like

import android.bluetooth.BluetoothHealthAppConfiguration
import android.content.Intent
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private lateinit var appConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        navController = Navigation.findNavController(this, R.id.nav_home)

        appConfiguration = AppBarConfiguration(navGraph = navController.graph)

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appConfiguration)
        navigation.setupWithNavController(navController)

    }

    override fun navigateUpTo(upIntent: Intent?): Boolean {
        return navController.navigateUp(appConfiguration) || super.navigateUpTo(upIntent)
    }
}
