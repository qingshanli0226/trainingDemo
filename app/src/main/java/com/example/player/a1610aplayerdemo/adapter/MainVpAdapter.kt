package com.example.player.a1610aplayerdemo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.player.a1610aplayerdemo.fragment.AboutMyFragment
import com.example.player.a1610aplayerdemo.fragment.MemberFragment
import com.example.player.a1610aplayerdemo.fragment.Select_classFragment
import com.example.player.a1610aplayerdemo.fragment.StudyFragment

class MainVpAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    private var list = listOf(Select_classFragment(),StudyFragment(),MemberFragment(),AboutMyFragment())
    private var title = listOf<String>("选课","学习中心","会员","我的")
    override fun getItem(p0: Int): Fragment {
       return list.get(p0);
    }

    override fun getCount(): Int {
     return list.count();
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return title.get(position)
    }
}