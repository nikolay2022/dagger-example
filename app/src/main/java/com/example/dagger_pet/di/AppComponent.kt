package com.example.dagger_pet.di

import com.example.dagger_pet.MainActivity
import com.example.login.di.LoginDeps
import com.example.login.di.LoginModule
import com.example.login.ui.LoginViewModelFactory
import dagger.Component

/**
 * Created by Nikolay Yakushov on 14.07.2023.
 */
@Component(modules = [AppModule::class, LoginModule::class])
interface AppComponent : LoginDeps {

    override val loginViewModelFactory: LoginViewModelFactory

    fun inject(mainActivity: MainActivity)

}