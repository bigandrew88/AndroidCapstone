package com.raywenderlich.androidcapstone.ap2

import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface  {

    @GET("/v1/customers/1")
    fun fetchFact() : Call<JsonObject>

    @GET("/v1/customers/{customerId}")
    fun fetchCustId(
        @Path("customerId") CustID: String
    ) : Call<JsonObject>

    @GET("/v1/customers?email={email}")
    fun fetchLogin(
        @Path("email") Username: String
    ) : Call<JsonObject>

    companion object {
        fun create() : ApiInterface {

            val client = OkHttpClient.Builder()
                .build()

            return Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.2.150:8080")
                .build().create(ApiInterface::class.java)
        }
    }
}