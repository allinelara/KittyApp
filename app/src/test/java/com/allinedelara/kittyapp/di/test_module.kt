package com.allinedelara.kittyapp.di

import com.allinedelara.data.api.RetrofitInstance
import com.allinedelara.kittyapp.ImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleTest = module {
    viewModel { ImageViewModel(get()) }
    single { RetrofitInstance() }
}

val testApp = listOf(moduleTest)