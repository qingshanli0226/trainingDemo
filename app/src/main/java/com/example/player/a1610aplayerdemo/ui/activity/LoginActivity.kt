package com.example.player.a1610aplayerdemo.ui.activity

import android.content.Intent
import android.text.TextUtils
import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.LoginUserInfoBean
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import kotlin.math.log

/**
 * Created by Lmz on 2019/06/13
 *  登录页面
 */
class LoginActivity:BaseActivity(),IBaseView<Boolean>,LoginView {

    var loginP :LoginPresenter2 = LoginPresenter2(this)
    var presenter:LoginPresenter = LoginPresenter()
    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initlistener() {
        super.initlistener()
        presenter.attachView(this)
        login_back_btn.setOnClickListener {
            onBackPressed()
        }
        login_regisrer.setOnClickListener {
            startActivity<RegisterActivity>()
        }
        login_password.setOnClickListener {
            var phone =login_phone.text.toString().trim();
            presenter.setCheckPhone(phone)
            presenter.getDataByPost()
        }

        login_btn.setOnClickListener {
            var phone =login_phone.text.toString().trim();
            var pwd=  login_password.text.toString().trim()
            if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(pwd)){
                toast("输入不可以为空")
                return@setOnClickListener
            }
            loginP.LoginUser(phone,pwd)
        }

    }


    override fun loadDataSuccess(bean: Boolean?) {
        if (bean!!){
            toast("注册过")
        }else{
            toast("尚未注册")
        }
    }

    override fun LoadListDataSuccess(data: MutableList<Boolean>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadDataFailure(code: Int, ErrorMess: String?) {

    }

    //登录的
    override fun LoginUserSuccess(bean: LoginUserInfoBean?) {
        if ("success".equals(bean?.code)){
            toast("登录成功")
            SharePresenterUtils.saveUserInfo(bean)
            var intent= Intent()
            intent.setClass(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            toast("账户或密码错误")
        }
    }

    override fun LoginUserFailure(error: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        loginP.OnDestry()
    }
}