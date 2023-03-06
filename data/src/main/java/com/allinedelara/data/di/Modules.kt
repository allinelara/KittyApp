package com.allinedelara.data.di

import com.allinedelara.data.api.RetrofitInstance
import com.allinedelara.data.repo.RemoteRepoImpl
import com.allinedelara.data.repo.RemoteRepo
import org.koin.dsl.module

var moduleData = module {
    single { RetrofitInstance() }
    single<RemoteRepo> { RemoteRepoImpl(get()) }
}