package com.example.home.domain.repositories

import com.example.home.domain.models.TextItem

interface DataRepository {

    suspend fun getData(): List<TextItem>
}