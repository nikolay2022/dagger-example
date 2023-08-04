package com.example.home.presentation

import androidx.lifecycle.ViewModel
import com.example.home.domain.repositories.DataRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

/**
 * Created by Nikolay Yakushov on 04.08.2023.
 */
class DetailsViewModel @AssistedInject constructor(
    private val dataRepository: DataRepository,
    @Assisted private val itemKey: String
) : ViewModel() {

    @AssistedFactory
    interface Factory {
        fun create(@Assisted itemKey: String): DetailsViewModel
    }

    fun getText(): String {
        return "Вы открыли item $itemKey"
    }

}