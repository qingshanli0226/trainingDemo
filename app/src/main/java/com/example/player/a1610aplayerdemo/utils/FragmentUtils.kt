package com.example.player.a1610aplayerdemo.utils

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.fragment.*
import com.example.player.a1610aplayerdemo.fragment.Home.HomeFragment

class FragmentUtils private constructor(){

    val homeFragment by lazy { HomeFragment() }
    val studyFragment by lazy { StudyFragment() }
    val mvFragment by lazy { MvFragment() }
    val yueDanFragment by lazy { YueDanFragment() }


    companion object {
        val fragmentUtils by lazy{FragmentUtils()}
    }
    fun getFragment(tabId:Int):BaseFragment {
            when(tabId){
                R.id.tab_home -> return homeFragment
                R.id.tab_mv -> return mvFragment
                R.id.tab_vbang ->return studyFragment
                R.id.tab_yuedan ->return yueDanFragment
            }
        return homeFragment
    }
}