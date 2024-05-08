package com.mobile.calc_without_compose.viewmodel

import com.mobile.calc_without_compose.network.ApiDataSource
import com.mobile.calc_without_compose.network.BaseDataSource
import javax.inject.Inject

class MainRepo @Inject constructor(private val apiDataSource: ApiDataSource): BaseDataSource() {

    suspend fun sendNotification(name: String, token: String) = safeApiCall { apiDataSource.sendNotification(name, token) }

}