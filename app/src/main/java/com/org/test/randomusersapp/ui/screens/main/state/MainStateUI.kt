package com.org.test.randomusersapp.ui.screens.main.state

import com.org.test.randomusersapp.data.db.entities.ResultEntityDB

sealed class MainStateUI {
    data object Empty : MainStateUI()
    data object Loading : MainStateUI()
    data class Error(val message: String) : MainStateUI()
    data class Success(
        val data: List<ResultEntityDB>
    ) : MainStateUI()
}