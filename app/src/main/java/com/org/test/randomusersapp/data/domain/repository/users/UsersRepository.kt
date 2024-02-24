package com.org.test.randomusersapp.data.domain.repository.users

import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.data.remote.model.Result
import com.org.test.randomusersapp.data.remote.model.ResultApi
import kotlinx.coroutines.flow.Flow

interface UsersRepository {

    suspend fun getUsersData(
        page: Int,
        results: Int,
        seed: String,
    ): ResultApi

    //This one is the same as above except that it does not include the info section
    suspend fun getUsers(
        page: Int,
        results: Int,
        seed: String,
    ): List<Result>

    suspend fun addResultRoom(result: ResultEntityDB)

    //We should take Id.value
    fun findResultByIdRoom(id: String): Flow<ResultEntityDB>

    fun getAllResultsRoom(): Flow<List<ResultEntityDB>>

    suspend fun updateResultRoom(result: ResultEntityDB)

    suspend fun deleteResultRoom(result: ResultEntityDB)

}