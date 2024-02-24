package com.org.test.randomusersapp.data.domain.repository.mappers

import com.org.test.randomusersapp.data.db.entities.LoginEntityDB
import com.org.test.randomusersapp.data.remote.model.Login
import javax.inject.Inject

class LoginToLoginEntityDBMapper @Inject constructor() : (Login) -> (LoginEntityDB) {
    override fun invoke(input: Login) = LoginEntityDB(
        uuid = input.uuid,
        username = input.username,
        password = input.password,
        salt = input.salt,
        md5 = input.md5,
        sha1 = input.sha1,
        sha256 = input.sha256
    )
}