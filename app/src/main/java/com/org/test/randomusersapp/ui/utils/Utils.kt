package com.org.test.randomusersapp.ui.utils

import com.org.test.randomusersapp.data.db.entities.CoordinatesEntityDB
import com.org.test.randomusersapp.data.db.entities.DobEntityDB
import com.org.test.randomusersapp.data.db.entities.IdEntityDB
import com.org.test.randomusersapp.data.db.entities.LocationEntityDB
import com.org.test.randomusersapp.data.db.entities.LoginEntityDB
import com.org.test.randomusersapp.data.db.entities.NameEntityDB
import com.org.test.randomusersapp.data.db.entities.PictureEntityDB
import com.org.test.randomusersapp.data.db.entities.RegisteredEntityDB
import com.org.test.randomusersapp.data.db.entities.StreetEntityDB
import com.org.test.randomusersapp.data.db.entities.TimezoneEntityDB

internal val mockedDobEntityDB = DobEntityDB(
    date = "date",
    age = 0
)

internal val mockedIdEntityDB = IdEntityDB(
    value = "value",
    name = "name"
)

internal val mockedLocationEntityDB = LocationEntityDB(
    city = "city",
    country = "country",
    coordinatesEntityDB = CoordinatesEntityDB(
        latitude = "latitude",
        longitude = "longitude"
    ),
    postcode = "postcode",
    state = "state",
    streetEntityDB = StreetEntityDB(
        name = "name",
        number = 0
    ),
    timezoneEntityDB = TimezoneEntityDB(
        description = "description",
        offset = "offset"
    )
)

internal val mockedLoginEntityDB = LoginEntityDB(
    md5 = "md5",
    password = "password",
    salt = "salt",
    sha1 = "sha1",
    sha256 = "sha256",
    username = "username",
    uuid = "uuid"
)

internal val mockedNameEntityDB = NameEntityDB(
    first = "first",
    last = "last",
    title = "title"
)

internal val mockedPictureEntityDB = PictureEntityDB(
    large = "large",
    medium = "medium",
    thumbnail = "thumbnail"
)

internal val mockedRegisteredEntityDB = RegisteredEntityDB(
    date = "date",
    age = 0
)