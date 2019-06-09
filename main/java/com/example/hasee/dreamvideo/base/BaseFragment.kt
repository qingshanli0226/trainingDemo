package com.example.hasee.dreamvideo.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/08
 *  所有fragment 的基类
 */
abstract class BaseFragment:Fragment(),AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }
    /**
     * ftagment 初始化
     */
    open protected fun init() {

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initview();
    }

    /**
     * 获取布局
     * 此方法是 加载布局的方法 为必须实现的 所以为抽象的。
     * 类也是一样的
     */
    abstract fun initview(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initlistener()
        initdata()
    }

    /**
     *  不是必须实现的，
     *  主要进行 adapter 和listener 相关操作
     */
    open protected fun initlistener() {

    }

    /**
     * 数据的初始化  非必须
     */
    protected fun initdata(){}

    /**
     * toast 方法
     * 避免出现现成问题
     */
    open fun myToast(msg:String){
        context!!.runOnUiThread { toast(msg) }
    }
}