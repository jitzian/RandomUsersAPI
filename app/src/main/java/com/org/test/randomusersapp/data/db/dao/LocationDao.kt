package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.LocationEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLocation(location: LocationEntityDB)

    @Query("SELECT * FROM location WHERE id = :id")
    suspend fun findLocationById(id: Int): Flow<LocationEntityDB>

    @Query("SELECT * FROM location")
    suspend fun getAllLocation(): Flow<List<LocationEntityDB>>

    @Update
    suspend fun updateLocation(location: LocationEntityDB)

    @Delete
    suspend fun deleteLocation(location: LocationEntityDB)

}