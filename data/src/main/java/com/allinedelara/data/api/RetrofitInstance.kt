package com.allinedelara.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    fun getRetrofitInstance(): Retrofit? {
        return Retrofit.Builder()
            .baseUrl("https://shibe.online/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}