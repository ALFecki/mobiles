package com.mobile.calc_without_compose.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.calc_without_compose.Resource
import com.mobile.calc_without_compose.SingleLiveEvent
import com.mobile.calc_without_compose.model.AuthResponse
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @ViewModelInject constructor(private val mainRepo: MainRepo) : ViewModel() {

    private val _sendNotification = SingleLiveEvent<Resource<AuthResponse>>()

    val sendNotification : LiveData<Resource<AuthResponse>> get() =  _sendNotification


    fun doSendNotification(name: String, token: String) =
        viewModelScope.launch {
            try {
                _sendNotification.value =  mainRepo.sendNotification(name, token)
            }
            catch (exception: Exception){

            }
        }


}