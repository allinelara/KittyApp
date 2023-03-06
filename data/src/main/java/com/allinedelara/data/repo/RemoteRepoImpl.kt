package com.allinedelara.data.repo

import com.allinedelara.data.api.Api
import com.allinedelara.data.api.RetrofitInstance
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteRepoImpl(private val retrofitClientInstance: RetrofitInstance): RemoteRepo {
    override suspend fun getAll(): Flow<List<String>> = flow{
        val service =
            retrofitClientInstance.getRetrofitInstance()
                ?.create(Api::class.java)!!
       emit(service.getAll(100, urls = true, httpsUrls = true))
    }
}