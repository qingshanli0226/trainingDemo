package com.example.player.a1610aplayerdemo.ui.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class VpgFragmentAdp(fm: FragmentManager? ,var list:List<Fragment>) : FragmentPagerAdapter(fm) {



    override fun getItem(p0: Int): Fragment {
      return list.get(p0)
    }

    override fun getCount(): Int {
        return list.size
    }


}