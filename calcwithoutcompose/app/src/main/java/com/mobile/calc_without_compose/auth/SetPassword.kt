package com.mobile.calc_without_compose.auth

import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.mobile.calc_without_compose.MainActivity
import com.mobile.calc_without_compose.R


class SetPassword: AppCompatActivity() {
    lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_password)

        val passwordView = findViewById<EditText>(R.id.password)
        val save = findViewById<Button>(R.id.save)
        save.setOnClickListener {
                val password = passwordView.getText().toString()

                if (password.isEmpty()) {
                    passwordView.error = "Password required"
                    return@setOnClickListener
                }

                if (password.contains(" ")) {
                    passwordView.error = "Don't support space"
                    return@setOnClickListener
                }

                if (password.length < 4 || password.length > 4) {
                    passwordView.error = "Support 4 digint password"
                    return@setOnClickListener
                }

            ref.get().addOnSuccessListener {
                if (it.value == null) {
                    ref.setValue(password)
                    sendToMain()
                    return@addOnSuccessListener
                }
                if (it.value == password) {
                    sendToMain()
                } else {
                    passwordView.error = "Not correct password!"
                }
            }.addOnFailureListener{
                Log.e("firebase", "Error getting data", it)
                Toast.makeText(this@SetPassword, "Cannot get data from database: $it", Toast.LENGTH_SHORT).show()
            }
            }
    }

    override fun onResume() {
        super.onResume()
        ref = Firebase.database.getReference("${Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)}/password")
    }

    private fun sendToMain() {
        val mainIntent = Intent(
            this@SetPassword,
            MainActivity::class.java
        )
        mainIntent.putExtra("isAuthorized", true)
        startActivity(mainIntent)
        finish()
    }
}