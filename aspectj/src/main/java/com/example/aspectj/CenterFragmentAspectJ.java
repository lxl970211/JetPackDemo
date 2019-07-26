package com.example.aspectj;

import android.util.Log;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CenterFragmentAspectJ {


    @After(value = "execution(*com.googlex.lxl.jetpackdemo.fragment.test(..))")
    public void afterTest(JoinPoint joinPoint){
        Log.e("AspectJ", "the center fragment init");
    }

}
