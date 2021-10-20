package com.lampa.dogiz.viewmodel

import androidx.lifecycle.ViewModel
import com.lampa.dogiz.manager.SharedPreferencesManager
import com.lampa.dogiz.repository.HubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HubViewModel @Inject constructor(
    private val hubRepository: HubRepository,
    private val sharedPreferencesManager: SharedPreferencesManager,
) : ViewModel() {
}