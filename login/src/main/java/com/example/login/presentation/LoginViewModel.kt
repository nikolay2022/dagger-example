package com.example.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.login.domain.AuthRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
class LoginViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authSuccessLiveData = MutableLiveData<Boolean>()
    val authSuccessLiveData: LiveData<Boolean> = _authSuccessLiveData

    fun auth(email: String, password: String) {
        viewModelScope.launch {
            val isAuthSuccessful = authRepository.authUser(email, password)
            _authSuccessLiveData.value = isAuthSuccessful
        }
    }

    fun getLoginText(): String {
        return "Authorization"
    }
}