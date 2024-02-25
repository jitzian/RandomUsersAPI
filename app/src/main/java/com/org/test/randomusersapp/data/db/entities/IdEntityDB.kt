package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "id_entity")
data class IdEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val value: String? = "",
    val name: String? = "",
) : Parcelable