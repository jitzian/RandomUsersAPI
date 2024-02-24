package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.RegisteredEntityDB
import com.org.test.randomusersapp.data.remote.model.Registered
import javax.inject.Inject

class RegisteredToRegisteredEntityDBMapper @Inject constructor() :
        (Registered) -> (RegisteredEntityDB) {
    override fun invoke(input: Registered) = RegisteredEntityDB(
        age = input.age,
        date = input.date
    )

}