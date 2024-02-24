package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "coordinates")
data class CoordinatesEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val latitude: String,
    val longitude: String
) : Parcelable