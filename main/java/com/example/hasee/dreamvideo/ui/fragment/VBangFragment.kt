package com.example.hasee.dreamvideo.ui.fragment

import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.example.hasee.dreamvideo.base.BaseFragment

/**
 * Created by Lmz on 2019/06/09
 */
class VBangFragment: BaseFragment() {
    override fun initview(): View? {

        val tv =TextView(context)
        tv.gravity= Gravity.CENTER
        tv.setTextColor(Color.RED)
        tv.text =javaClass.simpleName   //获取当前类名
        return  tv
    }
}