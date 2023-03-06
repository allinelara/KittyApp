package com.allinedelara.kittyapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allinedelara.domain.usecases.GetAllImagesUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class ImageViewModel(private val getAll: GetAllImagesUrl) : ViewModel() {

    private val _images = MutableLiveData<List<String>?>()
    val images: MutableLiveData<List<String>?> = _images

    fun getImages() {
        viewModelScope.launch(Dispatchers.Main) {
            getAll.invoke().flowOn(Dispatchers.IO).collect { result -> _images.value = result }
        }
    }
}