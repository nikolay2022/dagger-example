package com.example.login.di

import com.example.login.presentation.LoginFragment
import com.example.login.presentation.LoginViewModelFactory
import dagger.Component

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
@Component(modules = [LoginViewModelModule::class, LoginModule::class])
interface LoginComponent {

    fun inject(fragment: LoginFragment)

    fun viewModelFactory(): LoginViewModelFactory

    @Component.Builder
    interface Builder {

        fun build(): LoginComponent
    }
}
