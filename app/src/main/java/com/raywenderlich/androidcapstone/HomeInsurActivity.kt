package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.androidcapstone.databinding.ActivityHomeInsuranceBinding
import com.raywenderlich.androidcapstone.API.SharedViewModel
import kotlinx.android.synthetic.main.activity_home_insurance.*

class HomeInsurActivity : AppCompatActivity() {

    private lateinit var activityHomeInsurBinding: ActivityHomeInsuranceBinding
    val viewModel: SharedViewModel by lazy{
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_insurance)

        activityHomeInsurBinding = ActivityHomeInsuranceBinding.inflate(layoutInflater)
        setContentView(activityHomeInsurBinding.root)

        activityHomeInsurBinding.btnBackHomeInsur.setOnClickListener {
            val intent = Intent(this,CustomerActivity::class.java)
            startActivity(intent)
            finish()
        }

        val username = intent.getStringExtra("username").toString()
        viewModel.refreshCustomer(username)
        viewModel.customerLiveData.observe(this@HomeInsurActivity){ response ->
            if(response == null){
                Log.d("Test","API Failed")
                Toast.makeText(
                    this@HomeInsurActivity,
                    "Unsuccessful network call",
                    Toast.LENGTH_LONG
                ).show()
                return@observe
            }else{
                //Log.d("Test","API Clear")
                txtHomeCity.text = "City: " + response?.get(0)?.homes?.get(0)?.city.toString()
                txtHomeDateBuilt.text = "Date Built: " + response?.get(0)?.homes?.get(0)?.dateBuilt.toString()
                txtHomeHeatType.text = "Heating Type: " + response?.get(0)?.homes?.get(0)?.heatingType.toString()
                txtHomeLocation.text = "Location: " + response?.get(0)?.homes?.get(0)?.location.toString()
                txtHomePostal.text = "Postal Code: " + response?.get(0)?.homes?.get(0)?.postalcode.toString()
                txtHomeAddress.text = "Address: " + response?.get(0)?.homes?.get(0)?.streetNumber.toString() + " " + response?.get(0)?.homes?.get(0)?.streetName.toString()
                txtHomePolicySD.text = "Policy Start Date: " + response?.get(0)?.homes?.get(0)?.homePolicy?.homePolicyStartDate.toString()
                txtHomePolicyED.text = "Policy End Date: " + response?.get(0)?.homes?.get(0)?.homePolicy?.homePolicyEndDate.toString()
                txtHomePolicyPrem.text = "Policy Premium: " + response?.get(0)?.homes?.get(0)?.homePolicy?.homePolicyPremium.toString()
            }
        }
    }
}