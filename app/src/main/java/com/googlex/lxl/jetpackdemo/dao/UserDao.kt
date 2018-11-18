package com.googlex.lxl.jetpackdemo.dao

import androidx.lifecycle.LiveData
import androidx.room.*

import com.googlex.lxl.jetpackdemo.data.User

/**
 * Created by xiaolong.liu on 2018/10/9.
 */
@Dao
interface UserDao {
    @get:Query("SELECT * FROM draw_user")
    val allUsers: LiveData<List<User>>

    @Insert
    fun insertUser(vararg user: User)

    @Delete
    fun deleteUser(user: User)


}
