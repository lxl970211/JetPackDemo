package com.googlex.lxl.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.databinding.FragmentViewFlipperBinding
import kotlinx.android.synthetic.main.fragment_view_flipper.*

class ViewFlipperFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var binding = DataBindingUtil.inflate<FragmentViewFlipperBinding>(
            inflater,
            R.layout.fragment_view_flipper,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button2.setOnClickListener {
            view_flipper.isAutoStart = if (view_flipper.isAutoStart) false else true
        }

        btn_next.setOnClickListener {
            view_flipper.showNext()
        }

        btn_last.setOnClickListener {
            view_flipper.showPrevious()
        }

        btn_go.setOnClickListener {
            view_flipper.showNext()
        }
    }
}
