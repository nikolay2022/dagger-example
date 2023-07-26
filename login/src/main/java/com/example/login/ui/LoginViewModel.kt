package com.example.login.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

/**
 * Created by Nikolay Yakushov on 15.07.2023.
 */
class LoginViewModel @AssistedInject constructor(@Assisted("dataId") private val dataId: Int) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(dataId: Int): LoginViewModel.Factory
    }

    fun getHui(): String {
        return "HUI"
    }
}