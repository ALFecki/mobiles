package com.mobile.calc_without_compose.auth

import android.app.KeyguardManager
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.preference.PreferenceManager
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.database
import com.mobile.calc_without_compose.MainActivity
import com.mobile.calc_without_compose.R


class SetPassword: AppCompatActivity() {
    lateinit var ref : DatabaseReference

    // create a CancellationSignal variable and assign a value null to it
    private var cancellationSignal: CancellationSignal? = null

    // create an authenticationCallback
    private val authenticationCallback: BiometricPrompt.AuthenticationCallback
        get() = @RequiresApi(Build.VERSION_CODES.P)
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                super.onAuthenticationError(errorCode, errString)
                notifyUser("Authentication Error : $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                super.onAuthenticationSucceeded(result)
                notifyUser("Authentication Succeeded")
                sendToMain()

            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_password)

        val passwordView = findViewById<EditText>(R.id.password)
        val save = findViewById<Button>(R.id.save)
        val biometric = findViewById<Button>(R.id.bBiometric)
        val reset = findViewById<Button>(R.id.resetPassword)
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

        checkBiometricSupport()

        reset.setOnClickListener {
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
            ref.setValue(password)
            notifyUser("Password successfully changed!")
            biometric.performClick()
        }
        biometric.setOnClickListener {
            val biometricPrompt = BiometricPrompt.Builder(this)
                .setTitle("Authenticate to Calculator")
                .setSubtitle("Use your fingerprint")
                .setDescription("")
                .setNegativeButton("Cancel", this.mainExecutor, DialogInterface.OnClickListener { dialog, which ->
                    notifyUser("Authentication Cancelled")
                }).build()

            // start the authenticationCallback in mainExecutor
            biometricPrompt.authenticate(getCancellationSignal(), mainExecutor, authenticationCallback)
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

    private fun getCancellationSignal(): CancellationSignal {
        cancellationSignal = CancellationSignal()
        cancellationSignal?.setOnCancelListener {
            notifyUser("Authentication was Cancelled by the user")
        }
        return cancellationSignal as CancellationSignal
    }

    // it checks whether the app the app has fingerprint permission
    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkBiometricSupport(): Boolean {
        val keyguardManager = getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
        if (!keyguardManager.isDeviceSecure) {
            notifyUser("Fingerprint authentication has not been enabled in settings")
            return false
        }
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.USE_BIOMETRIC) != PackageManager.PERMISSION_GRANTED) {
            notifyUser("Fingerprint Authentication Permission is not enabled")
            return false
        }
        return if (packageManager.hasSystemFeature(PackageManager.FEATURE_FINGERPRINT)) {
            true
        } else true
    }

    private fun notifyUser(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}