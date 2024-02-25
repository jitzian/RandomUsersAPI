package com.org.test.randomusersapp.ui.screens.details.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.org.test.randomusersapp.ui.screens.details.state.DetailsStateUI
import com.org.test.randomusersapp.ui.screens.details.usecase.GetDetailDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.time.Duration.Companion.seconds

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getDetailDataUseCase: GetDetailDataUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<DetailsStateUI> = MutableStateFlow(DetailsStateUI.Empty)
    val state = _state.asStateFlow()

    fun getDetailData(id: String) = viewModelScope.launch {
        delay(1.seconds)
        _state.update { DetailsStateUI.Loading }
        getDetailDataUseCase.findResultByIdRoom(id).collect { data ->
            _state.update { data }
        }
    }

}