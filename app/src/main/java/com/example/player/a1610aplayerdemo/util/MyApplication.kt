package com.example.player.a1610aplayerdemo.util

import android.app.Application
import android.content.Context

class MyApplication: Application() {

    companion object {
        var context:Application? = null
        fun getContext():Context{
            return context!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }

}