package com.raywenderlich.androidcapstone.data


import android.util.Log
import androidx.lifecycle.*
import com.raywenderlich.androidcapstone.ap2.ApiInterface
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import com.raywenderlich.androidcapstone.login.ApiViewModel
import com.raywenderlich.androidcapstone.login.LoginViewModelFactory
import com.raywenderlich.androidcapstone.model.LoggedInUser
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.android.synthetic.main.activity_customer.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException


/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource : ViewModel() {
    private var apiUsername: String = ""
    private var apiPassword: String = ""
    private var apiUser: String = ""
    var custNum = ""
    private lateinit var apiViewModel: ApiViewModel

    fun login(username: String, password: String): Result<LoggedInUser> {

        val service = ApiInterface.create()
        val call2: Call<List<CustomerResponse>> = service.fetchListLogin(username)
        var email = MutableLiveData<CustomerResponse>()
        var pass = MutableLiveData<CustomerResponse>()
        call2.enqueue(object: Callback<List<CustomerResponse>>{
            override fun onResponse(call: Call<List<CustomerResponse>>, response: Response<List<CustomerResponse>>
            ) {
                val response = response.body()
                email.value = response?.get(0)
                //pass.value = response?.get(0)?.password.toString()
                //Log.d("SampleLogin",response.toString())
                apiUser = response?.get(0)?.firstName.toString()
                //custUser(username, password,response?.get(0)?.email.toString(),response?.get(0)?.password.toString())
            }

            override fun onFailure(call: Call<List<CustomerResponse>>, t: Throwable) {
                t.message?.let { Log.d("Error", it) }
            }
        })


        try {
            // TODO: handle loggedInUser authentication

            //Log.d("Outside Username",email.)
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), apiUser)
            return if (username == email.value.toString() && password == pass.value.toString()){
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

    private fun custUser(username: String, password: String,username2: String,password2: String): String{
        val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), apiUser)
        if (username == username2 && password == password2){
            Result.Success(fakeUser)
        }else{
            Result.Error(IOException("Error logging in"))
        }
        return username
    }


}
