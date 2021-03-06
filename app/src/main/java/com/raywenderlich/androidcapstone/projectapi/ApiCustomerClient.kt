package com.raywenderlich.androidcapstone.projectapi

import retrofit2.Response

class ApiCustomerClient(private val apiCustomerService: ApiCustomerService) {

    suspend fun getCustomer(username: String) : Response<List<ApiCustomerResponse>> {
        return apiCustomerService.fetchListLogin(username)
    }
}