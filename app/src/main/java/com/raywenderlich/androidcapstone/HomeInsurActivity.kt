package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.androidcapstone.ap2.ApiInterface
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import com.raywenderlich.androidcapstone.databinding.ActivityHomeInsuranceBinding
import kotlinx.android.synthetic.main.activity_home_insurance.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeInsurActivity : AppCompatActivity() {

    private lateinit var activityHomeInsurBinding: ActivityHomeInsuranceBinding

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

        val service = ApiInterface.create()
        val call2: Call<List<CustomerResponse>> = service.fetchListLogin(username)
        call2.enqueue(object: Callback<List<CustomerResponse>>{
            override fun onResponse(call: Call<List<CustomerResponse>>, response: Response<List<CustomerResponse>>
            ) {
                val response = response.body()
                //Log.d("SampleLogin",response.toString())
                //apiUsername = response?.get(0)?.email.toString()
                //apiPassword = response?.get(0)?.password.toString()
                //apiUser = response?.get(0)?.firstName.toString()
                //Log.d("Inside Username",apiUsername)

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

            override fun onFailure(call: Call<List<CustomerResponse>>, t: Throwable) {
                t.message?.let { Log.d("Error", it) }
            }
        })
    }
}