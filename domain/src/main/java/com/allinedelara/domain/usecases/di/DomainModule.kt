package com.allinedelara.domain.usecases.di

import com.allinedelara.domain.usecases.GetAllImagesUrl
import org.koin.dsl.module

var moduleDomain = module {
    single { GetAllImagesUrl(get()) }
}