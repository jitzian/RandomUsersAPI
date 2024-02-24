package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "dob")
data class DobEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val age: Int,
    val date: String
) : Parcelable
