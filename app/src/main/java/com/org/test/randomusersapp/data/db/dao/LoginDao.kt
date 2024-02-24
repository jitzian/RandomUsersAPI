package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.LoginEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLogin(login: LoginEntityDB)

    @Query("SELECT * FROM login WHERE id = :id")
    suspend fun findLoginById(id: Int): Flow<LoginEntityDB>

    @Query("SELECT * FROM login")
    suspend fun getAllLogin(): Flow<List<LoginEntityDB>>

    @Update
    suspend fun updateLogin(login: LoginEntityDB)

    @Delete
    suspend fun deleteLogin(login: LoginEntityDB)

}