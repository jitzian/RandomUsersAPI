package com.org.test.randomusersapp.ui.screens.main.state

import com.org.test.randomusersapp.data.db.entities.ResultEntityDB

sealed class MainStateUI {
    open val isLoading: Boolean = true
    data object Empty : MainStateUI()
    data class Loading(
        override val isLoading: Boolean = true
    ) : MainStateUI()
    data class Error(
        val message: String,
        override val isLoading: Boolean = false
    ) : MainStateUI()
    data class Success(
        val data: List<ResultEntityDB>,
        override val isLoading: Boolean = false
    ) : MainStateUI()
}