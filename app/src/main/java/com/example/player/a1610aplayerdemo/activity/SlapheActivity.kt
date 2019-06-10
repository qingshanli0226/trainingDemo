package com.example.player.a1610aplayerdemo.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_slaphe.*

class SlapheActivity: BaseActivity(),ViewPropertyAnimatorListener {


    override fun onAnimationCancel(p0: View?) {
        //动画结束的监听

    }

    override fun onAnimationStart(p0: View?) {

    }
    override fun onAnimationEnd(p0: View?) {
        //结束的监听
        startActivityAndFinish<MainActivity>()
    }
//
    override fun getLayoutId(): Int {
        return R.layout.activity_slaphe
    }

    override fun initdata() {
        //设置引导页面动画   splash_img  这个参数放入的是 imgager ID
        ViewCompat.animate(splash_img).scaleX(2.5f).scaleY(2.5f).rotation(1080.0f).setListener(this).setDuration(3500)
    }

}
