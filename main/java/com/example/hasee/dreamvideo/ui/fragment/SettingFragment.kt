package com.example.hasee.dreamvideo.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.preference.SwitchPreference
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.ui.activity.AboutActivity

/**
 * Created by Lmz on 2019/06/08
 *  设置页面的 条目
 */
class SettingFragment: PreferenceFragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        //设置一个 xml布局
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        val key = preference?.key
        if ("about".equals(key)){
            println("点击了关于")
            //这里跳转到关于页面
            activity.startActivity(Intent(activity,AboutActivity::class.java))  //这里用一种新的跳转方式
        }else if ("logout".equals(key)){
            println("点击了退出")
        }else if ("clear_cache".equals(key)){
            println("点击了清除缓存")
        }


        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}