package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addResult(result: ResultEntityDB)

    @Query("SELECT * FROM result WHERE id = :id")
    fun findResultById(id: Int): Flow<ResultEntityDB>

    @Query("SELECT * FROM result")
    fun getAllResult(): Flow<List<ResultEntityDB>>

    @Update
    suspend fun updateResult(result: ResultEntityDB)

    @Delete
    suspend fun deleteResult(result: ResultEntityDB)

    @Query("SELECT * FROM result WHERE idEntityDB = :value")
    suspend fun findResultByValue(value: String): ResultEntityDB
}