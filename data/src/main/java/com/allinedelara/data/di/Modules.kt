package com.allinedelara.data.di

import com.allinedelara.data.api.RetrofitInstance
import com.allinedelara.data.repo.RemoteRepoImpl
import com.allinedelara.domain.usecases.repositories.RemoteRepo
import org.koin.dsl.module

var module = module {
    single { RetrofitInstance() }
    single<RemoteRepo> { RemoteRepoImpl(get()) }
}