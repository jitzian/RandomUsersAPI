package com.org.test.randomusersapp.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.org.test.randomusersapp.data.db.entities.PictureEntityDB
import kotlinx.coroutines.flow.Flow

@Dao
interface PictureDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPicture(picture: PictureEntityDB)

    @Query("SELECT * FROM picture WHERE id = :id")
    suspend fun findPictureById(id: Int): Flow<PictureEntityDB>

    @Query("SELECT * FROM picture")
    suspend fun getAllPicture(): Flow<List<PictureEntityDB>>

    @Update
    suspend fun updatePicture(picture: PictureEntityDB)

    @Delete
    suspend fun deletePicture(picture: PictureEntityDB)

}