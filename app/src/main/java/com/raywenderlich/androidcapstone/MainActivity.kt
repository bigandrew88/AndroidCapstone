package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.androidcapstone.databinding.ActivityMainBinding
import com.raywenderlich.androidcapstone.login.LoginActivity


class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnLoginMain.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        activityMainBinding.btnContactUs.setOnClickListener {
            val intent = Intent(this,ContactUsActivity::class.java)
            startActivity(intent)
            finish()
        }

        activityMainBinding.btnTips.setOnClickListener {
            val intent = Intent(this,TipsActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}