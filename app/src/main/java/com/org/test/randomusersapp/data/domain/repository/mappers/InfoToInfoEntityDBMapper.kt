package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.InfoEntityDB
import com.org.test.randomusersapp.data.remote.model.Info
import javax.inject.Inject

class InfoToInfoEntityDBMapper @Inject constructor() : (Info) -> (InfoEntityDB) {
    override fun invoke(input: Info) = InfoEntityDB(
        seed = input.seed,
        results = input.results,
        page = input.page,
        version = input.version
    )
}