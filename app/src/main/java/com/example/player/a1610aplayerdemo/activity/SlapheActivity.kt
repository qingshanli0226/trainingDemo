package com.example.player.a1610aplayerdemo.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_slaphe.*

class SlapheActivity: BaseActivity(),ViewPropertyAnimatorListener {
    override fun onAnimationEnd(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //结束的监听
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        //动画结束的监听

    }

    override fun onAnimationStart(p0: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        return R.layout.activity_slaphe
    }

    override fun initdata() {
        super.initdata()
        ViewCompat.animate(splash_img).scaleX(2.5f).scaleY(2.5f).rotation(1080.0f).setListener(this).setDuration(3500)
    }

}
