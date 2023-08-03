package com.example.dagger_pet

import android.app.Application
import com.example.dagger_pet.di.AppComponent
import com.example.dagger_pet.di.AppModule
import com.example.dagger_pet.di.DaggerAppComponent
import com.example.home.di.DaggerHomeComponent
import com.example.login.di.DaggerLoginComponent

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .loginComponent(DaggerLoginComponent.create())
            .homeComponent(DaggerHomeComponent.create())
            .build()

    }
}