package com.raywenderlich.androidcapstone

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.raywenderlich.androidcapstone.databinding.ActivityContactUsBinding


class ContactUsActivity : AppCompatActivity() {
    private lateinit var activityContactUsBinding: ActivityContactUsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityContactUsBinding = ActivityContactUsBinding.inflate(layoutInflater)
        setContentView(activityContactUsBinding.root)

        activityContactUsBinding.btnBackContactUs.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        activityContactUsBinding.txtContactInfo.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:17091234567")
            startActivity(intent)
        }

        activityContactUsBinding.txtContactInfoEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "plain/text"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("quote@taylorinsurance.com"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Question")
            intent.putExtra(Intent.EXTRA_TEXT, "Hello, I Have a question!")
            startActivity(Intent.createChooser(intent, ""))
        }
    }
}