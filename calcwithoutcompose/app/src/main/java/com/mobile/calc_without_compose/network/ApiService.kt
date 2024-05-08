package com.mobile.calc_without_compose.network

import com.mobile.calc_without_compose.EndPoints
import com.mobile.calc_without_compose.model.AuthResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

@JvmSuppressWildcards
interface ApiService {

    @FormUrlEncoded
    @POST(EndPoints.SAVE_TOKEN)
    suspend fun sendNotification (
        @Field("name") name: String,
        @Field("token") token: String)
            : Response<AuthResponse>

}