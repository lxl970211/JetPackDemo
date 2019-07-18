package com.googlex.lxl.jetpackdemo.entity

data class GalleryImageBean(
    var dataPath: String = "",
    var id: String ="",
    var imageName: String = "",
    var addDate: Long = 0L,
    var modifiedDate: Long = 0L,
    var mimeType: String = "",
    var width: Int = 0,
    var height: Int = 0,
    var select : Boolean = false
)


