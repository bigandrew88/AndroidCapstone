package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.raywenderlich.androidcapstone.ap2.ApiInterface
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        activityCustomerBinding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(activityCustomerBinding.root)

        val service = ApiInterface.create()
        var custNum1 = LoginDataSource()
        var custlogin: String = intent.getStringExtra("Username").toString()
        Log.d("test",custlogin)
        val call2: Call<JsonObject> = service.fetchFact()
        call2.enqueue(object : Callback<JsonObject> {

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val response = response.body()

                val firstName = response?.get("firstName")
                val lastName = response?.get("lastName")
                val email = response?.get("email")

                txtActCustName.text = "Customer Name: $firstName $lastName"
                txtActCustEmail.text = "Email: $email"
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
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
            startActivity(intent)
            finish()
        }

        activityCustomerBinding.btnHomeInsur.setOnClickListener {
            val intent = Intent(this,HomeInsurActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}