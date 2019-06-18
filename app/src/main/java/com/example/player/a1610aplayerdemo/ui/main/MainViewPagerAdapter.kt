package com.example.player.a1610aplayerdemo.ui.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.player.a1610aplayerdemo.ui.main.choice.ChoiceFragment
import com.example.player.a1610aplayerdemo.ui.my.MyFragment
import com.example.player.a1610aplayerdemo.ui.study.StudyFragment
import com.example.player.a1610aplayerdemo.ui.vip.VIPFragment

class MainViewPagerAdapter : FragmentPagerAdapter {
    var fms:MutableList<Fragment> = ArrayList()
    constructor(fm:FragmentManager):super(fm){
        fms.add(ChoiceFragment())
        fms.add(VIPFragment())
        fms.add(StudyFragment())
        fms.add(MyFragment())
    }
    override fun getCount(): Int = fms.size

    override fun getItem(p0: Int): Fragment {
        return fms[p0]
    }
}