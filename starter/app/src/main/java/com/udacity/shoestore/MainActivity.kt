package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        Timber.plant(Timber.DebugTree())
        Timber.i("onCreate")
        val navController = findNavController(R.id.navHostFragment)
        setSupportActionBar(binding.toolbar)
        NavigationUI.setupActionBarWithNavController(this, navController)

        shoeViewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navHostFragment)
        return navController.navigateUp()
    }
}
