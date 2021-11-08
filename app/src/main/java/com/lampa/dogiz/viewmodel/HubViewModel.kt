package com.lampa.dogiz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lampa.dogiz.repository.HubRepository
import com.lampa.dogiz.retrofit.hub.entity.HubResponseEntity
import com.lampa.dogiz.util.RequestState
import com.lampa.dogiz.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HubViewModel @Inject constructor(
    private val hubRepository: HubRepository,
) : ViewModel() {
    var hubUiState: MutableLiveData<UiState<HubResponseEntity?>> = MutableLiveData()

    fun getData(dogId: String? = null) {
        hubUiState.postValue(UiState.Loading)
        viewModelScope.launch {
            when (val hubRequestState = hubRepository.getData(dogId)) {
                is RequestState.Success -> {
                    hubUiState.postValue(UiState.Success(hubRequestState.data))
                }
                is RequestState.RequestError -> {
                    hubUiState.postValue(
                        UiState.Error(
                            Exception(hubRequestState.requestErrorModel.message)
                        )
                    )
                }
                is RequestState.GeneralError -> {
                    hubUiState.postValue(
                        UiState.Error(
                            Exception(hubRequestState.exception.message)
                        )
                    )
                }
            }
        }
    }
}