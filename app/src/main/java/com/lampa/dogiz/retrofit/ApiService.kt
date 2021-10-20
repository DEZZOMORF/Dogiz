package com.lampa.dogiz.retrofit

import com.lampa.dogiz.model.LoginCode
import com.lampa.dogiz.util.NetworkUrls
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST(NetworkUrls.SET_PHONE_URL)
    suspend fun setPhone(
        @Field("phone") phone: String,
        @Header("deviceId") deviceId: String,
        @Header("platform") platform: String = "ANDROID"
    ): Response<LoginCode>

    @FormUrlEncoded
    @POST(NetworkUrls.CHECK_CODE_URL)
    suspend fun checkCode(
        @Field("code") code: Int,
        @Header("deviceId") deviceId: String,
    ): Response<CheckCodeResponseEntity>
}