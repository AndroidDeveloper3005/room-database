package com.himel.androiddeveloper3005.git.roomdatabase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.himel.androiddeveloper3005.git.roomdatabase.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupActionBarWithNavController(findNavController(R.id.fragment))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navControl = findNavController(R.id.fragment)
        return navControl.navigateUp() || super.onSupportNavigateUp()
    }
}