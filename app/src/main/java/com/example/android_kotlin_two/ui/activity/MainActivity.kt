package com.example.android_kotlin_two.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.android_kotlin_two.R
import com.example.android_kotlin_two.databinding.ActivityMainBinding
import com.example.android_kotlin_two.util.SharedPrefer

class MainActivity : AppCompatActivity() {

    private lateinit var controllerNav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        controllerNav = navHostFragment.navController

        when (SharedPrefer.isShows) {
            true -> {
                controllerNav.navigate(R.id.firstFragment2)
            }
            else -> {
                controllerNav.navigate(R.id.homeFragment)
            }
        }
    }
}