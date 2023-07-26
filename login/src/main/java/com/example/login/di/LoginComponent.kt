package com.example.login.di

import com.example.login.ui.LoginFragment
import com.example.login.ui.LoginViewModel
import dagger.Binds
import dagger.Component

/**
 * Created by Nikolay Yakushov on 14.07.2023.
 */
@Component(modules = [LoginViewModelModule::class])
interface LoginComponent {

    fun inject(fragment: LoginFragment)

    @Binds
    fun viewModelFactory(): LoginViewModel

    @Component.Builder
    interface Builder {

        fun build(): LoginComponent
    }
}
