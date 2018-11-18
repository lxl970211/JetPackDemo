package com.googlex.lxl.jetpackdemo.database

import androidx.sqlite.db.SupportSQLiteDatabase
import android.content.Context
import android.os.AsyncTask
import android.util.Log
import androidx.databinding.adapters.Converters
import androidx.room.*

import com.googlex.lxl.jetpackdemo.dao.UserDao
import com.googlex.lxl.jetpackdemo.data.User

/**
 * Created by xiaolong.liu on 2018/10/9.
 */
@Database(entities = arrayOf(User::class), version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun userDao(): UserDao


    private class PopulateDbAsncTask(appDataBase: AppDataBase) : AsyncTask<Void, Void, Void>() {

        private val userDao: UserDao

        init {
            userDao = appDataBase.userDao()
        }

        override fun doInBackground(vararg voids: Void): Void? {
            Log.e("draw-db", "开始填充数据")

            val user1 = User("liu", "xiaolong", 21)
            val user2 = User("刘", "小龙", 22)
            val user3 = User("江", "123", 23)
            val user4 = User("flow", "sunflower", 24)

            userDao.insertUser(user1, user2, user3, user4)
            return null
        }
    }

    companion object {


        @Volatile var instance: AppDataBase? = null


        fun getInstance(mContext: Context): AppDataBase {
            return instance
                    ?: synchronized(this) {
                        instance ?: Room.databaseBuilder(mContext.applicationContext, AppDataBase::class.java, "draw-db")
                                        .addCallback(createCallBack)
                                        .build().also { instance = it }
                    }
        }


        private val createCallBack = object : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                Log.e("draw-db", "数据库开始创建")
                PopulateDbAsncTask(instance!!).execute()
            }
        }
    }
}
