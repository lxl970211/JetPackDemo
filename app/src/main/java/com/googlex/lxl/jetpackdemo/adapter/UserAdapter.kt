package com.googlex.lxl.jetpackdemo.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.googlex.lxl.jetpackdemo.data.User
import com.googlex.lxl.jetpackdemo.R
import java.util.*

/**
 * Created by xiaolong.liu on 2018/10/10.
 */

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var mDatas: List<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_rv_item, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = mDatas[position]
        holder.firstName.text = user.firstName
        holder.lastName.text = user.lastName
        holder.age.text = user.age.toString()

    }

    fun setData(mDatas: List<User>) {
        this.mDatas = mDatas
        notifyDataSetChanged()
    }

    fun getUserAt(position: Int): User {
        return mDatas[position]
    }

    override fun getItemCount(): Int {
        return mDatas.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName: TextView
        var lastName: TextView
        var age: TextView

        init {

            firstName = itemView.findViewById(R.id.tv_first_name)
            lastName = itemView.findViewById(R.id.tv_last_name)
            age = itemView.findViewById(R.id.tv_age)
        }
    }
}
