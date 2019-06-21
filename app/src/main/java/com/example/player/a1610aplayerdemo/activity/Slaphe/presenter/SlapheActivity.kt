package com.example.player.a1610aplayerdemo.activity.Slaphe.presenter

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.activity.MainActivity
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import com.example.player.a1610aplayerdemo.activity.Slaphe.presenter.presenter.SlapheCompl
import com.example.player.a1610aplayerdemo.activity.Slaphe.presenter.presenter.SlaphePresenter
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.bean.FirstBean
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_slaphe.*
import org.jetbrains.anko.toast

class SlapheActivity: BaseActivity(),ViewPropertyAnimatorListener,
    SlaphePresenter.ISlapheView {
//    val presenter by lazy { SlapheCompl() }
    val  presenter= SlapheCompl(this)
    override fun initlistener() {
        super.initlistener()
        presenter.getData()

    }
    override fun getSuccessData(bean: String) {
        var s: FirstBean =Gson().fromJson(bean,FirstBean ::class.java)
        var code=s.code
        if(code.equals("success")){
            var data=s.data
            SharePresenterUtils.saveToke(data.accessToken)
            SharePresenterUtils.saveAvater(data.avatar)
        }else{
            toast("fail")
        }
    }

    override fun getFailData(code: Int, e: String) {

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.DeView()
    }


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

//    @SuppressLint("MissingSuperCall")
//    override fun onDestroy() {
//        presenter.DeView()
//    }

}
