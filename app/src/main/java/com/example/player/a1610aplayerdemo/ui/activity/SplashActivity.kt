@file:Suppress("UNREACHABLE_CODE")

package com.example.player.a1610aplayerdemo.ui.activity

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.util.MyApplication
import com.example.player.a1610aplayerdemo.util.SharedPreferencesUtil
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit



class SplashActivity: BaseActivity() {

    var sharedPreferencesUtil:SharedPreferencesUtil = SharedPreferencesUtil(MyApplication.getContext() as MyApplication)


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

    class taskOne:TimerTask() {
        override fun run() {
            var intent  = Intent()
            intent.setClass(MyApplication.getContext(),MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            MyApplication.getContext().startActivity(intent)
        }


    }

    class taskTwo:TimerTask(){
        override fun run() {
            var intent  = Intent()
            intent.setClass(MyApplication.getContext(),BannerActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            MyApplication.getContext().startActivity(intent)
        }
    }
}