package com.raywenderlich.androidcapstone.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.raywenderlich.androidcapstone.apidata.CustomerResponse

class ApiViewModel : ViewModel() {
    val userInfo: MutableLiveData<CustomerResponse> = MutableLiveData()
    init {
        userInfo.value = CustomerResponse()
    }
}