package com.treebricks.hrmanagement

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreenActivity : AppCompatActivity() {

    private val delay = 2000L
    private val handler = Handler()
    private val launcher = Launcher()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
    }

    override fun onStart() {
        super.onStart()
        handler.postDelayed(launcher, delay)
    }

    override fun onStop() {
        handler.removeCallbacks(launcher)
        super.onStop()
    }

    private fun launch() {
        if (!isFinishing) {
            startActivity(Intent(this@SplashScreenActivity, LoginActivity::class.java))
            finish()
        }
    }

    inner class Launcher : Runnable {
        override fun run() {
            launch()
        }
    }
}
