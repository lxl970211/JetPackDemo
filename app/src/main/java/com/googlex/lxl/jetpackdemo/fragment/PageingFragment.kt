package com.googlex.lxl.jetpackdemo.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager

import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.adapter.UserPageingAdapter
import com.googlex.lxl.jetpackdemo.databinding.PageingFragmentBinding
import com.googlex.lxl.jetpackdemo.util.InJectorUtils
import com.googlex.lxl.jetpackdemo.viewmodel.PageingViewModel
import kotlinx.android.synthetic.main.pageing_fragment.*

class PageingFragment : Fragment() {

    companion object {
        fun newInstance() = PageingFragment()
    }

    private lateinit var viewModel: PageingViewModel
    private lateinit var binding: PageingFragmentBinding

    private var mAdapter : UserPageingAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<PageingFragmentBinding>(inflater, R.layout.pageing_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var factory = context?.let { InJectorUtils.providePageingUserViewModelFactory(it) }
        viewModel = ViewModelProviders.of(this, factory).get(PageingViewModel::class.java)

        mAdapter = UserPageingAdapter()
        binding.recyclerview.layoutManager = LinearLayoutManager(context)
        binding.recyclerview.itemAnimator = DefaultItemAnimator()
        binding.recyclerview.adapter = mAdapter

        viewModel.allUsers.observe(this, Observer { users ->
            tv_count.text = users.size.toString()
            mAdapter?.submitList(users)
        })
    }

}
