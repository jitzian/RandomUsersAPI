package com.org.test.randomusersapp.ui.screens.details.usecase

import com.org.test.randomusersapp.data.domain.repository.users.UsersRepository
import com.org.test.randomusersapp.ui.screens.details.state.DetailsStateUI
import javax.inject.Inject

class GetDetailDataUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    suspend fun findResultByValue(value: String): DetailsStateUI {
        return runCatching {
            usersRepository.findResultByValue(value)
        }.fold(
            onSuccess = { DetailsStateUI.Success(data = it) },
            onFailure = { DetailsStateUI.Error(it.message ?: "Unknown error") }
        )
    }
}