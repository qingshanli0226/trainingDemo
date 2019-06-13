package com.example.player.a1610aplayerdemo.ui.fragment

import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.fragment_pay.*

/**
 * Created by Lmz on 2019/06/11
 */
class PayFragment :BaseFragment() {
    override fun initview(): View? {
        return View.inflate(context, R.layout.fragment_pay,null)
    }

    override fun initlistener() {
        super.initlistener()

    }
}