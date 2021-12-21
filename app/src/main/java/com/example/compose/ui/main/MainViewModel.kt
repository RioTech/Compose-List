package com.example.compose.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.compose.repository.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ListRepository
) : ViewModel() {
    var listState by mutableStateOf(ListState())

    fun getList() {
        viewModelScope.launch {
            val list = repository.getList()
            listState = listState.copy(isLoading = false, listOfItems = list!!)
        }
    }
}