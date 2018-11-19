package com.googlex.lxl.jetpackdemo.data

import android.util.Log
import androidx.lifecycle.LiveData

class DataSource{

    private val data = ArrayList<User>()

    init {
        for (i in 1..200){
            val user = User("liu$i", "xiao$i", i)
            data.add(user)
        }
    }

    fun loadData(size : Int = 12): List<User>{
        Log.e(javaClass.simpleName, size.toString())
        return data.subList(0, size)
    }


    fun loadPageData(page: Int, size: Int): List<User>? {
        Log.e(javaClass.simpleName, " loadPageData $page  $size")

        val totalPage = if (data.size % size == 0) {
            data.size / size
        } else {
            data.size / size + 1
        }

        if (page > totalPage || page < 1) {
            return null
        }

        if (page == totalPage) {
            return data.subList((page - 1) * size, data.size)
        }
        return data.subList((page - 1) * size, page * size)
    }


}