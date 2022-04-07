package com.raywenderlich.androidcapstone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.raywenderlich.androidcapstone.databinding.ActivityAutoInsurBinding
import com.raywenderlich.androidcapstone.test.APIClient
import com.raywenderlich.androidcapstone.test.APIInterface
import com.raywenderlich.androidcapstone.test.MultipleResource
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

        val apiInterface = APIClient().getClient()?.create<APIInterface>(APIInterface::class.java)

        /**
         * GET List Resources
         */
        val call: Call<MultipleResource?>? = apiInterface!!.doGetListResources()
        call?.enqueue(object : Callback<MultipleResource?> {
            override fun onResponse(
                call: Call<MultipleResource?>?,
                response: Response<MultipleResource?>
            ) {
                Log.d("TAG", response.code().toString() + "")
                var displayResponse = ""
                val resource: MultipleResource? = response.body()
                //val text = resource?.customerId
                val firstName = resource?.firstName
                val totalPages = resource?.lastName
                val datumList = resource?.email

                Log.d("text",firstName.toString())
            }

            override fun onFailure(call: Call<MultipleResource?>, t: Throwable?) {
                call.cancel()
            }
        })
    }
}