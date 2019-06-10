package com.example.player.a1610aplayerdemo.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.player.a1610aplayerdemo.choice.ChoiceFragment
import com.example.player.a1610aplayerdemo.my.MyFragment
import com.example.player.a1610aplayerdemo.study.StudyFragment
import com.example.player.a1610aplayerdemo.vip.VIPFragment

class MainViewPagerAdapter : FragmentPagerAdapter {
    var fms:MutableList<Fragment> = ArrayList()
    constructor(fm:FragmentManager):super(fm){
        fms.add(ChoiceFragment())
        fms.add(StudyFragment())
        fms.add(VIPFragment())
        fms.add(MyFragment())
    }
    override fun getCount(): Int = fms.size

    override fun getItem(p0: Int): Fragment {
        return fms[p0]
    }
}