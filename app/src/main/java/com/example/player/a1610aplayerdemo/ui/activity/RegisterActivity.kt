package com.example.player.a1610aplayerdemo.ui.activity

import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.CheckRegisterBean
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity

/**
 * Created by Lmz on 2019/06/13
 *   注册页面
 */
class RegisterActivity:BaseActivity(),IBaseView<CheckRegisterBean> {

    var presenter =RegisterPresenter()
    override fun getLayoutId(): Int {
        return R.layout.activity_register
    }

    override fun initlistener() {
        super.initlistener()
        presenter.attachView(this)
        register_back_btn.setOnClickListener {
            onBackPressed()
        }
        register_next.setOnClickListener {
            startActivity<SetPasswordActivity>()
        }
        register_login.setOnClickListener {
            startActivity<LoginActivity>()
        }
        register_getinfo.setOnClickListener {
            var phone =register_phone.text.toString()
            presenter.setParare(phone)
            presenter.getData()
        }
    }

    override fun loadDataSuccess(bean: CheckRegisterBean?) {
        Log.d("register","code:"+bean?.data)

    }

    override fun LoadListDataSuccess(data: MutableList<CheckRegisterBean>?) {

    }

    override fun loadDataFailure(code: Int, ErrorMess: String?) {
        Log.d("register","code:"+code+"错误信息："+ErrorMess)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}