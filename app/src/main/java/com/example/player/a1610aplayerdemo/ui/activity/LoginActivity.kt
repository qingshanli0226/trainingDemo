package com.example.player.a1610aplayerdemo.ui.activity

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

/**
 * Created by Lmz on 2019/06/13
 *  登录页面
 */
class LoginActivity:BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initlistener() {
        super.initlistener()
        login_back_btn.setOnClickListener {
            onBackPressed()
        }
        login_regisrer.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }
}