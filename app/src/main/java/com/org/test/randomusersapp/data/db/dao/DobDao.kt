package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.DobEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface DobDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addDob(dob: DobEntityDB)

    @Query("SELECT * FROM dob WHERE id = :id")
    suspend fun findDobById(id: Int): Flow<DobEntityDB>

    @Query("SELECT * FROM dob")
    suspend fun getAllDob(): Flow<List<DobEntityDB>>

    @Update
    suspend fun updateDob(dob: DobEntityDB)

    @Delete
    suspend fun deleteDob(dob: DobEntityDB)
}