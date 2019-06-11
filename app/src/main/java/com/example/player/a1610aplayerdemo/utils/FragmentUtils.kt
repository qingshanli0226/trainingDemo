package com.example.player.a1610aplayerdemo.utils

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.ui.fragment.FindFragment
import com.example.player.a1610aplayerdemo.ui.fragment.MeFragment
import com.example.player.a1610aplayerdemo.ui.fragment.PayFragment
import com.example.player.a1610aplayerdemo.ui.fragment.VipFragment

/**
 * Created by Lmz on 2019/06/11
 *  fragment 管理类
 */
class FragmentUtils private constructor(){
    // private constructor()  私有化
    //惰性加载
    val findf by lazy { FindFragment() }
    val vipf by lazy { VipFragment() }
    val payf by lazy { PayFragment() }
    val mef by lazy { MeFragment() }

    companion object {
        val fragmentUtils by lazy { FragmentUtils() }
    }
    //创建切换的方法
    fun SelectFragment(id:Int):BaseFragment{
        when (id){
            R.id.tab_find ->return findf
            R.id.tab_vip ->return vipf
            R.id.tab_ispay->return payf
            R.id.tab_me ->return mef
        }
        return findf
    }

}