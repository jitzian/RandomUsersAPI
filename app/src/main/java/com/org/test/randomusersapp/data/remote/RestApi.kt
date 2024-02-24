package com.org.test.randomusersapp.data.remote

import com.org.test.randomusersapp.data.remote.model.ResultApi
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {
    //TODO: Remove this comment
    //https://randomuser.me/api/?page=3&results=10&seed=abc
    @GET("api/")
    fun getUsers(
        @Query("page") page: Int,
        @Query("results") results: Int,
        @Query("seed") seed: String,
    ): ResultApi

}