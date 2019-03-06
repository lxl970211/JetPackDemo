package com.googlex.lxl.jetpackdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.googlex.lxl.jetpackdemo.dao.GalleryRepository

class GalleryViewModelFactory(private val galleryRepository: GalleryRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return GalleryViewModel(galleryRepository) as T
    }
}