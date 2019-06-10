package com.example.player.a1610aplayerdemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast

abstract class BaseActivity : AppCompatActivity(),AnkoLogger{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListenter()
        initData()
    }

    abstract fun getLayoutId(): Int

    open protected fun initListenter() {

    }

   open protected fun initData() {

    }
   open protected fun myToast(msg:String){
        runOnUiThread{toast(msg)}
    }

}