package com.googlex.lxl.jetpackdemo.data

import androidx.paging.PageKeyedDataSource

class UserDataSource(private val dataSource: DataSource) : PageKeyedDataSource<Int, User>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, User>) {
        val data = dataSource.loadData(params.requestedLoadSize)
        data.let {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val data = dataSource.loadPageData(params.key, params.requestedLoadSize)
        data?.let {
            callback.onResult(it, params.key + 1)
        }

    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, User>) {
        val data = dataSource.loadPageData(params.key, params.requestedLoadSize)
        data?.let {
            callback.onResult(it, params.key - 1)
        }
    }


}
