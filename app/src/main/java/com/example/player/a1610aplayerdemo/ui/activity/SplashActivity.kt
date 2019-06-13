@file:Suppress("UNREACHABLE_CODE")

package com.example.player.a1610aplayerdemo.ui.activity
import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.util.SharedPreferencesUtil
import java.util.*



class SplashActivity: BaseActivity() {


    var context:Context = this@SplashActivity

    override fun initListener() {

    }

    var sharedPreferencesUtil:SharedPreferencesUtil = SharedPreferencesUtil(this@SplashActivity)


    override fun initData() {
        var timer:Timer = Timer()
        var task1:taskOne = taskOne()
        var task2:taskTwo = taskTwo()
        if (sharedPreferencesUtil.SharedPreferencesGet2String("进入") == "进了"){
            timer.schedule(task2,2000)
        }else{
            timer.schedule(task1,2000)
        }
    }

    override fun getLayoutId(): Int {
        return  R.layout.activity_splash
    }

    inner class taskOne:TimerTask() {
        override fun run() {
            var intent  = Intent()
            intent.setClass(context,GuideActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }


    }

    inner class taskTwo:TimerTask(){
        override fun run() {
            var intent  = Intent()
            intent.setClass(context,MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
}