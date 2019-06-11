package com.example.player.a1610aplayerdemo.ui.fragment

import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment

/**
 * Created by Lmz on 2019/06/11
 */
class MeFragment :BaseFragment() {
    override fun initview(): View? {
        return View.inflate(context, R.layout.fragment_me,null)
    }
}