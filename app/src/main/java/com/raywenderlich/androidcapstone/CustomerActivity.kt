package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.raywenderlich.androidcapstone.ap2.ApiInterface
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import com.raywenderlich.androidcapstone.data.LoginDataSource
import com.raywenderlich.androidcapstone.databinding.ActivityCustomerBinding
import kotlinx.android.synthetic.main.activity_customer.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CustomerActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private lateinit var activityCustomerBinding: ActivityCustomerBinding
    private lateinit var customerResponse: List<CustomerResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        activityCustomerBinding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(activityCustomerBinding.root)

        val username = intent.getStringExtra("username").toString()
        val service = ApiInterface.create()
        val call2: Call<List<CustomerResponse>> = service.fetchListLogin(username)
        call2.enqueue(object: Callback<List<CustomerResponse>>{
            override fun onResponse(call: Call<List<CustomerResponse>>, response: Response<List<CustomerResponse>>
            ) {
                val response = response.body()
                //Log.d("Customer API Response",response.toString())
                if (response != null) {
                    txtActCustName.text = "Customer Name: " + response[0].firstName.toString() + " " + response[0].lastName.toString()
                    txtActCustEmail.text = "Email: " + response[0].email.toString()
                }
            }

            override fun onFailure(call: Call<List<CustomerResponse>>, t: Throwable) {
                t.message?.let { Log.d("Error", it) }
            }
        })

        activityCustomerBinding.btnCustHome.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        activityCustomerBinding.btnAutoInsur.setOnClickListener {
            val intent = Intent(this,AutoInsurActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            finish()
        }

        activityCustomerBinding.btnHomeInsur.setOnClickListener {
            val intent = Intent(this,HomeInsurActivity::class.java)
            intent.putExtra("username",username)
            startActivity(intent)
            finish()
        }

    }
}