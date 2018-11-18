package com.googlex.lxl.jetpackdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.googlex.lxl.jetpackdemo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        btn_view_model.setOnClickListener {
            startActivity(Intent(this, ViewModelActivity::class.java))
        }

        btn_view_flipper.setOnClickListener {
            startActivity(Intent(this, ViewFlipperActivity::class.java))
        }



    }


}
