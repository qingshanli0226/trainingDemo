package com.example.player.a1610aplayerdemo.ui.fragment

import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.ui.activity.LoginActivity
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Lmz on 2019/06/11
 */
class MeFragment :BaseFragment() {
    override fun initview(): View? {
        return View.inflate(context, R.layout.fragment_me,null)
    }

    override fun initlistener() {
        super.initlistener()
        me_avatar.setOnClickListener {
            startActivity<LoginActivity>()
        }
        me_text_login.setOnClickListener {
            startActivity<LoginActivity>()
        }
    }
}