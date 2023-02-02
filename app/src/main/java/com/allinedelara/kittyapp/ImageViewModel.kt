package com.allinedelara.kittyapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.allinedelara.domain.usecases.GetAllImagesUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ImageViewModel(private val getAll: GetAllImagesUrl) : ViewModel() {

    private val _images = MutableLiveData<List<String>?>()
    val images: MutableLiveData<List<String>?> = _images

    fun getImages(){
        viewModelScope.launch(Dispatchers.Main) {
            _images.value = withContext(Dispatchers.IO) {
                getAll.execute()
            }
        }
    }
}