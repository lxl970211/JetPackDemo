package com.googlex.lxl.jetpackdemo.adapter

import androidx.recyclerview.widget.DiffUtil
import com.googlex.lxl.jetpackdemo.data.User

class UserDiffUtilCallBack : DiffUtil.ItemCallback<User>(){

    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
        return oldItem == newItem
    }


}
