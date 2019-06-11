package com.example.player.a1610aplayerdemo.mainactivity.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.player.a1610aplayerdemo.fragment.AboutMy_Fragment
import com.example.player.a1610aplayerdemo.fragment.member.Member_Fragment
import com.example.player.a1610aplayerdemo.fragment.Study_Fragment
import com.example.player.a1610aplayerdemo.fragment.selectclass.SelectClass_Fragment

class MainVpAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
  // 存放 fragment 可读的集合
    private var list = listOf(SelectClass_Fragment(), Study_Fragment(),
      Member_Fragment(), AboutMy_Fragment())

    override fun getItem(p0: Int): Fragment {
       return list.get(p0);
    }

    override fun getCount(): Int {
     return list.count();
    }

}