package com.org.test.randomusersapp.ui.screens.details.state

import com.org.test.randomusersapp.data.db.entities.ResultEntityDB

sealed class DetailsStateUI {
    data object Empty : DetailsStateUI()
    data object Loading : DetailsStateUI()
    data class Success(val data: ResultEntityDB) : DetailsStateUI()
    data class Error(val message: String) : DetailsStateUI()
}