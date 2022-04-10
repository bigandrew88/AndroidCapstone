package com.raywenderlich.androidcapstone.test

import androidx.lifecycle.*
import com.raywenderlich.androidcapstone.apidata.CustomerResponse
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val repository = SharedRepositry()

    private val _customerLiveData = MutableLiveData<List<ApiCustomerResponse>>()
    val customerLiveData: LiveData<List<ApiCustomerResponse>?> = _customerLiveData

    fun refreshCustomer(customer:String){
        viewModelScope.launch{
            val response = repository.getCustomer(customer)

            _customerLiveData.postValue(response!!)
        }
    }
}