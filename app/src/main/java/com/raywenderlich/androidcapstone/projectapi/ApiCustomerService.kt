package com.raywenderlich.androidcapstone.projectapi


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiCustomerService {
    @GET("/v1/customers")
    suspend fun fetchListLogin(
        @Query("email") email: String
    ) : Response<List<ApiCustomerResponse>>
}