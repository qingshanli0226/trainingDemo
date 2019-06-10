package com.example.player.a1610aplayerdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by Lmz on 2019/06/10
 */
abstract class BaseActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initlistener()
        initdata()
    }

    /**
     * 添加数据
     */
    protected fun initdata(){}
    /**
     * 监听方法
     */
    protected fun initlistener(){}

    /**
     * 必须写
     */
    abstract fun getLayoutId():Int

}