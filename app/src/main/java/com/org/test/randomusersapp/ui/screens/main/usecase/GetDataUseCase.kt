package com.org.test.randomusersapp.ui.screens.main.usecase

import android.util.Log
import com.org.test.randomusersapp.data.domain.repository.mappers.ResultToResultEntityDBMapper
import com.org.test.randomusersapp.data.domain.repository.users.UsersRepository
import com.org.test.randomusersapp.data.remote.model.Result
import com.org.test.randomusersapp.ui.screens.main.MainStateUI
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val usersRepository: UsersRepository,
    private val resultToResultEntityDBMapper: ResultToResultEntityDBMapper,
) {
    private val TAG = GetDataUseCase::class.simpleName
    private val scope = CoroutineScope(
        Dispatchers.IO + SupervisorJob() + CoroutineExceptionHandler { _, throwable ->
            Log.e(TAG, "Handling exception:: ${throwable.message}")
        }
    )

    suspend fun prepareData(
        page: Int,
        results: Int,
        seed: String,
    ): Flow<MainStateUI> {
        return flow {
            scope.runCatching { fetchRemoteData(page, results, seed) }
                .fold(
                    onSuccess = { data ->
                        addResultRoom(data.results)
                        emit(
                            MainStateUI.Success(
                                data.results.map { resultToResultEntityDBMapper.invoke(it) }
                            )
                        )
                    },
                    onFailure = { e ->
                        emit(MainStateUI.Error(e.message ?: "Unknown error"))
                    }
                )
        }
    }

    private suspend fun addResultRoom(data: List<Result>) = data.forEach {
        usersRepository.addResultRoom(resultToResultEntityDBMapper.invoke(it))
    }

    private suspend fun fetchRemoteData(
        page: Int,
        results: Int,
        seed: String
    ) = usersRepository.getUsersData(page, results, seed)

}