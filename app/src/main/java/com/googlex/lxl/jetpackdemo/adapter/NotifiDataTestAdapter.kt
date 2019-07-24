package com.googlex.lxl.jetpackdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.adapter.NotifiDataTestAdapter.NotifiViewHolder
import com.googlex.lxl.jetpackdemo.entity.GalleryImageBean

class NotifiDataTestAdapter constructor(list : List<GalleryImageBean>, recyclerView: RecyclerView) : RecyclerView.Adapter<NotifiViewHolder>() {

    private val mData = list
    private var recyclerView = recyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotifiViewHolder {
        return NotifiViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item_notifi_data_test, parent, false))
    }

    override fun onBindViewHolder(holder: NotifiViewHolder, position: Int) {
        var galleryImageBean = mData.get(position)
        holder.title.text = galleryImageBean.imageName
        holder.ivSelect.visibility = if (galleryImageBean.select) View.VISIBLE else View.GONE
        Glide.with(holder.ivImage.context)
            .load(if (position % 2 == 0) R.drawable.image_dark else R.drawable.image_light)
            .centerCrop()
            .into(holder.ivImage)
        holder.itemView.setOnClickListener {
            mData[position].select = !mData[position].select
            var viewHolder : NotifiViewHolder= recyclerView.findViewHolderForLayoutPosition(position) as NotifiViewHolder
            if (viewHolder != null) {
                viewHolder.ivSelect.visibility = if(mData[position].select) VISIBLE else GONE
            }else{
                notifyItemChanged(position)
            }
            for (i in 0 until mData.size){
                if (i == position) {
                    continue
                }
                if (mData[i].select) {
                    mData[i].select = false
//                    holder.ivSelect.visibility = GONE
                    var lastSelectHolder = recyclerView.findViewHolderForLayoutPosition(i)
                    if (lastSelectHolder != null) {
                        var holder = lastSelectHolder as NotifiViewHolder
                        holder.ivSelect.visibility = GONE
                    }
                    break
                }
            }

        }

    }

    override fun getItemCount(): Int {
        return mData.size
    }

    public class NotifiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: AppCompatTextView = itemView.findViewById(R.id.tv_name)
        val ivImage: AppCompatImageView = itemView.findViewById(R.id.iv_image)
        val ivSelect: AppCompatImageView = itemView.findViewById(R.id.iv_select)


    }


}
