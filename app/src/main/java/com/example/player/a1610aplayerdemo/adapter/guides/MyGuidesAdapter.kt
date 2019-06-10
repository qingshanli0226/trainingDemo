package com.example.player.a1610aplayerdemo.adapter.guides

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

class MyGuidesAdapter(context:Context, var guides: ArrayList<View>?) : PagerAdapter() {

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1;
    }

    override fun getCount(): Int {
        return guides!!.size;
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        container.addView(guides?.get(position));
        return guides!!.get(position);
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(guides?.get(position));
    }

}