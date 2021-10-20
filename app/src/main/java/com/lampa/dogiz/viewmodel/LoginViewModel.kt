package com.lampa.dogiz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lampa.dogiz.model.CheckCodeResponse
import com.lampa.dogiz.model.LoginCode
import com.lampa.dogiz.repository.LoginRepository
import com.lampa.dogiz.util.Loger
import com.lampa.dogiz.util.RequestState
import com.lampa.dogiz.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
) : ViewModel() {

    var setPhoneUiState: MutableLiveData<UiState<LoginCode?>> = MutableLiveData()
    var checkCodeUiState: MutableLiveData<UiState<CheckCodeResponse?>> = MutableLiveData()

    fun setPhone(phone: String) {
        setPhoneUiState.postValue(UiState.Loading)
        viewModelScope.launch {
            when (val setPhoneRequestState = loginRepository.setPhone(phone)) {
                is RequestState.Success -> {
                    setPhoneUiState.postValue(UiState.Success(setPhoneRequestState.data))
                }
                is RequestState.RequestError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(setPhoneRequestState.requestErrorModel.message)
                        )
                    )
                }
                is RequestState.GeneralError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(setPhoneRequestState.exception.message)
                        )
                    )
                }
            }
        }
    }

    fun checkCode(code: Int) {
        checkCodeUiState.postValue(UiState.Loading)
        viewModelScope.launch {
            when (val checkCodeRequestState = loginRepository.checkCode(code)) {
                is RequestState.Success -> {
                    checkCodeUiState.postValue(UiState.Success(checkCodeRequestState.data))
                }
                is RequestState.RequestError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(checkCodeRequestState.requestErrorModel.message)
                        )
                    )
                }
                is RequestState.GeneralError -> {
                    checkCodeUiState.postValue(
                        UiState.Error(
                            Exception(checkCodeRequestState.exception.message)
                        )
                    )
                }
            }
        }
    }
}
