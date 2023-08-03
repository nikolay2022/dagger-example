package com.example.login.di

import com.example.login.data.AuthRepositoryImpl
import com.example.login.domain.AuthRepository
import dagger.Module
import dagger.Provides

@Module
class LoginModule {

    @Provides
    fun provideMyRepository(): AuthRepository = AuthRepositoryImpl()
}