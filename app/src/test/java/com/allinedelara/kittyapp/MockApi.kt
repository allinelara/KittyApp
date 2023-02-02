package com.allinedelara.kittyapp

import com.allinedelara.data.api.Api
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MockApi: Api {
    override suspend fun getAll(count: Int, urls: Boolean, httpsUrls: Boolean): List<String> {
        return Gson().fromJson(
            "[\"https://cdn.shibe.online/cats/f385035d636239bb99e7d33be6b48420ad76676f.jpg\",\"https://cdn.shibe.online/cats/f6b5d0c7fbec7bcd09f201d616d65dc3379c30c1.jpg\"]",
            object : TypeToken<List<String>>() {}.type
        )
    }
}