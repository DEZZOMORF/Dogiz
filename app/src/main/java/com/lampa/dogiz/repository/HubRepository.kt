package com.lampa.dogiz.repository

import android.content.Context
import com.lampa.dogiz.manager.NetworkConnectionManager
import com.lampa.dogiz.retrofit.ApiService
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HubRepository @Inject constructor(
    private val apiService: ApiService,
    private val networkConnectionManager: NetworkConnectionManager,
    @ApplicationContext private val context: Context,
) {
}