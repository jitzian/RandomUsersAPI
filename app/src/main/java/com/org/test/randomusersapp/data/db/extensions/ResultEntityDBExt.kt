package com.org.test.randomusersapp.data.db.extensions

import com.google.gson.Gson
import com.org.test.randomusersapp.data.db.entities.ResultEntityDB

val ResultEntityDB.idEntityToJson: String
    get() = Gson().toJson(idEntityDB)