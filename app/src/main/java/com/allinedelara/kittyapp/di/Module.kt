package com.allinedelara.kittyapp.di


import com.allinedelara.kittyapp.ImageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

var module = module {
    viewModel { ImageViewModel(get()) }
}