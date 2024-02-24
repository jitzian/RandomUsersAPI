package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.StreetEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface StreetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStreet(street: StreetEntityDB)

    @Query("SELECT * FROM street WHERE id = :id")
    suspend fun findStreetById(id: Int): Flow<StreetEntityDB>

    @Query("SELECT * FROM street")
    suspend fun getAllStreet(): Flow<List<StreetEntityDB>>

    @Update
    suspend fun updateStreet(street: StreetEntityDB)

    @Delete
    suspend fun deleteStreet(street: StreetEntityDB)

}