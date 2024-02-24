package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.IdEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface IdDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addId(id: IdEntityDB)

    @Query("SELECT * FROM id WHERE id = :id")
    fun findIdById(id: Int): Flow<IdEntityDB>

    @Query("SELECT * FROM id")
    fun getAllId(): Flow<List<IdEntityDB>>

    @Update
    suspend fun updateId(id: IdEntityDB)

    @Delete
    suspend fun deleteId(id: IdEntityDB)
}