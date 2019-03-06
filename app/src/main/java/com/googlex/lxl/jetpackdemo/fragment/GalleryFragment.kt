package com.googlex.lxl.jetpackdemo.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.dao.GalleryRepository
import com.googlex.lxl.jetpackdemo.entity.GalleryImageBean
import com.googlex.lxl.jetpackdemo.viewmodel.GalleryViewModel
import com.googlex.lxl.jetpackdemo.viewmodel.GalleryViewModelFactory

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private lateinit var viewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.gallery_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        var galleryRepository = GalleryRepository.getInstance(context!!.contentResolver)
        var factory = GalleryViewModelFactory(galleryRepository)
        viewModel = ViewModelProviders.of(this, factory).get(GalleryViewModel::class.java)

        viewModel.getImages()
        viewModel.allImages.observe(this,
            Observer<List<GalleryImageBean>> {
                for (galleryImageBean in it) {
                    println(galleryImageBean.imageName)
                }
            })
    }

}
