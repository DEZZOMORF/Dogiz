package com.lampa.dogiz.retrofit

import com.lampa.dogiz.model.login.LoginSetPhoneResponse
import com.lampa.dogiz.retrofit.hub.entity.HubResponseEntity
import com.lampa.dogiz.retrofit.login.LoginResponseEntity
import com.lampa.dogiz.util.NetworkUrls
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @FormUrlEncoded
    @POST(NetworkUrls.SET_PHONE_URL)
    suspend fun setPhone(
        @Field("phone") phone: String,
        @Header("deviceId") deviceId: String,
        @Header("platform") platform: String = "ANDROID"
    ): Response<LoginSetPhoneResponse>

    @FormUrlEncoded
    @POST(NetworkUrls.CHECK_CODE_URL)
    suspend fun checkCode(
        @Field("code") code: Int,
        @Header("deviceId") deviceId: String,
    ): Response<LoginResponseEntity>

    @GET(NetworkUrls.HUB)
    suspend fun hub(
        @Query("dogId") dogId: String? = null,
    ): Response<HubResponseEntity>

}