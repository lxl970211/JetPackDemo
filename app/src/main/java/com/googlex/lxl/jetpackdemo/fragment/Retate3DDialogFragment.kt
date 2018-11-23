package com.googlex.lxl.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.databinding.RetateDialogBinding
import kotlinx.android.synthetic.main.retate_dialog.*
import com.googlex.lxl.jetpackdemo.util.Rotate3dAnimation
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth



class Retate3DDialogFragment : DialogFragment() {

    private var binding: RetateDialogBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomDialog)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<RetateDialogBinding>(inflater, R.layout.retate_dialog, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageview.setOnClickListener {

            val centerX = binding?.root?.getWidth()?.div(2.0F)
            val centerY = binding?.root?.getHeight()?.div(2.0F)
            val depthZ = 0f
            val rotate3dAnimationX =
                Rotate3dAnimation(0f, 180f, centerX!!, centerY!!, depthZ, Rotate3dAnimation.ROTATE_Y_AXIS, true)
            rotate3dAnimationX.duration = 1000
            rotate3dAnimationX.fillAfter = true
            binding?.root?.startAnimation(rotate3dAnimationX)

        }
    }
}