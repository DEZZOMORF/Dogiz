package com.lampa.dogiz.repository

import com.lampa.dogiz.manager.NetworkConnectionManager
import com.lampa.dogiz.retrofit.ApiService
import com.lampa.dogiz.retrofit.hub.entity.HubResponseEntity
import com.lampa.dogiz.util.RequestErrorHandler
import com.lampa.dogiz.util.RequestState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HubRepository @Inject constructor(
    private val apiService: ApiService,
    private val networkConnectionManager: NetworkConnectionManager,
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