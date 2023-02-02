package com.allinedelara.data.api

import retrofit2.http.GET

interface Api {
    @GET("cats")
    suspend fun getAll(
        @retrofit2.http.Query("count") count: Int,
        @retrofit2.http.Query("urls") urls: Boolean,
        @retrofit2.http.Query("httpsUrls") httpsUrls: Boolean,
    ): List<String>
}