package com.example.player.a1610aplayerdemo.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.player.a1610aplayerdemo.MyApp
import com.example.player.a1610aplayerdemo.ui.fragment.MyFragment
import com.example.player.a1610aplayerdemo.ui.fragment.StudyCenterFragment
import com.example.player.a1610aplayerdemo.ui.fragment.VipFragment
import com.example.player.a1610aplayerdemo.ui.fragment.XuanKeFragment

class VpgFragmentAdp : FragmentPagerAdapter{


    var fragments: MutableList<Fragment> = ArrayList()

    constructor(fm: FragmentManager) : super(fm) {
        fragments.add(XuanKeFragment())
        fragments.add(StudyCenterFragment())
        fragments.add(VipFragment())
        fragments.add(MyFragment())

    }

    override fun getItem(p0: Int): Fragment {
        return fragments[p0]
    }

    override fun getCount(): Int  = fragments.size
}