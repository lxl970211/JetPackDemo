package com.googlex.lxl.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.databinding.FragmentCenterBinding
import kotlinx.android.synthetic.main.fragment_center.*

class CenterFragment : Fragment() {

    private var binding : FragmentCenterBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentCenterBinding>(inflater,
            R.layout.fragment_center, container, false)
        return binding?.root
    }
    private lateinit var btnViewFlipper : Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_view_model.setOnClickListener {
            it.findNavController().navigate(CenterFragmentDirections.ActionCenterFragmentToViewModelFragment())

        }


        btn_view_flipper.setOnClickListener {
            var directions =
                CenterFragmentDirections.ActionCenterFragmentToViewFlipperFragment()
            it.findNavController().navigate(directions)
        }

        btn_page.setOnClickListener {
            it.findNavController().navigate(CenterFragmentDirections.ActionCenterFragmentToPageingFragment())
        }


    }
}
