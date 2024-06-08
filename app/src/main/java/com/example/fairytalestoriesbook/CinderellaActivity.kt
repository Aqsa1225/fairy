package com.example.fairytalestoriesbook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class CinderellaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cinderella)

        // Set up toolbar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //  Back button
        supportActionBar?.title = "Cinderella" // Set toolbar title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed() // Navigate back when the back button is pressed
        return true
    }
}