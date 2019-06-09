package com.example.hasee.dreamvideo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/08
 *  所有activity的基类
 */
abstract class  BaseActivity: AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initlistener()
        initdata()
    }

    /**
     *  普通添加数据方法，
     *  子类根据需要去判断是否需要实现
     */
    open protected fun initdata() {
    }

    /**
     *   普通的监听方法类
     *    根据需求可实现 可不实现
     */
    open protected fun initlistener() {

    }

    /**
     * 获取布局的ID
     * 设置为抽象方法 子类必须实现
     */
    abstract fun getLayoutId(): Int

    /**
     * 定义一个吐司的方法
     *   kotlin  自带吐司方法，但是为了避免有些地方调用吐司方法出现线程问题。
     *   所以我们自己直接给他UI线程toast
     */
    open protected fun MyToast(msg:String){
        runOnUiThread { toast(msg) }
    }

    /**
     * 跳转页面并结束掉
     */
    inline fun < reified  T:BaseActivity>startActivityAndFinish(){
        startActivity<T>()
        finish()
    }
}