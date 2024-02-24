package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.RegisteredEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface RegisteredDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRegistered(registered: RegisteredEntityDB)

    @Query("SELECT * FROM registered WHERE id = :id")
    fun findRegisteredById(id: Int): Flow<RegisteredEntityDB>

    @Query("SELECT * FROM registered")
    fun getAllRegistered(): Flow<List<RegisteredEntityDB>>

    @Update
    suspend fun updateRegistered(registered: RegisteredEntityDB)

    @Delete
    suspend fun deleteRegistered(registered: RegisteredEntityDB)

}