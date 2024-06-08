package com.example.fairytalestoriesbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

class StoriesListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stories_list)

        showInstructionDialog()

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true) //  Back button in toolbar

        // Set the user's name in the TextView
        val userNameTextView: TextView = findViewById(R.id.userNameTextView)
        val sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val userName = sharedPreferences.getString("name", "User")
        userNameTextView.text = "Welcome, $userName!"

        // Find the ImageView for Cinderella
        val cinderellaImage = findViewById<ImageView>(R.id.story1Image)

        // Set OnClickListener for Cinderella ImageView
        cinderellaImage.setOnClickListener {
            // Navigate to the Cinderella Activity
            val intent = Intent(this, CinderellaActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView for Snow White
        val snowWhiteImage = findViewById<ImageView>(R.id.story2Image)

        // Set OnClickListener for Snow White ImageView
        snowWhiteImage.setOnClickListener {
            // Navigate to the Snow White Activity
            val intent = Intent(this, SnowWhiteActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView for Sleeping Beauty
        val sleepingBeautyImage = findViewById<ImageView>(R.id.story3Image)

        // Set OnClickListener for Sleeping Beauty ImageView
        sleepingBeautyImage.setOnClickListener {
            // Navigate to the Sleeping Beauty Activity
            val intent = Intent(this, SleepingBeautyActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView for Beauty and the Beast.
        val beautyBeastImage = findViewById<ImageView>(R.id.story4Image)

        // Set OnClickListener for Beauty and the Beast ImageView
        beautyBeastImage.setOnClickListener {
            // Navigate to the Beauty and the Beast Activity
            val intent = Intent(this, BeautyBeastActivity::class.java)
            startActivity(intent)
        }

        // Find the ImageView for Little Red Riding Hood
        val littleRedRidingHoodImage = findViewById<ImageView>(R.id.story5Image)

        // Set OnClickListener for Little Red Riding Hood ImageView
        littleRedRidingHoodImage.setOnClickListener {
            // Navigate to the Little Red Riding Hood Activity
            val intent = Intent(this, LittleRedRidingHoodActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> { // Handle back button click
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showInstructionDialog() {
        val instructionDialog = InstructionDialogFragment()
        instructionDialog.show(supportFragmentManager, "InstructionDialog")
    }
}
