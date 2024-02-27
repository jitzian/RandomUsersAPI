package com.org.test.randomusersapp.ui.screens.main.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.test.randomusersapp.ui.screens.main.state.MainStateUI
import com.org.test.randomusersapp.ui.screens.main.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<MainStateUI> = MutableStateFlow(MainStateUI.Loading)
    val state = _state.asStateFlow()

    fun getUsersData(
        page: Int,
        results: Int,
        seed: String,
    ) = viewModelScope.launch {
        delay(2.seconds)
        getDataUseCase.prepareData(page, results, seed).collect { data ->
            _state.update { data }
        }
    }
}