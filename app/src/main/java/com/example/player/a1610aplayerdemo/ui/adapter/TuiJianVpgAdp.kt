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

class TuiJianVpgAdp(fm: FragmentManager?, var list:List<Fragment>,var  tt:List<String>) : FragmentPagerAdapter(fm) {



    override fun getItem(p0: Int): Fragment {
      return list.get(p0)
    }

    override fun getCount(): Int {
        return list.size
    }


}