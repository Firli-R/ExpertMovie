package com.example.expertmovie.main

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.expertmovie.R


class SplashScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        supportActionBar?.hide()

        val midAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation)
        val botAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)


        val mtv: ImageView = findViewById(R.id.dota2)
        val btv: TextView = findViewById(R.id.botTextView)


        mtv.startAnimation(midAnimation)
        btv.startAnimation(botAnimation)

        val timeout = 4000
        val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(intent)
            finish()
        },timeout.toLong())

    }
}