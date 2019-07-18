package com.googlex.lxl.jetpackdemo.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager

import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.adapter.NotifiDataTestAdapter
import com.googlex.lxl.jetpackdemo.entity.GalleryImageBean
import kotlinx.android.synthetic.main.fragment_blank.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class BlankFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }
    fun init(){
        var list = mutableListOf<GalleryImageBean>()
        for (i in 0..100){
            list.add(GalleryImageBean(imageName = "图片$i"))
        }
        recycler_view.layoutManager = GridLayoutManager(context, 3)
        var adapter = NotifiDataTestAdapter(list, recycler_view)
        recycler_view.apply {
            layoutManager = GridLayoutManager(context, 3)
            this.adapter = adapter
        }



    }
}
