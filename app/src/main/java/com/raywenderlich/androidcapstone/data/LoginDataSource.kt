package com.raywenderlich.androidcapstone.data


import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.gson.JsonObject
import com.raywenderlich.androidcapstone.ap2.ApiInterface
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
    lateinit var custNum: String

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication

            val service = ApiInterface.create()
            Log.d("Login",username)
            val call2: Call<JsonObject> = service.fetchLogin(username)
            call2.enqueue(object : Callback<JsonObject> {

                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    val response = response.body()
                    Log.d("Sample",response.toString())
                    apiUsername = response?.get("email").toString()
                    apiPassword = response?.get("password").toString()
                    apiUser = response?.get("firstName").toString()
                    custNum = response?.get("customerId").toString()

                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    t.message?.let { Log.d("Sample", it) }
                }
            })

            apiUsername = apiUsername.substring(1, apiUsername.length - 1)
            apiPassword = apiPassword.substring(1, apiPassword.length - 1)
            custNum = custNum.substring(1, custNum.length - 1)
            Log.d("Username", custNum)
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), apiUser)
            return if (username == apiUsername && password == apiPassword){
                Result.Success(fakeUser)
            }else{
                Result.Error(IOException("Error logging in"))
            }
        } catch (e: Throwable) {
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
