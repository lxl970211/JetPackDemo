package com.googlex.lxl.jetpackdemo.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.Config
import androidx.paging.toLiveData
import com.googlex.lxl.jetpackdemo.dao.UserRepository
import com.googlex.lxl.jetpackdemo.data.User

/**
 * Created by xiaolong.liu on 2018/10/9.
 */

class UserViewModel(private var userRepository: UserRepository) : ViewModel() {

    var users: LiveData<List<User>> = userRepository.users

    fun insertUser(user: User) {
        userRepository.insert(user)
    }

    fun deleteUser(user: User) {
        userRepository.deleteUser(user)
    }

    var allUser = userRepository.allUser.toLiveData(Config(pageSize = 10, enablePlaceholders = true, maxSize = 200))

}
