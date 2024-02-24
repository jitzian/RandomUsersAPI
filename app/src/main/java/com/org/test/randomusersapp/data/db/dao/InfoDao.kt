package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.InfoEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface InfoDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addInfo(info: InfoEntityDB)

    @Query("SELECT * FROM info WHERE id = :id")
    fun findInfoById(id: Int): Flow<InfoEntityDB>

    @Query("SELECT * FROM info")
    fun getAllInfo(): Flow<List<InfoEntityDB>>

    @Update
    suspend fun updateInfo(info: InfoEntityDB)

    @Delete
    suspend fun deleteInfo(info: InfoEntityDB)

}