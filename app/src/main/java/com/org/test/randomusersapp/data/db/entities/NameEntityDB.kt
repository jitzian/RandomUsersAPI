package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "name")
data class NameEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val first: String,
    val last: String,
    val title: String
) : Parcelable