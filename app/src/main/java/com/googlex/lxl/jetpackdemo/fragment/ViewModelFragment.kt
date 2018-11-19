package com.googlex.lxl.jetpackdemo.fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ItemTouchHelper
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.data.User
import com.googlex.lxl.jetpackdemo.util.InJectorUtils
import com.googlex.lxl.jetpackdemo.viewmodel.UserViewModel
import com.googlex.lxl.jetpackdemo.adapter.DiffUserAdapter
import com.googlex.lxl.jetpackdemo.databinding.FragmentViewModelBinding
import kotlinx.android.synthetic.main.fragment_view_model.*

class ViewModelFragment : Fragment() {

    private var userViewModel: UserViewModel? = null

//    private var mAdapter: UserAdapter? = null
    private var mAdapter : DiffUserAdapter? = null
    private lateinit var binding : FragmentViewModelBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentViewModelBinding>(inflater,
            R.layout.fragment_view_model, container, false)

        val factory = context?.let { InJectorUtils.provideUserViewModelFactory(it) }

        userViewModel = ViewModelProviders.of(this, factory).get(UserViewModel::class.java)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = DiffUserAdapter()
        binding.recyclerView.adapter = mAdapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        userViewModel!!.users.observe(this, Observer { users ->
            mAdapter!!.submitList(users)
            binding.textview.text = users!!.size.toString()
        })


        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                userViewModel!!.deleteUser(mAdapter!!.getUserAt(viewHolder.adapterPosition)!!)
            }
        }).attachToRecyclerView(binding.recyclerView)

        button.setOnClickListener {
            userViewModel!!.insertUser(User("google", "bb", 24))

        }
    }


}
