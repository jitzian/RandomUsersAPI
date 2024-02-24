package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@androidx.room.Entity(tableName = "picture")
data class PictureEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val large: String,
    val medium: String,
    val thumbnail: String
) : Parcelable