package com.googlex.lxl.jetpackdemo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.googlex.lxl.jetpackdemo.dao.UserRepository
import com.googlex.lxl.jetpackdemo.fragment.PageingViewModel

class PageingUserViewModelFactory(private val userRepository: UserRepository) :
    ViewModelProvider.NewInstanceFactory(){


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PageingViewModel(userRepository) as T
    }
}