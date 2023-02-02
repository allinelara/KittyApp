package com.allinedelara.data.repo

import com.allinedelara.data.api.Api
import com.allinedelara.data.api.RetrofitInstance
import com.allinedelara.domain.usecases.repositories.RemoteRepo

class RemoteRepoImpl(private val retrofitClientInstance: RetrofitInstance): RemoteRepo {
    override suspend fun getAll(): List<String> {
        val service =
            retrofitClientInstance.getRetrofitInstance()
                ?.create(Api::class.java)!!
      return service.getAll(100, urls = true, httpsUrls = true)
    }
}