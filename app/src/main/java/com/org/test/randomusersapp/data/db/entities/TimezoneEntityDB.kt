package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "timezone")
data class TimezoneEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val description: String,
    val offset: String
) : Parcelable