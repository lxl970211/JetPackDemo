package com.googlex.lxl.jetpackdemo.fragment

import androidx.lifecycle.ViewModel;
import androidx.paging.Config
import androidx.paging.toLiveData
import com.googlex.lxl.jetpackdemo.dao.UserRepository

class PageingViewModel(private val userRepository: UserRepository) : ViewModel() {


    var allUsers = userRepository.allUser.toLiveData(Config(
        pageSize = 10, enablePlaceholders = true, maxSize = 200
    ))

}
