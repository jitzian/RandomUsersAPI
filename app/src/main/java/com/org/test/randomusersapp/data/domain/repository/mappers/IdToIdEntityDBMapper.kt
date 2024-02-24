package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.IdEntityDB
import com.org.test.randomusersapp.data.remote.model.Id
import javax.inject.Inject

class IdToIdEntityDBMapper @Inject constructor() : (Id) -> (IdEntityDB) {
    override fun invoke(input: Id) = IdEntityDB(
        name = input.name,
        value = input.value
    )
}