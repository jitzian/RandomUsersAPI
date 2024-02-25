package com.org.test.randomusersapp.ui.screens.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.test.randomusersapp.ui.screens.main.MainStateUI
import com.org.test.randomusersapp.ui.screens.main.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
) : ViewModel() {
    private val TAG = "MainViewModel"
    private val _state: MutableStateFlow<MainStateUI> = MutableStateFlow(MainStateUI.Empty)
    val state = _state.asStateFlow()

    fun getUsersData(
        page: Int,
        results: Int,
        seed: String,
    ) = viewModelScope.launch {
        getDataUseCase.prepareData(page, results, seed).collect { data ->
            /*when (data) {
                is MainStateUI.Loading -> _state.update { MainStateUI.Loading }
                is MainStateUI.Success -> _state.update { MainStateUI.Success(data.data) }
                is MainStateUI.Error -> _state.update { MainStateUI.Error(data.message) }
                else -> _state.update { MainStateUI.Empty }
            }*/
            _state.update { data }
        }
    }
}