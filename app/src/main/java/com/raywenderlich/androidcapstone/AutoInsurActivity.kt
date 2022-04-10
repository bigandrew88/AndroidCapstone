package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.androidcapstone.ap2.ApiInterface
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import com.raywenderlich.androidcapstone.databinding.ActivityAutoInsurBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AutoInsurActivity : AppCompatActivity() {

    private lateinit var activityAutoInsurBinding: ActivityAutoInsurBinding


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