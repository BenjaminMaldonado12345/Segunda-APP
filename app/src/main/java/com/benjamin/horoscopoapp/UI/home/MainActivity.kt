package com.benjamin.horoscopoapp.UI.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.benjamin.horoscopoapp.R
import com.benjamin.horoscopoapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

    private fun initUI(){
        initNavegation()
    }

    private fun initNavegation(){
        val NavHost = supportFragmentManager.findFragmentById(R.id.fragmentContaierView) as NavHostFragment
        navController = NavHost.navController
        binding.bottomBar.setupWithNavController(navController)
    }
}