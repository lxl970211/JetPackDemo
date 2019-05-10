package com.googlex.lxl.jetpackdemo.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.entity.CenterItemBean
import kotlinx.android.synthetic.main.rv_item_center.view.*

public class CenterItemAdapter(layoutResId: Int, data: List<CenterItemBean>?) :
    BaseQuickAdapter<CenterItemBean, BaseViewHolder>(layoutResId, data) {

    override fun convert(helper: BaseViewHolder?, item: CenterItemBean?) {
        helper?.setText(R.id.tv_title, item?.title)
    }


}