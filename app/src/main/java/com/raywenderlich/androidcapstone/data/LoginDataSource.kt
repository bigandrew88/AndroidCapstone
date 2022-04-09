package com.raywenderlich.androidcapstone.data


import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.raywenderlich.androidcapstone.ap2.ApiInterface
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import com.raywenderlich.androidcapstone.model.LoggedInUser
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.android.synthetic.main.activity_customer.*
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.net.URLDecoder


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource : ViewModel() {
    private lateinit var apiUsername: String
    private lateinit var apiPassword: String
    private lateinit var apiUser: String
    var custNum = ""

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication

            val service = ApiInterface.create()
            val call2: Call<List<CustomerResponse>> = service.fetchListLogin(username)
            call2.enqueue(object: Callback<List<CustomerResponse>>{
                override fun onResponse(call: Call<List<CustomerResponse>>, response: Response<List<CustomerResponse>>
                ) {
                    val response = response.body()
                    //Log.d("SampleLogin",response.toString())
                    apiUsername = response?.get(0)?.email.toString()
                    apiPassword = response?.get(0)?.password.toString()
                    apiUser = response?.get(0)?.firstName.toString()
                    //Log.d("Inside Username",apiUsername)
                }

                override fun onFailure(call: Call<List<CustomerResponse>>, t: Throwable) {
                    t.message?.let { Log.d("Error", it) }
                }
            })

            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), apiUser)
            return if (username == apiUsername && password == apiPassword){
                Result.Success(fakeUser)
            }else{
                Result.Error(IOException("Error logging in"))
            }
        } catch (e: Throwable) {
            Log.e("Error", e.toString())
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    fun custNumTest(): String {
        return custNum
    }


}
