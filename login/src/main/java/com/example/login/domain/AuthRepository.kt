package com.example.login.domain

interface AuthRepository {

    suspend fun authUser(email: String, password: String): Boolean
}