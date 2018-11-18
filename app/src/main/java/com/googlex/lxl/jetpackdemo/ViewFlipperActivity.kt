package com.googlex.lxl.jetpackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.googlex.lxl.jetpackdemo.databinding.ActivityViewModelBinding
import kotlinx.android.synthetic.main.activity_view_flipper.*

class ViewFlipperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = DataBindingUtil.setContentView<ActivityViewModelBinding>(this, R.layout.activity_view_flipper)

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
