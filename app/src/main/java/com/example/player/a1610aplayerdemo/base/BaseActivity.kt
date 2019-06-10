package com.example.player.a1610aplayerdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(),AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        initListener();
        initData();

        
    }

    /*
    * 初始化数据
    * */
    protected fun initData() {

    }

    /*
   *  adapter listener
   * */
    protected fun initListener() {

    }

    abstract fun getLayoutId(): Int


    protected fun myToast(msg:String){
        runOnUiThread { toast(msg) }
    }


}