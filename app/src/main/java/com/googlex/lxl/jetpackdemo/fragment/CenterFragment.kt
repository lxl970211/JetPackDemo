package com.googlex.lxl.jetpackdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.adapter.CenterItemAdapter
import com.googlex.lxl.jetpackdemo.databinding.FragmentCenterBinding
import com.googlex.lxl.jetpackdemo.entity.CenterItemBean
import kotlinx.android.synthetic.main.fragment_center.*

class CenterFragment : Fragment() {

    private var binding: FragmentCenterBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<FragmentCenterBinding>(
            inflater,
            R.layout.fragment_center, container, false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            itemAnimator = DefaultItemAnimator()
        }
        var centerItemAdapter = CenterItemAdapter(R.layout.rv_item_center, getData())
        centerItemAdapter.setOnItemClickListener { adapter, view, position ->
            var bean = adapter.getItem(position) as CenterItemBean
            when (bean.type) {
                CenterItemBean.EDIT -> {
                    findNavController().navigate(CenterFragmentDirections.actionCenterFragmentToEditActivity())
                }
                CenterItemBean.VIEWMODEL_SAMPLE -> {

                }
                else -> {
                }
            }


        }
        recycler_view.adapter = centerItemAdapter


    }


    fun getData(): List<CenterItemBean> {
        return listOf<CenterItemBean>(
            CenterItemBean("编辑", CenterItemBean.EDIT),
            CenterItemBean("PAGEING", CenterItemBean.PAGEING),
            CenterItemBean("View Model", CenterItemBean.VIEWMODEL_SAMPLE)
        )
    }
}
