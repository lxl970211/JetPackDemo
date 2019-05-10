package com.googlex.lxl.jetpackdemo.entity

data class CenterItemBean(var title : String,
                          var type : Int){

    companion object {
        val EDIT = 1
        val PAGEING = 2;
        val VIEWMODEL_SAMPLE = 3;
    }

}

