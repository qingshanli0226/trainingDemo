package com.example.player.a1610aplayerdemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.player.a1610aplayerdemo.fragment.AboutMyFragment
import com.example.player.a1610aplayerdemo.fragment.MemberFragment
import com.example.player.a1610aplayerdemo.fragment.Select_classFragment
import com.example.player.a1610aplayerdemo.fragment.StudyFragment

class MainVpAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {
  // 存放 fragment 可读的集合
    private var list = listOf(Select_classFragment(),StudyFragment(),MemberFragment(),AboutMyFragment())

    override fun getItem(p0: Int): Fragment {
       return list.get(p0);
    }

    override fun getCount(): Int {
     return list.count();
    }

}