package com.example.hasee.dreamvideo.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.startActivity

/**
 * Created by Lmz on 2019/06/08
 *  引导页面
 */
class SplashActivity:BaseActivity(), ViewPropertyAnimatorListener {
    override fun onAnimationCancel(p0: View?) {
        //动画进行时的监听
    }

    override fun onAnimationStart(p0: View?) {
        //动画开始的监听
    }

    override fun onAnimationEnd(p0: View?) {
     /*   //动画结束的监听
        //  因为我们引入的是 anko库。所以 我们跳转activity的方法很简单
        startActivity<MainActivity>() //括号里面是可以放入数据的
        finish() //跳转过后 关闭引导页面*/

        startActivityAndFinish<MainActivity>()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initdata() {
        //设置引导页面动画   splash_img  这个参数放入的是 imgager ID
        ViewCompat.animate(splash_img).scaleX(2.5f).scaleY(2.5f).rotation(1080.0f).setListener(this).setDuration(3500)
    }
}