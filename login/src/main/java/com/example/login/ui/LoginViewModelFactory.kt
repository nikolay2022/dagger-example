package com.example.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

class LoginViewModelFactory @Inject constructor(private val viewModels:MutableMap<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModels[modelClass]?.get() as T
    }
}