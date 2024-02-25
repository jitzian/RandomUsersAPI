package com.org.test.randomusersapp.ui.screens.details.usecase

import com.org.test.randomusersapp.data.domain.repository.users.UsersRepository
import com.org.test.randomusersapp.ui.screens.details.state.DetailsStateUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDetailDataUseCase @Inject constructor(
    private val usersRepository: UsersRepository
) {
    suspend fun findResultByIdRoom(id: String): Flow<DetailsStateUI> {
        return flow {
            usersRepository.findResultByIdRoom(id).collect {
                runCatching {
                    emit(DetailsStateUI.Success(data = it))
                }.getOrElse { e ->
                    emit(DetailsStateUI.Error(e.message ?: "Unknown error"))
                }
            }
        }
    }

}