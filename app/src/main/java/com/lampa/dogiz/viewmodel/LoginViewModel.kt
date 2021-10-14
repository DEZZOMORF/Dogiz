package com.lampa.dogiz.viewmodel

import androidx.lifecycle.ViewModel
import com.lampa.dogiz.repository.LoginRepository
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {
}
