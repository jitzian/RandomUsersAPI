package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.DobEntityDB
import com.org.test.randomusersapp.data.remote.model.Dob
import javax.inject.Inject

class DobToDobEntityDBMapper @Inject constructor() : (Dob) -> (DobEntityDB) {
    override fun invoke(input: Dob) = DobEntityDB(
        date = input.date,
        age = input.age
    )
}