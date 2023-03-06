package com.allinedelara.domain.usecases

import com.allinedelara.data.repo.RemoteRepo
import kotlinx.coroutines.flow.Flow

class GetAllImagesUrl(private val remoteRepo: RemoteRepo) {
    suspend operator fun invoke(): Flow<List<String>> {
        return remoteRepo.getAll()
    }
}