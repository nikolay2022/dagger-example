package com.example.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.domain.models.TextItem
import com.example.home.domain.repositories.DataRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * Created by Nikolay Yakushov on 03.08.2023.
 */
class HomeViewModel @Inject constructor(
    private val dataRepository: DataRepository
) : ViewModel() {

    private val _dataLiveData = MutableLiveData<List<TextItem>>()
    val dataLiveData: LiveData<List<TextItem>> = _dataLiveData

    fun getDashboardText(): String {
        return "Ура, ты авторизован"
    }

    init {
        viewModelScope.launch {
            _dataLiveData.value = dataRepository.getData()
        }
    }

}