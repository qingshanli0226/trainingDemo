package com.example.player.a1610aplayerdemo.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class TuiJianVpgAdp(fm: FragmentManager?, var list:List<Fragment>,var  tt:List<String>) : FragmentPagerAdapter(fm) {



    override fun getItem(p0: Int): Fragment {
      return list.get(p0)
    }

    override fun getCount(): Int {
        return list.size
    }


}