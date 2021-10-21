package com.lampa.dogiz.repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings.Secure
import com.lampa.dogiz.manager.NetworkConnectionManager
import com.lampa.dogiz.model.login.LoginCheckCodeResponse
import com.lampa.dogiz.model.login.LoginSetPhoneResponse
import com.lampa.dogiz.retrofit.ApiService
import com.lampa.dogiz.retrofit.login.LoginResponseMapper
import com.lampa.dogiz.util.RequestErrorHandler
import com.lampa.dogiz.util.RequestState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val loginResponseMapper: LoginResponseMapper,
    private val networkConnectionManager: NetworkConnectionManager,
    @ApplicationContext private val context: Context,
) {

    @SuppressLint("HardwareIds")
    private val deviceId = Secure.getString(context.contentResolver, Secure.ANDROID_ID)

    suspend fun setPhone(phone: String): RequestState<LoginSetPhoneResponse?> {
        return try {
            when (networkConnectionManager.isConnected.value) {
                true -> {
                    val response = apiService.setPhone(phone, deviceId)
                    if (response.isSuccessful) {
                        RequestState.Success(response.body())
                    } else {
                        RequestErrorHandler().handleError(response)
                    }
                }
                else -> throw Exception(networkConnectionManager.MESSAGE)
            }
        } catch (e: Exception) {
            RequestState.GeneralError(e)
        }
    }

    suspend fun checkCode(code: Int): RequestState<LoginCheckCodeResponse?> {
        return try {
            when (networkConnectionManager.isConnected.value) {
                true -> {
                    val response = apiService.checkCode(code, deviceId)
                    if (response.isSuccessful) {
                        RequestState.Success(response.body()?.let { loginResponseMapper.mapFromEntity(it) })
                    } else {
                        RequestErrorHandler().handleError(response)
                    }
                }
                else -> throw Exception(networkConnectionManager.MESSAGE)
            }

        } catch (e: Exception) {
            RequestState.GeneralError(e)
        }
    }
}
