package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.raywenderlich.androidcapstone.databinding.ActivityCustomerBinding
import com.raywenderlich.androidcapstone.projectapi.SharedViewModel
import kotlinx.android.synthetic.main.activity_customer.*
import okhttp3.OkHttpClient

class CustomerActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    private lateinit var activityCustomerBinding: ActivityCustomerBinding
    val viewModel: SharedViewModel by lazy{
        ViewModelProvider(this).get(SharedViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        activityCustomerBinding = ActivityCustomerBinding.inflate(layoutInflater)
        setContentView(activityCustomerBinding.root)

        val username = intent.getStringExtra("username").toString()

        viewModel.refreshCustomer(username)
        viewModel.customerLiveData.observe(this@CustomerActivity){ response ->
            if(response == null){
                Log.d("Test","API Failed")
                Toast.makeText(
                    this@CustomerActivity,
                    "Unsuccessful network call",
                    Toast.LENGTH_LONG
                ).show()
                return@observe
            }else{
                //Log.d("Test","API Clear")
                txtActCustName.text = "Customer Name: " + response[0].firstName.toString() + " " + response[0].lastName.toString()
                txtActCustEmail.text = "Email: " + response[0].email.toString()
            }
        }


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