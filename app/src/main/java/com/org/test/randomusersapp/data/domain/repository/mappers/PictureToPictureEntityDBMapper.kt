package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.PictureEntityDB
import com.org.test.randomusersapp.data.remote.model.Picture
import javax.inject.Inject

class PictureToPictureEntityDBMapper @Inject constructor() : (Picture) -> (PictureEntityDB) {
    override fun invoke(input: Picture) = PictureEntityDB(
        large = input.large,
        medium = input.medium,
        thumbnail = input.thumbnail
    )
}