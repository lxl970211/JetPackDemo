package com.googlex.lxl.jetpackdemo.util

import android.content.Context
import com.googlex.lxl.jetpackdemo.dao.UserRepository
import com.googlex.lxl.jetpackdemo.database.AppDataBase
import com.googlex.lxl.jetpackdemo.viewmodel.UserViewModelFactory

object InJectorUtils{

    private fun getUserRepository(context: Context) : UserRepository{
        return UserRepository.getInstance(AppDataBase.getInstance(context).userDao())
    }


    fun provideUserViewModelFactory(context: Context) : UserViewModelFactory{
        var factory = getUserRepository(context)
        return UserViewModelFactory(factory)
    }

}