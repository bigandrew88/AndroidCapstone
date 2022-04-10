package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.androidcapstone.databinding.ActivityAutoInsurBinding
import com.raywenderlich.androidcapstone.test.SharedViewModel
import kotlinx.android.synthetic.main.activity_auto_insur.*
import kotlinx.android.synthetic.main.activity_home_insurance.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AutoInsurActivity : AppCompatActivity() {

    private lateinit var activityAutoInsurBinding: ActivityAutoInsurBinding
    val viewModel: SharedViewModel by lazy{
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

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
                txtAutoMake.text = "City: " + response?.get(0)?.autos?.get(0)?.make.toString()
                txtAutoModel.text = "Date Built: " + response?.get(0)?.autos?.get(0)?.model.toString()
                txtAutoDateMade.text = "Heating Type: " + response?.get(0)?.autos?.get(0)?.dateMade.toString()
                txtAutoPolicySD.text = "Policy Start Date: " + response?.get(0)?.autos?.get(0)?.autoPolicy?.autoPolicyStartDate.toString()
                txtAutoPolicyED.text = "Policy End Date: " + response?.get(0)?.autos?.get(0)?.autoPolicy?.autoPolicyEndDate.toString()
                txtAutoPolicyPrem.text = "Policy Premium: " + response?.get(0)?.autos?.get(0)?.autoPolicy?.autoPolicyPremium.toString()
            }
        }
    }
}