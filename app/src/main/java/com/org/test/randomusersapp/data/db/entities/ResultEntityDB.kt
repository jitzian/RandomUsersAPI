package com.org.test.randomusersapp.data.db.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "result")
data class ResultEntityDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cell: String,
    val dobEntityDB: DobEntityDB,
    val email: String,
    val gender: String,
    val idEntityDB: IdEntityDB,
    val locationEntityDB: LocationEntityDB,
    val loginEntityDB: LoginEntityDB,
    val nameEntityDB: NameEntityDB,
    val nat: String,
    val phone: String,
    val pictureEntityDB: PictureEntityDB,
    val registered: RegisteredEntityDB
) : Parcelable