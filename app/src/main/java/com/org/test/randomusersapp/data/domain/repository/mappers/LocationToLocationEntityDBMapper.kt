package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.LocationEntityDB
import com.org.test.randomusersapp.data.remote.model.Location
import javax.inject.Inject

class LocationToLocationEntityDBMapper @Inject constructor(
    private val coordinatesToCoordinatesEntityDBMapper: CoordinatesToCoordinatesEntityDBMapper,
    private val timezoneToTimezoneEntityDBMapper: TimezoneToTimezoneEntityDBMapper,
    private val streetToStreetEntityDBMapper: StreetToStreetEntityDBMapper,
) : (Location) -> (LocationEntityDB) {
    override fun invoke(input: Location) = LocationEntityDB(
        city = input.city,
        coordinatesEntityDB = coordinatesToCoordinatesEntityDBMapper(input.coordinates),
        country = input.country,
        postcode = input.postcode,
        state = input.state,
        streetEntityDB = streetToStreetEntityDBMapper(input.street),
        timezoneEntityDB = timezoneToTimezoneEntityDBMapper(input.timezone)
    )
}

