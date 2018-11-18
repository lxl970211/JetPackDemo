package com.googlex.lxl.jetpackdemo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by xiaolong.liu on 2018/10/9.
 */
@Entity(tableName = "draw_user")
class User(@field:ColumnInfo(name = "first_name")
           var firstName: String?, @field:ColumnInfo(name = "last_name")
           var lastName: String?, var age: Int) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
