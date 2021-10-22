package com.lampa.dogiz.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lampa.dogiz.manager.SharedPreferencesManager
import com.lampa.dogiz.model.login.LoginCheckCodeResponse
import com.lampa.dogiz.model.login.LoginSetPhoneResponse
import com.lampa.dogiz.model.Step
import com.lampa.dogiz.repository.LoginRepository
import com.lampa.dogiz.util.RequestState
import com.lampa.dogiz.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val sharedPreferencesManager: SharedPreferencesManager,
) : ViewModel() {

    companion object {
        const val SIGNUP = "User not found"
    }

    var setPhoneUiState: MutableLiveData<UiState<LoginSetPhoneResponse?>> = MutableLiveData()
    var loginCheckCodeUiState: MutableLiveData<UiState<LoginCheckCodeResponse?>> = MutableLiveData()

    fun setPhone(phone: String) {
        setPhoneUiState.postValue(UiState.Loading)
        viewModelScope.launch {
            when (val requestState = loginRepository.setPhone(phone)) {
                is RequestState.Success -> {
                    setPhoneUiState.postValue(UiState.Success(requestState.data))
                }
                is RequestState.RequestError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(requestState.requestErrorModel.message)
                        )
                    )
                }
                is RequestState.GeneralError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(
                            Exception(requestState.exception.message)
                        )
                    )
                }
            }
        }
    }

    fun checkCode(code: Int) {
        loginCheckCodeUiState.postValue(UiState.Loading)
        viewModelScope.launch {
            when (val requestState = loginRepository.checkCode(code)) {
                is RequestState.Success -> when (requestState.data?.step) {
                    Step.HUB -> {
                        requestState.data.auth?.let { sharedPreferencesManager.setAuthData(it) }
                        loginCheckCodeUiState.postValue(UiState.Success(requestState.data))
                    }
                    Step.SIGNUP -> loginCheckCodeUiState.postValue(
                        UiState.Error(Exception(SIGNUP))
                    )
                }
                is RequestState.RequestError -> {
                    setPhoneUiState.postValue(
                        UiState.Error(Exception(requestState.requestErrorModel.message))
                    )
                }
                is RequestState.GeneralError -> {
                    loginCheckCodeUiState.postValue(
                        UiState.Error(Exception(requestState.exception.message))
                    )
                }
            }
        }
    }
}
