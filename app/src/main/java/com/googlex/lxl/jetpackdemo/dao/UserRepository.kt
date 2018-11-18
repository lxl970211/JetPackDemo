package com.googlex.lxl.jetpackdemo.dao

import android.app.Application
import androidx.lifecycle.LiveData

import com.googlex.lxl.jetpackdemo.data.User
import com.googlex.lxl.jetpackdemo.database.AppDataBase
import com.googlex.lxl.jetpackdemo.util.runOnIoThread
import java.util.concurrent.Executors

/**
 * Created by xiaolong.liu on 2018/10/9.
 */

class UserRepository private constructor(private val userDao: UserDao){

    val users: LiveData<List<User>> = userDao.allUsers


    fun insert(vararg user: User) {
        runOnIoThread {
            userDao.insertUser(*user)
        }
    }

    fun deleteUser(user: User) {
        runOnIoThread {
            userDao.deleteUser(user)
        }

    }

    companion object {

        @Volatile private var instance : UserRepository? = null

        fun getInstance(userDao: UserDao) : UserRepository {
            return instance?: synchronized(this){
                instance?: UserRepository(userDao).also { instance = it }
            }
        }

    }

}
