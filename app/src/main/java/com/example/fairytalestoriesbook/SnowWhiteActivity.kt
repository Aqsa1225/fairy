package com.example.fairytalestoriesbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class SnowWhiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snow_white)

        // Set up toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show back button
        supportActionBar?.title = "Snow White" // Set toolbar title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Navigate back when the back button is pressed
        return true
    }
}