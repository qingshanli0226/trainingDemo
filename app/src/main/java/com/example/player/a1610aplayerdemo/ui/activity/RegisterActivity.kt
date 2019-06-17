package com.example.player.a1610aplayerdemo.ui.activity

import android.os.Handler
import android.support.v4.content.ContextCompat.startActivity
import android.text.TextUtils
import android.util.Log
import android.widget.Toast
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.R.id.*
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.CheckRegisterBean
import com.example.player.a1610aplayerdemo.bean.VerificationCodeBean
import com.example.player.a1610aplayerdemo.utils.EntityUtils
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast


/**
 * Created by Lmz on 2019/06/13
 *   注册页面
 */
class RegisterActivity : BaseActivity(), IBaseView<Boolean>,RegisterView {



    private var code =""
    private var presenter = RegisterPresenter()
    private var timeCode =60
    private  var codePresenter = VrificationCodePresenter(this)
    private var mHandler:Handler=Handler()

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
            var phone = register_phone.text.toString()
            presenter.setParare(phone)
            presenter.getData()
        }
        register_next.setOnClickListener {
            var phone = register_phone.text.toString().trim()
            var vrifiCode = register_password.text.toString().trim()
                if (register_check.isChecked){
                    SharePresenterUtils.savePhone(phone)
                    codePresenter.CheckCodeAndPhone(phone,vrifiCode)
                }else{
                    toast("请先阅读协议")
                }

        }
        CheckInput()
    }

    private val countDown = object :Runnable{
        override fun run() {
            if (timeCode>0){
                mHandler.postDelayed(this,1000)
                register_getinfo.isEnabled =false
                register_getinfo.text=""+timeCode+"秒后重新获取"
                CheckInput()
            }else{
                mHandler.removeCallbacks(this)
                timeCode =60
                CheckInput()
                register_getinfo.text="获取验证码"
                register_getinfo.isEnabled =true
            }
            timeCode--
        }
    }

    // 检查是否满足 释放按钮点击
    fun CheckInput(){
        var phone = register_phone.text.toString().trim()
        var vrifiCode = register_password.text.toString().trim()
        if (TextUtils.isEmpty(phone)||TextUtils.isEmpty(vrifiCode)){
            register_next.isEnabled = false
            return
        }
        register_next.isEnabled = true
    }

    override fun loadDataSuccess(bean: Boolean) {
        Log.i("code","code:"+bean);
        if (bean) {
            //注册过
            toast("该用户已经注册过了。请直接登录")
        } else {
            //没有注册过
            codePresenter.getVrificationCode(register_phone.text.toString(),"1")
            CheckInput()
        }

    }

    override fun LoadListDataSuccess(data: MutableList<Boolean>?) {

    }


    override fun loadDataFailure(code: Int, ErrorMess: String?) {
        Log.d("register", "code:" + code + "错误信息：" + ErrorMess)
    }


    override fun getVerificationCodeSuccess(bean: VerificationCodeBean) {
           Log.d("code",""+bean.code)
        if ("Unknow".equals(bean.code)){
            toast(bean.message)
            return
        }
             code = bean.code

             SharePresenterUtils.saveCode(bean.code)
            mHandler.postDelayed(countDown,0)
    }

    override fun getVerificationCodeFailure(code: Int, error: String) {
        Log.d("register", "code:" + code + "错误信息：" + error)
    }

    // 验证手机号和验证码
    override fun CommitPhoneAndCodeFailure(code: Int, error: String) {
        Log.d("register", "code:" + code + "错误信息：" + error)
    }

    override fun CommitPhoneAndCodeSuccess(bean: VerificationCodeBean) {
            if("success".equals(bean.code)){
                startActivity<SetPasswordActivity>()
            }else{
                toast("验证失败")
            }
    }


    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
        codePresenter.DestroyView()
    }


}