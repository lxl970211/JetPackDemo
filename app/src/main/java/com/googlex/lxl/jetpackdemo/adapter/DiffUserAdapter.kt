package com.googlex.lxl.jetpackdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.googlex.lxl.jetpackdemo.data.User
import com.googlex.lxl.jetpackdemo.databinding.UserRvItemBinding

class DiffUserAdapter : ListAdapter<User, DiffUserAdapter.ViewHolder>(UserDiffUtilCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(UserRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.apply {
            bind(user)
            itemView.tag = user
        }
    }

    fun getUserAt(position : Int): User? {
        return getItem(position)
    }

    class ViewHolder(
        private val binding: UserRvItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun  bind(userItem: User){
            binding.apply {
                executePendingBindings()
            }
        }
    }
}
