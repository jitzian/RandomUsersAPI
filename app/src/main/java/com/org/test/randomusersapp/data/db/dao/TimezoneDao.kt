package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.TimezoneEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface TimezoneDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTimezone(timezone: TimezoneEntityDB)

    @Query("SELECT * FROM timezone WHERE id = :id")
    fun findTimezoneById(id: Int): Flow<TimezoneEntityDB>

    @Query("SELECT * FROM timezone")
    fun getAllTimezone(): Flow<List<TimezoneEntityDB>>

    @Update
    suspend fun updateTimezone(timezone: TimezoneEntityDB)

    @Delete
    suspend fun deleteTimezone(timezone: TimezoneEntityDB)
}