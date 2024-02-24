package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.NameEntityDB
import com.org.test.randomusersapp.data.remote.model.Name
import javax.inject.Inject

class NameToNameEntityDBMapper @Inject constructor() : (Name) -> (NameEntityDB){
    override fun invoke(input: Name) = NameEntityDB(
        title = input.title,
        first = input.first,
        last = input.last
    )
}