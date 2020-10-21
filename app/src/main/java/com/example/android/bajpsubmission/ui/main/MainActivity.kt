package com.example.android.bajpsubmission.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.bajpsubmission.R
import com.example.android.bajpsubmission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val navView = mainBinding.navView
        val navController = this.findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }
}
