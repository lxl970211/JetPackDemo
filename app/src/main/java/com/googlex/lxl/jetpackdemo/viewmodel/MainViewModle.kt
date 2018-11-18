package com.googlex.lxl.jetpackdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.googlex.lxl.jetpackdemo.entity.ListBean

/**
 * Created by xiaolong.liu on 2018/9/14.
 */

class MainViewModle : ViewModel() {

    var submit = MutableLiveData<ListBean>()

    init {
        submit.value = submit()
    }


    private fun submit(): ListBean {
        val listBean = ListBean()
        listBean.image = "http://source.drawshow.com//teacher//useruploadimages/1536288591708_2425673.min.png"
        listBean.shareCnt = 10
        listBean.likeCnt = 80
        listBean.collectCnt = 5
        listBean.createTime = "2018-09-14 15:49:22"
        listBean.worksBrief = "这是简介"
        listBean.name = "DrawShow"
        return listBean
    }

    fun likes() {
        val listBean = submit.value
        listBean!!.likeCnt = listBean.likeCnt + 1
        submit.value = listBean
    }

}
