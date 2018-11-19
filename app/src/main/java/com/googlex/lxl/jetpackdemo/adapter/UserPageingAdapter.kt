package com.googlex.lxl.jetpackdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.googlex.lxl.jetpackdemo.data.User
import com.googlex.lxl.jetpackdemo.databinding.PageingRvItemBinding

class UserPageingAdapter : PagedListAdapter<User, UserPageingAdapter.ViewHolder>(UserDiffUtilCallBack()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PageingRvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = getItem(position)
        holder.apply {
            bind(user)
            itemView.tag = user
        }
    }


    class ViewHolder(private val binding : PageingRvItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userItem : User?){
            binding.apply {
                pageUser = userItem
                executePendingBindings()
            }
        }
    }

}
