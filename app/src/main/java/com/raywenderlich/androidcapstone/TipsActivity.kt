package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raywenderlich.androidcapstone.databinding.ActivityTipsBinding

class TipsActivity : AppCompatActivity() {
    private lateinit var activityTipsBinding: ActivityTipsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityTipsBinding = ActivityTipsBinding.inflate(layoutInflater)
        setContentView(activityTipsBinding.root)

        activityTipsBinding.btnBackTips.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}