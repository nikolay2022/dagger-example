package com.example.home.di

import com.example.home.presentation.DetailsFragment
import com.example.home.presentation.HomeFragment
import com.example.home.presentation.HomeViewModelFactory
import dagger.Component

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
@Component(modules = [HomeViewModelModule::class, HomeModule::class])
interface HomeComponent {

    fun inject(fragment: HomeFragment)
    fun inject(fragment: DetailsFragment)

    fun viewModelFactory(): HomeViewModelFactory

    @Component.Builder
    interface Builder {

        fun build(): HomeComponent
    }
}
