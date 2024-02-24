package com.org.test.randomusersapp.data.db.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.org.test.randomusersapp.data.db.entities.*

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromCoordinatesEntityDB(coordinates: CoordinatesEntityDB): String {
        return gson.toJson(coordinates)
    }

    @TypeConverter
    fun toCoordinatesEntityDB(coordinates: String): CoordinatesEntityDB {
        val type = object: TypeToken<CoordinatesEntityDB>() {}.type
        return gson.fromJson(coordinates, type)
    }

    @TypeConverter
    fun fromDobEntityDB(dob: DobEntityDB): String {
        return gson.toJson(dob)
    }

    @TypeConverter
    fun toDobEntityDB(dob: String): DobEntityDB {
        val type = object: TypeToken<DobEntityDB>() {}.type
        return gson.fromJson(dob, type)
    }

    @TypeConverter
    fun fromIdEntityDB(id: IdEntityDB): String {
        return gson.toJson(id)
    }

    @TypeConverter
    fun toIdEntityDB(id: String): IdEntityDB {
        val type = object: TypeToken<IdEntityDB>() {}.type
        return gson.fromJson(id, type)
    }

    @TypeConverter
    fun fromLocationEntityDB(location: LocationEntityDB): String {
        return gson.toJson(location)
    }

    @TypeConverter
    fun toLocationEntityDB(location: String): LocationEntityDB {
        val type = object: TypeToken<LocationEntityDB>() {}.type
        return gson.fromJson(location, type)
    }

    @TypeConverter
    fun fromLoginEntityDB(login: LoginEntityDB): String {
        return gson.toJson(login)
    }

    @TypeConverter
    fun toLoginEntityDB(login: String): LoginEntityDB {
        val type = object: TypeToken<LoginEntityDB>() {}.type
        return gson.fromJson(login, type)
    }

    @TypeConverter
    fun fromNameEntityDB(name: NameEntityDB): String {
        return gson.toJson(name)
    }

    @TypeConverter
    fun toNameEntityDB(name: String): NameEntityDB {
        val type = object: TypeToken<NameEntityDB>() {}.type
        return gson.fromJson(name, type)
    }

    @TypeConverter
    fun fromPictureEntityDB(picture: PictureEntityDB): String {
        return gson.toJson(picture)
    }

    @TypeConverter
    fun toPictureEntityDB(picture: String): PictureEntityDB {
        val type = object: TypeToken<PictureEntityDB>() {}.type
        return gson.fromJson(picture, type)
    }

    @TypeConverter
    fun fromRegisteredEntityDB(registered: RegisteredEntityDB): String {
        return gson.toJson(registered)
    }

    @TypeConverter
    fun toRegisteredEntityDB(registered: String): RegisteredEntityDB {
        val type = object: TypeToken<RegisteredEntityDB>() {}.type
        return gson.fromJson(registered, type)
    }

    @TypeConverter
    fun fromStreetEntityDB(street: StreetEntityDB): String {
        return gson.toJson(street)
    }

    @TypeConverter
    fun toStreetEntityDB(street: String): StreetEntityDB {
        val type = object: TypeToken<StreetEntityDB>() {}.type
        return gson.fromJson(street, type)
    }

    @TypeConverter
    fun fromTimezoneEntityDB(timezone: TimezoneEntityDB): String {
        return gson.toJson(timezone)
    }

    @TypeConverter
    fun toTimezoneEntityDB(timezone: String): TimezoneEntityDB {
        val type = object: TypeToken<TimezoneEntityDB>() {}.type
        return gson.fromJson(timezone, type)
    }

}