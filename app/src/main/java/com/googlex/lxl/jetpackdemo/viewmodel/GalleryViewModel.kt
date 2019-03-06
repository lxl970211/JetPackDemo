package com.googlex.lxl.jetpackdemo.viewmodel

import android.content.ContentProvider
import android.content.ContentResolver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import com.googlex.lxl.jetpackdemo.dao.GalleryRepository

class GalleryViewModel(private var galleryRepository: GalleryRepository) : ViewModel() {


    public var allImages = galleryRepository.allImages


    public fun  getImages(){
        galleryRepository.getImages()
    }





}
