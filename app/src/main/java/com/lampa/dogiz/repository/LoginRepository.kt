package com.lampa.dogiz.repository

import android.annotation.SuppressLint
import android.content.Context
import android.provider.Settings.Secure
import com.lampa.dogiz.model.CheckCodeResponse
import com.lampa.dogiz.model.LoginCode
import com.lampa.dogiz.retrofit.ApiService
import com.lampa.dogiz.retrofit.CheckCodeResponseMapper
import com.lampa.dogiz.retrofit.ModelErrorEntity
import com.lampa.dogiz.util.RequestState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginRepository @Inject constructor(
    private val apiService: ApiService,
    private val checkCodeResponseMapper: CheckCodeResponseMapper,
    @ApplicationContext private val context: Context,
) {

    @SuppressLint("HardwareIds")
    private val deviceId = Secure.getString(context.contentResolver, Secure.ANDROID_ID)

    suspend fun setPhone(phone: String): RequestState<LoginCode?> {
        return try {
            val response = apiService.setPhone(phone, deviceId)
            if (response.isSuccessful) {
                RequestState.Success(response.body())
            } else {
                RequestState.RequestError(ModelErrorEntity(response.code()))
            }
        } catch (e: Exception) {
            RequestState.GeneralError(e)
        }
    }

    suspend fun checkCode(code: Int): RequestState<CheckCodeResponse?> {
        return try {
            val response = apiService.checkCode(code, deviceId)
            if (response.isSuccessful) {
                RequestState.Success(response.body()?.let { checkCodeResponseMapper.mapFromEntity(it) })
            } else {
                RequestState.RequestError(ModelErrorEntity(response.code()))
            }
        } catch (e: Exception) {
            RequestState.GeneralError(e)
        }
    }
}
