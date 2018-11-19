package com.googlex.lxl.jetpackdemo.data

class PageDataSourceFactory(val dataSource : DataSource) : androidx.paging.DataSource.Factory<Int, User>(){
    override fun create(): androidx.paging.DataSource<Int, User> {
        return UserDataSource(dataSource)
    }
}