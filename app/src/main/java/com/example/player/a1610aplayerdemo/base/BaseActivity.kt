package com.example.player.a1610aplayerdemo.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/10
 */
abstract class BaseActivity :AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initlistener()
        initdata()
    }

    /**
     * 添加数据
     */
    open protected fun initdata(){}
    /**
     * 监听方法
     */
    open protected fun initlistener(){}

    /**
     * 必须写
     */
    abstract fun getLayoutId():Int

    /**
     * 跳转页面并关闭当前页面
     */
    inline fun <reified T:BaseActivity> startActivityAndFinainsh(){
        startActivity<T>()
        finish()
    }

    /**
     * 销毁的页面
     */
    open protected  fun OnDestory(){

    }
}