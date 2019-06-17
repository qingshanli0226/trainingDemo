package com.example.player.a1610aplayerdemo.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.bean.SetPasswordBean
import com.example.player.a1610aplayerdemo.bean.SetPwdBean
import com.example.player.a1610aplayerdemo.utils.FragmentUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode


class MainActivity : BaseActivity() {
    var userben:SetPasswordBean.DataBean?=null
    override fun getLayoutId(): Int {
      return R.layout.activity_main
    }

    override fun initlistener() {
        super.initlistener()
        //绑定
        EventBus.getDefault().register(this)
       main_tottombar.setOnTabSelectListener {
             var fragment= FragmentUtils.fragmentUtils.SelectFragment(it)
              var traceElement=  supportFragmentManager.beginTransaction()
                traceElement.replace(R.id.main_fragelayout,fragment).commit()
       }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun EventBusMess(bean: SetPasswordBean.DataBean?){
        Log.d("eventbus","shuju"+bean?.nickName)
        userben = bean!!
    }

    open fun getUserInfo():SetPasswordBean.DataBean?{
        return userben
    }

    override fun onDestroy() {
        super.onDestroy()
        //解除绑定时间
        EventBus.getDefault().unregister(this)
    }
}
