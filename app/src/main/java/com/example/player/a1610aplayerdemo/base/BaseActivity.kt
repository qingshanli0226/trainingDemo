package com.example.player.a1610aplayerdemo.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initData()
        initListener()
    }

    abstract fun getLayoutId(): Int


    abstract fun initData()
    abstract  fun initListener()
}
