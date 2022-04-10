package com.raywenderlich.androidcapstone.test

class SharedRepositry {
    suspend fun getCustomer(customer:String): List<ApiCustomerResponse>? {
        val request = NetworkLayer.apiClient.getCustomer(customer)

        if(request.isSuccessful){
            return request.body()!!
        }
        return null
    }
}