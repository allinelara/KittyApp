package com.allinedelara.domain.usecases

interface GetAllImages {
    suspend fun execute(): List<String>
}