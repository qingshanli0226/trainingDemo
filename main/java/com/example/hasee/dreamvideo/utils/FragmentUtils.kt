package com.example.hasee.dreamvideo.utils

import com.example.hasee.dreamvideo.R
import com.example.hasee.dreamvideo.base.BaseFragment
import com.example.hasee.dreamvideo.ui.fragment.HomeFragment
import com.example.hasee.dreamvideo.ui.fragment.MVFragment
import com.example.hasee.dreamvideo.ui.fragment.VBangFragment
import com.example.hasee.dreamvideo.ui.fragment.YueDanFragment

/**
 * Created by Lmz on 2019/06/09
 *   fragment管理类 做成单例模式
 *   1.私有化
 */
class FragmentUtils private constructor(){ //这里就是私有化构造方法
    //  创建我们需要返回的  fragment 全部使用惰性加载 避免多次加载
    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MVFragment() }
    val vbangFragment by lazy { VBangFragment() }
    val yuedanFragment by lazy { YueDanFragment() }
    companion object {
        //因为是惰性加载  只创建一次
        val fragmentUtils by lazy { FragmentUtils() }
    }
    /**
     * 创建切换方法。
     * 根据 tabID获取对应的 fragment
     */
    fun getFragment(tabId:Int):BaseFragment{
        when(tabId){
            R.id.tab_home ->return homeFragment
            R.id.tab_mv   -> return mvFragment
            R.id.tab_vbang-> return vbangFragment
            R.id.tab_yuedan->return yuedanFragment
        }
        return homeFragment
    }
}