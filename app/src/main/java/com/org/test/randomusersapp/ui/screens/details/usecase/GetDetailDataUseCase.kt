package com.org.test.randomusersapp.ui.screens.details.usecase

import com.org.test.randomusersapp.data.domain.repository.users.UsersRepository
import com.org.test.randomusersapp.ui.screens.details.state.DetailsStateUI
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
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

    /*suspend fun findResultByValue(value: String): Flow<DetailsStateUI> {
        return flow {
            usersRepository.findResultByValue(value).collect {
                runCatching {
                    emit(DetailsStateUI.Success(data = it))
                }.getOrElse { e ->
                    emit(DetailsStateUI.Error(e.message ?: "Unknown error"))
                }
            }
        }
    }*/

    suspend fun findResultByValue(value: String): DetailsStateUI {
        return runCatching {
            usersRepository.findResultByValue(value)
        }.fold(
            onSuccess = { DetailsStateUI.Success(data = it) },
            onFailure = { DetailsStateUI.Error(it.message ?: "Unknown error") }
        )
    }

}