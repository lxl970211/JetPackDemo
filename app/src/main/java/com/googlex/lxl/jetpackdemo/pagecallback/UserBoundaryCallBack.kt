package com.googlex.lxl.jetpackdemo.pagecallback

import androidx.paging.ItemKeyedDataSource
import com.googlex.lxl.jetpackdemo.data.User

class UserBoundaryCallBack : ItemKeyedDataSource<Int, User>(){

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<User>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<User>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getKey(item: User): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}
