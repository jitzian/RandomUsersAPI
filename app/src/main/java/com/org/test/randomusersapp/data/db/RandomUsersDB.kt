package com.org.test.randomusersapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.org.test.randomusersapp.constants.GlobalConstants
import com.org.test.randomusersapp.data.db.converters.Converters
import com.org.test.randomusersapp.data.db.dao.CoordinatesDao
import com.org.test.randomusersapp.data.db.dao.DobDao
import com.org.test.randomusersapp.data.db.dao.IdDao
import com.org.test.randomusersapp.data.db.dao.InfoDao
import com.org.test.randomusersapp.data.db.dao.LocationDao
import com.org.test.randomusersapp.data.db.dao.LoginDao
import com.org.test.randomusersapp.data.db.dao.NameDao
import com.org.test.randomusersapp.data.db.dao.PictureDao
import com.org.test.randomusersapp.data.db.dao.RegisteredDao
import com.org.test.randomusersapp.data.db.dao.ResultDao
import com.org.test.randomusersapp.data.db.dao.StreetDao
import com.org.test.randomusersapp.data.db.dao.TimezoneDao
import com.org.test.randomusersapp.data.db.entities.CoordinatesEntityDB
import com.org.test.randomusersapp.data.db.entities.DobEntityDB
import com.org.test.randomusersapp.data.db.entities.IdEntityDB
import com.org.test.randomusersapp.data.db.entities.InfoEntityDB
import com.org.test.randomusersapp.data.db.entities.LocationEntityDB
import com.org.test.randomusersapp.data.db.entities.LoginEntityDB
import com.org.test.randomusersapp.data.db.entities.NameEntityDB
import com.org.test.randomusersapp.data.db.entities.PictureEntityDB
import com.org.test.randomusersapp.data.db.entities.RegisteredEntityDB
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.data.db.entities.StreetEntityDB
import com.org.test.randomusersapp.data.db.entities.TimezoneEntityDB

@Database(
    entities = [
        CoordinatesEntityDB::class,
        DobEntityDB::class,
        IdEntityDB::class,
        InfoEntityDB::class,
        LocationEntityDB::class,
        LoginEntityDB::class,
        NameEntityDB::class,
        PictureEntityDB::class,
        RegisteredEntityDB::class,
        ResultEntityDB::class,
        StreetEntityDB::class,
        TimezoneEntityDB::class,
    ],
    version = GlobalConstants.DB_VERSION,
    exportSchema = false
)

@TypeConverters(Converters::class)

abstract class RandomUsersDB : RoomDatabase() {
    abstract fun coordinatesDao(): CoordinatesDao
    abstract fun dobDao(): DobDao
    abstract fun idDao(): IdDao
    abstract fun infoDao(): InfoDao
    abstract fun locationDao(): LocationDao
    abstract fun loginDao(): LoginDao
    abstract fun nameDao(): NameDao
    abstract fun pictureDao(): PictureDao
    abstract fun registeredDao(): RegisteredDao
    abstract fun resultDao(): ResultDao
    abstract fun streetDao(): StreetDao
    abstract fun timezoneDao(): TimezoneDao

    companion object {
        /* The value of a volatile variable will never be cached and all writes and reads will de done to and from the main memory.
        * This helps to make sure that the value of INSTANCE is always up-to-date and the same for all execution threads.
        * It means that changes made by one thread to INSTANCE are visible to all other threads immediately*/
        @Volatile
        private var INSTANCE: RandomUsersDB? = null

        fun getInstance(context: Context): RandomUsersDB {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RandomUsersDB::class.java,
                        GlobalConstants.DB_NAME
                    ).fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}