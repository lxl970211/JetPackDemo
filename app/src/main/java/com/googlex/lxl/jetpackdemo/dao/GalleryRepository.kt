package com.googlex.lxl.jetpackdemo.dao

import android.content.ContentProvider
import android.content.ContentResolver
import android.net.Uri
import android.provider.MediaStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.googlex.lxl.jetpackdemo.entity.GalleryImageBean
import com.googlex.lxl.jetpackdemo.util.getIntColumn
import com.googlex.lxl.jetpackdemo.util.getLongColumn
import com.googlex.lxl.jetpackdemo.util.getStringColumn
import com.googlex.lxl.jetpackdemo.util.runOnIoThread


class GalleryRepository private constructor(private val contentResolver: ContentResolver) {

    public var allImages = MutableLiveData<List<GalleryImageBean>>()

    public fun getImages() {
        runOnIoThread {
            var cursor = contentResolver.query(
                uri,
                imageProjection,
                null,
                null,
                MediaStore.Images.Media.DATE_MODIFIED + "DESC LIMIT 100"
            )


            allImages.value = cursor.let {
                var images = ArrayList<GalleryImageBean>()

                while (it.moveToNext()) {
                    var dataPath = it.getStringColumn(imageProjection[0])
                    var id = it.getStringColumn(imageProjection[1])
                    var imageName = it.getStringColumn(imageProjection[2])
                    var addedDate = it.getLongColumn(imageProjection[3])
                    var modifiedDate = it.getLongColumn(imageProjection[4])
                    var mimeType = it.getStringColumn(imageProjection[5])
                    var width = it.getIntColumn(imageProjection[6])
                    var height = it.getIntColumn(imageProjection[7])

                    var galleryImageBean =
                        GalleryImageBean(dataPath, id, imageName, addedDate, modifiedDate, mimeType, width, height)
                    images.add(galleryImageBean)
                }
                images
            }
        }

    }


    companion object {

        val uri: Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val imageProjection = arrayOf(
            MediaStore.Images.ImageColumns.DATA,
            MediaStore.Images.ImageColumns._ID,
            MediaStore.Images.ImageColumns.DISPLAY_NAME,
            MediaStore.Images.ImageColumns.DATE_ADDED,
            MediaStore.Images.ImageColumns.DATE_MODIFIED,
            MediaStore.Images.ImageColumns.MIME_TYPE,
            MediaStore.Images.ImageColumns.WIDTH,
            MediaStore.Images.ImageColumns.HEIGHT
        )

        val folderProjection = arrayOf(
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME,
            MediaStore.Images.Media.BUCKET_ID
        )


        private var instance: GalleryRepository? = null

        public fun getInstance(contentResolver: ContentResolver): GalleryRepository {
            return instance ?: synchronized(this) {
                instance ?: GalleryRepository(contentResolver).also { instance = it }
            }
        }
    }


}