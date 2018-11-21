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

class Retate3DDialogFragment : DialogFragment() {

    private var binding: RetateDialogBinding? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<RetateDialogBinding>(inflater, R.layout.retate_dialog, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageview.setOnClickListener {

        }
    }
}