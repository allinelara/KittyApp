package com.allinedelara.data.repo

import kotlinx.coroutines.flow.Flow

interface RemoteRepo {
    suspend fun getAll(): Flow<List<String>>
}