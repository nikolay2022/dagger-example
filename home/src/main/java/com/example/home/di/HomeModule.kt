package com.example.home.di

import com.example.home.data.repositories.DataRepositoryImpl
import com.example.home.domain.repositories.DataRepository
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideDataRepository(): DataRepository = DataRepositoryImpl()
}