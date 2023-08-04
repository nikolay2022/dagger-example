package com.example.home.di

import androidx.lifecycle.ViewModel
import com.example.home.data.repositories.DataRepositoryImpl
import com.example.home.domain.repositories.DataRepository
import com.example.home.presentation.DetailsViewModel
import com.example.home.presentation.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class HomeModule {

    @Provides
    fun provideDataRepository(): DataRepository = DataRepositoryImpl()

}