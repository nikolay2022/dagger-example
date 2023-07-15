package com.example.login.di

import androidx.lifecycle.ViewModel
import com.example.login.ui.LoginFragment
import com.example.login.ui.LoginViewModelFactory
import dagger.Component
import kotlin.properties.Delegates

/**
 * Created by Nikolay Yakushov on 14.07.2023.
 */
@Component(modules = [LoginModule::class], dependencies = [LoginDeps::class])
interface LoginComponent {

    fun inject(fragment: LoginFragment)

    @Component.Builder
    interface Builder {
        fun deps(deps: LoginDeps): Builder

        fun build(): LoginComponent
    }

}

interface LoginDeps {
    val loginViewModelFactory: LoginViewModelFactory
}

internal class LoginComponentViewModel : ViewModel(){

    val newLoginComponent = DaggerLoginComponent.builder().deps(LoginDepsProvider.deps).build()
}

interface LoginDepsProvider {
    val deps: LoginDeps

    companion object : LoginDepsProvider by LoginDepsStore
}

object LoginDepsStore : LoginDepsProvider {
    override var deps: LoginDeps by Delegates.notNull()
}