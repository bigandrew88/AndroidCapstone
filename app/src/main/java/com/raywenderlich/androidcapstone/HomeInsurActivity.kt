package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.androidcapstone.ap2.ApiInterface
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import com.raywenderlich.androidcapstone.databinding.ActivityHomeInsuranceBinding
import com.raywenderlich.androidcapstone.test.APIClient
import com.raywenderlich.androidcapstone.test.APIInterface
import com.raywenderlich.androidcapstone.test.MultipleResource
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
            }

            override fun onFailure(call: Call<List<CustomerResponse>>, t: Throwable) {
                t.message?.let { Log.d("Error", it) }
            }
        })
    }
}