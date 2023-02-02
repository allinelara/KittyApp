package com.allinedelara.domain.usecases.repositories

interface RemoteRepo {

    suspend fun getAll(): List<String>
}