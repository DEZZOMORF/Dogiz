package com.lampa.dogiz.repository

import android.content.Context
import com.lampa.dogiz.manager.NetworkConnectionManager
import com.lampa.dogiz.retrofit.ApiService
import com.lampa.dogiz.retrofit.hub.entity.HubResponseEntity
import com.lampa.dogiz.util.RequestErrorHandler
import com.lampa.dogiz.util.RequestState
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HubRepository @Inject constructor(
    private val apiService: ApiService,
    private val networkConnectionManager: NetworkConnectionManager,
    @ApplicationContext private val context: Context,
) {
    suspend fun getData(dogId: String? = null): RequestState<HubResponseEntity?> {
        return try {
            when (networkConnectionManager.isConnected.value) {
                true -> {
                    val response = apiService.hub(dogId)
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
}