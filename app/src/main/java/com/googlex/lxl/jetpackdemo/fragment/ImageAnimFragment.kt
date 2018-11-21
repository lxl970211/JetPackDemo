package com.googlex.lxl.jetpackdemo.fragment


import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.interpolator.view.animation.FastOutSlowInInterpolator

import com.googlex.lxl.jetpackdemo.R
import com.googlex.lxl.jetpackdemo.databinding.FragmentImageAnimBinding
import kotlinx.android.synthetic.main.fragment_image_anim.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ImageAnimFragment : Fragment() {


    private var binding : FragmentImageAnimBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_image_anim, container, false)
        // Inflate the layout for this fragment

        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        button2.setOnClickListener {
            anim( BounceInterpolator())

        }

        button3.setOnClickListener {
            anim( FastOutSlowInInterpolator())
        }

        btn_reset.setOnClickListener {
            imageView.setImageResource(R.mipmap.ic_detail_collection)
        }
    }

    fun anim( timeInterpolator: TimeInterpolator =AnticipateOvershootInterpolator() ){
        var objectAnimatorY = ObjectAnimator.ofFloat(imageView, "scaleY", 1F,  1.5F, 1F)
        var objectAnimatorX = ObjectAnimator.ofFloat(imageView, "scaleX", 1F,  1.5F, 1F)
        imageView.setImageResource(R.mipmap.ic_detail_collected)
        AnimatorSet().apply {
            play(objectAnimatorX).with(objectAnimatorY)
            duration = 400
            interpolator = timeInterpolator
            start()
        }
    }


}
