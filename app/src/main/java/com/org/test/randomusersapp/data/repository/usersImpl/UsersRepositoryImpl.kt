package com.org.test.randomusersapp.data.repository.usersImpl

import android.app.Application
import com.org.test.randomusersapp.data.db.UsersDB
import com.org.test.randomusersapp.data.db.dao.ResultDao
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.data.domain.repository.users.UsersRepository
import com.org.test.randomusersapp.data.remote.RestApi
import javax.inject.Inject

class UsersRepositoryImpl @Inject constructor(
    context: Application,
    private val restApi: RestApi,
) : UsersRepository {

    private val db = UsersDB.getInstance(context)
    private var resultDao: ResultDao = db.resultDao()

    override suspend fun getUsersData(
        page: Int,
        results: Int,
        seed: String,
    ) = restApi.getUsers(page, results, seed)

    override suspend fun getUsers(
        page: Int,
        results: Int,
        seed: String,
    ) = restApi.getUsers(page, results, seed).results

    override suspend fun addResultRoom(result: ResultEntityDB) = resultDao.addResult(result)

    override fun findResultByIdRoom(id: String) = resultDao.findResultById(id.toInt())

    override fun getAllResultsRoom() = resultDao.getAllResult()

    override suspend fun updateResultRoom(result: ResultEntityDB) = resultDao.updateResult(result)

    override suspend fun deleteResultRoom(result: ResultEntityDB) = resultDao.deleteResult(result)
}