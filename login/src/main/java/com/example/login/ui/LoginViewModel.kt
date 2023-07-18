package com.example.login.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by Nikolay Yakushov on 15.07.2023.
 */
class LoginViewModel @Inject constructor() : ViewModel() {

    fun getHui():String{
        return "HUI"
    }
}