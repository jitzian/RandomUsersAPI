package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.TimezoneEntityDB
import com.org.test.randomusersapp.data.remote.model.Timezone
import javax.inject.Inject

class TimezoneToTimezoneEntityDBMapper @Inject constructor() : (Timezone) -> (TimezoneEntityDB) {
    override fun invoke(input: Timezone) = TimezoneEntityDB(
        offset = input.offset,
        description = input.description
    )
}