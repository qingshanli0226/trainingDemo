package com.example.player.a1610aplayerdemo.fragment


import android.content.Intent
import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.activity.StudyActivity
import com.example.player.a1610aplayerdemo.base.BaseFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class SettingFragment : PreferenceFragment() {

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
            activity.startActivity(Intent(activity,StudyActivity::class.java))  //这里用一种新的跳转方式
        }else if ("logout".equals(key)){
            println("点击了退出")
        }else if ("clear_cache".equals(key)){
            println("点击了清除缓存")
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}
