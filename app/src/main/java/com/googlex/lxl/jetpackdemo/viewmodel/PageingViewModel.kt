package com.googlex.lxl.jetpackdemo.viewmodel

import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.googlex.lxl.jetpackdemo.dao.UserRepository
import com.googlex.lxl.jetpackdemo.data.DataSource
import com.googlex.lxl.jetpackdemo.data.PageDataSourceFactory

class PageingViewModel(private val userRepository: UserRepository) : ViewModel() {


    var allUsers = LivePagedListBuilder(PageDataSourceFactory(DataSource()), PagedList.Config.Builder()
        .setPageSize(12)
        .setMaxSize(200)
        .setInitialLoadSizeHint(20)
        .setEnablePlaceholders(true)
        .build()).build()

}
