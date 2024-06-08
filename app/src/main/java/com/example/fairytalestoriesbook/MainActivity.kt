package com.example.fairytalestoriesbook

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.fairytalestories.UserInfoDialogFragment

class MainActivity : AppCompatActivity(), UserInfoDialogFragment.OnInputListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Show the dialog when the app is opened for the first time
        val sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        if (!sharedPreferences.contains("name") || !sharedPreferences.contains("age")) {
            val userInfoDialog = UserInfoDialogFragment()
            userInfoDialog.show(supportFragmentManager, "UserInfoDialog")
        }

        val startReadingButton: Button = findViewById(R.id.startReadingButton)
        startReadingButton.setOnClickListener {
            // Navigate to StoriesListActivity when the button is clicked
            val intent = Intent(this, StoriesListActivity::class.java)
            startActivity(intent)
        }

        val settingsIcon: ImageView = findViewById(R.id.settingsIcon)
        settingsIcon.setOnClickListener {
            val userInfoDialog = UserInfoDialogFragment()
            userInfoDialog.show(supportFragmentManager, "UserInfoDialog")
        }
    }

    override fun sendInput(name: String, age: String) {
        // Save the input from the dialog in SharedPreferences
        val sharedPreferences = getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name", name)
        editor.putString("age", age)
        editor.apply()

        // Handle the input from the dialog here
        Toast.makeText(this, "Name: $name, Age: $age", Toast.LENGTH_SHORT).show()
    }
}
