package com.example.dagger_pet

import android.app.Application
import com.example.dagger_pet.di.AppComponent
import com.example.dagger_pet.di.AppModule
import com.example.dagger_pet.di.DaggerAppComponent
import com.example.login.di.LoginDepsStore

/**
 * Created by Nikolay Yakushov on 14.07.2023.
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()

        LoginDepsStore.deps = appComponent

    }
}