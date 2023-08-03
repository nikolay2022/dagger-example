package com.example.dagger_pet.di

import com.example.dagger_pet.MainActivity
import com.example.home.di.HomeComponent
import com.example.login.di.LoginComponent
import dagger.Component

/**
 * Created by Nikolay Yakushov on 14.07.2023.
 */
@Component(modules = [AppModule::class], dependencies = [LoginComponent::class, HomeComponent::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}