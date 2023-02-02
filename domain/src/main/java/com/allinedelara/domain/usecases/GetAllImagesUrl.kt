package com.allinedelara.domain.usecases

import com.allinedelara.domain.usecases.repositories.RemoteRepo

class GetAllImagesUrl(private val remoteRepo: RemoteRepo) : GetAllImages {
    override suspend fun execute(): List<String> {
        return remoteRepo.getAll()
    }
}