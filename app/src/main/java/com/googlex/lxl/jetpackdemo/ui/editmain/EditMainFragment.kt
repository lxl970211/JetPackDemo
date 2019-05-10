package com.googlex.lxl.jetpackdemo.ui.editmain

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.googlex.lxl.jetpackdemo.R
import kotlinx.android.synthetic.main.edit_main_fragment.*

class EditMainFragment : Fragment() {

    companion object {
        fun newInstance() = EditMainFragment()
    }

    private lateinit var viewModel: EditMainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.edit_main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(EditMainViewModel::class.java)

        tv_filter.setOnClickListener {
            findNavController().navigate(EditMainFragmentDirections.actionEditMainFragmentToFilterFragment())
        }
        btn_frame.setOnClickListener {
            findNavController().navigate(EditMainFragmentDirections.actionEditMainFragmentToFrameFragment())

        }

    }

}
