package com.googlex.lxl.jetpackdemo

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import android.view.View
import com.googlex.lxl.jetpackdemo.adapter.UserAdapter
import com.googlex.lxl.jetpackdemo.data.User
import com.googlex.lxl.jetpackdemo.databinding.ActivityViewModelBinding
import com.googlex.lxl.jetpackdemo.util.InJectorUtils
import com.googlex.lxl.jetpackdemo.viewmodel.UserViewModel
import com.googlex.lxl.jetpackdemo.R

class ViewModelActivity : AppCompatActivity() {

    private var userViewModel: UserViewModel? = null

    private var mAdapter: UserAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityViewModelBinding>(this, R.layout.activity_view_model)
        val factory = InJectorUtils.provideUserViewModelFactory(this)
        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        mAdapter = UserAdapter()

        binding.recyclerView.adapter = mAdapter

        userViewModel!!.users.observe(this, Observer { users ->
            mAdapter!!.setData(users)
            binding.textview.text = users!!.size.toString()
        })


        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                userViewModel!!.deleteUser(mAdapter!!.getUserAt(viewHolder.adapterPosition))
            }
        }).attachToRecyclerView(binding.recyclerView)
    }

    fun add(view: View) {

        userViewModel!!.insertUser(User("google", "bb", 24))

    }

    fun startMain(view: View) {

        startActivity(Intent(this, MainActivity::class.java))

    }

}
