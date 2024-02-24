package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "street")
data class StreetEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: Int
) : Parcelable