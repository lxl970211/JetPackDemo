package com.bx.like.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.bx.like.R
import com.bx.like.viewmodel.MineViewModel

class MineFragment : Fragment() {

    companion object {
        fun newInstance() = MineFragment()
    }

    private lateinit var viewModel: MineViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.mine_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MineViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
