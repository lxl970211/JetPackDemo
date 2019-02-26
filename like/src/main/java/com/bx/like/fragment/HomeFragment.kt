package com.bx.like.fragment

import android.graphics.BitmapFactory
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.UiThread

import com.bx.like.R
import com.bx.like.runOnIoThread
import com.bx.like.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.home_fragment.*
import java.net.URL

class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button.setOnClickListener {
            try {
                runOnIoThread {
                    var bitmap = BitmapFactory.decodeStream(URL("http://img1.gamersky.com/image2016/12/20161208_djy_248_6/gamersky_04small_08_20161281759132.jpg").openStream())
                    activity?.runOnUiThread {
                        imageView.setImageBitmap(bitmap)

                    }
                }


            }catch (e : Exception){
                e.printStackTrace()
            }

        }
    }


}
