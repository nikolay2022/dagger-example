package com.example.login.data

import com.example.login.domain.AuthRepository

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
class AuthRepositoryImpl : AuthRepository {

    override suspend fun authUser(email: String, password: String): Boolean {
        //типа запрос в сеть

        return email == "admin" && password == "1234"
    }
}