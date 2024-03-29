package com.mobile.calc_without_compose

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({

            val i = Intent(
                this@SplashScreenActivity,
                MainActivity::class.java
            )
            startActivity(i)

            finish()
        }, 2000)
    }
}
