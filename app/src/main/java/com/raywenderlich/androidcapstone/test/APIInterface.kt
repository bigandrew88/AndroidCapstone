package com.raywenderlich.androidcapstone.test

import retrofit2.Call
import retrofit2.http.GET


interface APIInterface {
    @GET("/v1/customers/1")
    fun doGetListResources(): Call<MultipleResource?>?
}