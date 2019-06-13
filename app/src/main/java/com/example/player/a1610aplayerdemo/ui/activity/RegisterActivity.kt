package com.example.player.a1610aplayerdemo.ui.activity

import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity

/**
 * Created by Lmz on 2019/06/13
 *   注册页面
 */
class RegisterActivity:BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initlistener() {
        super.initlistener()
        register_back_btn.setOnClickListener {
            onBackPressed()
        }
        register_next.setOnClickListener {
            startActivity<SetPasswordActivity>()
        }
        register_login.setOnClickListener {
            startActivity<LoginActivity>()
        }


    }
}