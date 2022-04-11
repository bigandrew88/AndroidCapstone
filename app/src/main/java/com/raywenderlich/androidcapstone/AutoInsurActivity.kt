package com.raywenderlich.androidcapstone

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.androidcapstone.databinding.ActivityAutoInsurBinding
import com.raywenderlich.androidcapstone.projectapi.SharedViewModel
import kotlinx.android.synthetic.main.activity_auto_insur.*

class AutoInsurActivity : AppCompatActivity() {

    private lateinit var activityAutoInsurBinding: ActivityAutoInsurBinding
    val viewModel: SharedViewModel by lazy{
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auto_insur)

        activityAutoInsurBinding = ActivityAutoInsurBinding.inflate(layoutInflater)
        setContentView(activityAutoInsurBinding.root)

        activityAutoInsurBinding.btnBackAutoInsur.setOnClickListener {
            val intent = Intent(this,CustomerActivity::class.java)
            startActivity(intent)
            finish()
        }
        val username = intent.getStringExtra("username").toString()
        viewModel.refreshCustomer(username)
        viewModel.customerLiveData.observe(this@AutoInsurActivity){ response ->
            if(response == null){
                Log.d("Test","API Failed")
                Toast.makeText(
                    this@AutoInsurActivity,
                    "Unsuccessful network call",
                    Toast.LENGTH_LONG
                ).show()
                return@observe
            }else{
                //Log.d("Test","API Clear")
                txtAutoMake.text = "Make: " + response[0].autos[0].make
                txtAutoModel.text = "Model: " + response[0].autos[0].model
                txtAutoDateMade.text = "Date Manufactured: " + response[0].autos[0].dateMade
                txtAutoPolicySD.text = "Policy Start Date: " + response[0].autos[0].autoPolicy.autoPolicyStartDate
                txtAutoPolicyED.text = "Policy End Date: " + response[0].autos[0].autoPolicy.autoPolicyEndDate
                txtAutoPolicyPrem.text = "Policy Premium: " + response[0].autos[0].autoPolicy.autoPolicyPremium
            }
        }
    }
}