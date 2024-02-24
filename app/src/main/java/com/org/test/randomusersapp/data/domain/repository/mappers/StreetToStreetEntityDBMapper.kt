package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.StreetEntityDB
import com.org.test.randomusersapp.data.remote.model.Street
import javax.inject.Inject

class StreetToStreetEntityDBMapper @Inject constructor() : (Street) -> (StreetEntityDB) {
    override fun invoke(input: Street) = StreetEntityDB(
        number = input.number,
        name = input.name
    )
}