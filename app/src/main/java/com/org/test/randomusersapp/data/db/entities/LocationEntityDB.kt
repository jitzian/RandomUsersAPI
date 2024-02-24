package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "location")
data class LocationEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val city: String,
    val coordinatesEntityDB: CoordinatesEntityDB,
    val country: String,
    val postcode: String,
    val state: String,
    val streetEntityDB: StreetEntityDB,
    val timezoneEntityDB: TimezoneEntityDB
) : Parcelable