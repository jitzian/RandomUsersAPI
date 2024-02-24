package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "info")
data class InfoEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
) : Parcelable