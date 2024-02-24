package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.CoordinatesEntityDB
import com.org.test.randomusersapp.data.remote.model.Coordinates
import javax.inject.Inject

class CoordinatesToCoordinatesEntityDBMapper @Inject constructor() :
        (Coordinates) -> (CoordinatesEntityDB) {
    override fun invoke(input: Coordinates) = CoordinatesEntityDB(
        latitude = input.latitude,
        longitude = input.longitude
    )
}