package com.example.player.a1610aplayerdemo.ui.fragment

import android.transition.Visibility
import android.view.View
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.ui.activity.LoginActivity
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.fragment_pay.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Lmz on 2019/06/11
 */
class PayFragment :BaseFragment() {
    override fun initview(): View? {
        return View.inflate(context, R.layout.fragment_pay,null)
    }

    override fun initlistener() {
        super.initlistener()
        pay_login_btn.setOnClickListener {
            startActivity<LoginActivity>()
        }

        var user=SharePresenterUtils.getUserInfo()
        if (user!=null){
            pay_login.visibility=View.GONE
        }else{
            pay_login.visibility=View.VISIBLE
        }

    }
}