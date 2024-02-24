package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.NameEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface NameDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addName(name: NameEntityDB)

    @Query("SELECT * FROM name WHERE id = :id")
    fun findNameById(id: Int): Flow<NameEntityDB>

    @Query("SELECT * FROM name")
    fun getAllName(): Flow<List<NameEntityDB>>

    @Update
    suspend fun updateName(name: NameEntityDB)

    @Delete
    suspend fun deleteName(name: NameEntityDB)

}