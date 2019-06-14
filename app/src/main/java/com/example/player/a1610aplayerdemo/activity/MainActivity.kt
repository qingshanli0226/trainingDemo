package com.example.player.a1610aplayerdemo.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.adapter.FGAdapter
import com.example.player.a1610aplayerdemo.fragment.BlankFragment01
import com.example.player.a1610aplayerdemo.fragment.BlankFragment02
import com.example.player.a1610aplayerdemo.fragment.BlankFragment03
import com.example.player.a1610aplayerdemo.fragment.BlankFragment04

import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Fragment>()
//!!当前对象不为空
//？当前对象可以为空

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {

        nBar
            .setBarBackgroundColor("#8E002E")
            .setActiveColor("#ffffff")
            .setInActiveColor("#808080")
            .addItem(BottomNavigationItem(R.mipmap.ic02, "选课"))
            .addItem(BottomNavigationItem(R.mipmap.ic04, "会员"))
            .addItem(BottomNavigationItem(R.mipmap.ic03, "选购"))
            .addItem(BottomNavigationItem(R.mipmap.ic01, "沃德"))
            .setFirstSelectedPosition(0)//默认选中位置
            .initialise()//提交初始化

        list.add(BlankFragment01())
        list.add(BlankFragment02())
        list.add(BlankFragment03())
        list.add(BlankFragment04())

        val fgAdapter = FGAdapter(supportFragmentManager, list)
        vp.setAdapter(fgAdapter)
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(i: Int, v: Float, i1: Int) {

            }

            override fun onPageSelected(i: Int) {
                nBar.selectTab(i)
            }

            override fun onPageScrollStateChanged(i: Int) {

            }
        })
        nBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabSelected(position: Int) {
                vp.setCurrentItem(position)
            }

            override fun onTabUnselected(position: Int) {

            }

            override fun onTabReselected(position: Int) {

            }
        })


    }
}
