package com.example.fairytalestoriesbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class BeautyBeastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beauty_beast)

        // Set up toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) // Show back button
        supportActionBar?.title = "Beauty and the Beast" // Set toolbar title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Navigate back when the back button is pressed
        return true
    }
}
