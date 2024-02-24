package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.CoordinatesEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface CoordinatesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addCoordinates(coordinates: CoordinatesEntityDB)

    @Query("SELECT * FROM coordinates WHERE id = :id")
    fun findCoordinatesById(id: Int): Flow<CoordinatesEntityDB>

    @Query("SELECT * FROM coordinates")
    fun getAllCoordinates(): Flow<List<CoordinatesEntityDB>>

    @Update
    suspend fun updateCoordinates(coordinates: CoordinatesEntityDB)

    @Delete
    suspend fun deleteCoordinates(coordinates: CoordinatesEntityDB)
}