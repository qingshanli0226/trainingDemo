package com.example.player.a1610aplayerdemo.adapter.viewpager_adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

class GuidePagerAdapter(val context: Context, val picsList:MutableList<ImageView>) : PagerAdapter() {

    override fun isViewFromObject(p0: View, p1: Any): Boolean = (p0 === p1)

    override fun getCount(): Int = picsList.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(picsList[position])
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(picsList[position])
        return picsList[position]
    }
}