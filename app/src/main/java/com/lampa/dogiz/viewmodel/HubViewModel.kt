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
    var setPhoneUiState: MutableLiveData<UiState<HubResponseEntity?>> = MutableLiveData()

    fun getData(dogId: String? = null) {
        setPhoneUiState.postValue(UiState.Loading)
        viewModelScope.launch {
            when (val hubRequestState = hubRepository.getData(dogId)) {
                is RequestState.Success -> {
                    setPhoneUiState.postValue(UiState.Success(hubRequestState.data))
                }
                is RequestState.RequestError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(hubRequestState.requestErrorModel.message)
                        )
                    )
                }
                is RequestState.GeneralError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(hubRequestState.exception.message)
                        )
                    )
                }
            }
        }
    }
}