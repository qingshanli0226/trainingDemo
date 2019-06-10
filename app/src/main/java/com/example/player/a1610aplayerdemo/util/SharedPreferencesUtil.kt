package com.example.player.a1610aplayerdemo.util

import android.app.Activity
import android.content.Context
import android.content.Context.MODE_MULTI_PROCESS
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.example.player.a1610aplayerdemo.ui.activity.SplashActivity

class SharedPreferencesUtil {

    var myApplication:MyApplication

    constructor(myApplication: MyApplication) {
        this.myApplication = myApplication
    }


    fun SharedPreferencesSave2String(key: String, info: String): Unit {
        var sp: SharedPreferences = myApplication.getSharedPreferences(key, MODE_PRIVATE)
        var et: SharedPreferences.Editor = sp.edit()
        et.putString(key, info)
        et.commit()
    }


    fun SharedPreferencesGet2String(key: String): String {
        var sp: SharedPreferences = myApplication.getSharedPreferences(key, MODE_PRIVATE)
        var result: String = sp.getString(key, "")
        if (!"".equals(result)) {
            return result
        } else {
            return ""
        }
    }

}