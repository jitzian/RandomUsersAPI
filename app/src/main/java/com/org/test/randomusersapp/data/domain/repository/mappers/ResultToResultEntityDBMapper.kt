package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.ResultEntityDB
import com.org.test.randomusersapp.data.remote.model.Result
import javax.inject.Inject

class ResultToResultEntityDBMapper @Inject constructor(
    private val dobToDobEntityDBMapper: DobToDobEntityDBMapper,
    private val idToIdEntityDBMapper: IdToIdEntityDBMapper,
    private val locationToLocationEntityDBMapper: LocationToLocationEntityDBMapper,
    private val loginToLoginEntityDBMapper: LoginToLoginEntityDBMapper,
    private val nameToNameEntityDBMapper: NameToNameEntityDBMapper,
    private val pictureToPictureEntityDBMapper: PictureToPictureEntityDBMapper,
    private val registeredToRegisteredEntityDBMapper: RegisteredToRegisteredEntityDBMapper,
) : (Result) -> (ResultEntityDB) {
    override fun invoke(input: Result) = ResultEntityDB(
        cell = input.cell,
        dobEntityDB = dobToDobEntityDBMapper(input.dob),
        email = input.email,
        gender = input.gender,
        idEntityDB = idToIdEntityDBMapper(input.id),
        locationEntityDB = locationToLocationEntityDBMapper(input.location),
        loginEntityDB = loginToLoginEntityDBMapper(input.login),
        nameEntityDB = nameToNameEntityDBMapper(input.name),
        nat = input.nat,
        phone = input.phone,
        pictureEntityDB = pictureToPictureEntityDBMapper(input.picture),
        registered = registeredToRegisteredEntityDBMapper(input.registered),
    )
}