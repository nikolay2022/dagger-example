package com.example.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.models.TextItem
import com.example.home.domain.repositories.DataRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch

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

//    private val _dataLiveData = MutableLiveData<List<TextItem>>()
//    val dataLiveData: LiveData<List<TextItem>> = _dataLiveData

    fun getDashboardText(): String {
        return "Вы открыли item $itemKey"
    }

//    init {
//        viewModelScope.launch {
//            _dataLiveData.value = "Вы открыли item $itemKey"
//        }
//    }

}