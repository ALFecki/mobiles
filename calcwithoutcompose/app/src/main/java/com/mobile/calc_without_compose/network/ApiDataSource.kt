package com.mobile.calc_without_compose.network

import javax.inject.Inject

class ApiDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun sendNotification(name: String, token: String) = apiService.sendNotification(name, token)

}