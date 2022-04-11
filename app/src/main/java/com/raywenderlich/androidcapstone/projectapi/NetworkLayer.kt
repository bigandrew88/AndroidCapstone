package com.raywenderlich.androidcapstone.projectapi


import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    val moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    val retrofit: Retrofit = Retrofit.Builder()
        //.client(getLoggingHttpClient())
        .baseUrl("http://192.168.2.150:8080")
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val apiCustomerService: ApiCustomerService by lazy {
        retrofit.create(ApiCustomerService::class.java)
    }

    val apiClient = ApiCustomerClient(apiCustomerService)

}