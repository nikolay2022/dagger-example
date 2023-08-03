package com.example.home.data.repositories

import com.example.home.domain.models.TextItem
import com.example.home.domain.repositories.DataRepository

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
class DataRepositoryImpl : DataRepository {

    override suspend fun getData(): List<TextItem> {
        //типа запрос в сеть

        val items = mutableListOf<TextItem>()
        for (i in 0..10) {
            items.add(TextItem(i, "Item $i"))
        }
        return items
    }
}