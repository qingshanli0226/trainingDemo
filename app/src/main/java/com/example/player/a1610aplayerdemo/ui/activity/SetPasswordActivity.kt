package com.example.player.a1610aplayerdemo.ui.activity

import android.text.TextUtils
import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.SetPwdBean
import com.example.player.a1610aplayerdemo.utils.EntityUtils
import kotlinx.android.synthetic.main.activity_setpwd.*
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/13
 * 设置密码的页面
 */
class SetPasswordActivity : BaseActivity(), IBaseView<EntityUtils<SetPwdBean>> {

    var presenter = SetPwdPresenter()
    override fun getLayoutId(): Int {
        return R.layout.activity_setpwd
    }

    override fun initlistener() {
        super.initlistener()

        presenter.attachView(this)


        setpwd_login_btn.setOnClickListener {
            var pwd = setpwd_inputpwd.text.toString().trim()
            var pwd2 = setpwd_inputpwd_commit.text.toString().trim()
            if (TextUtils.isEmpty(pwd) || TextUtils.isEmpty(pwd2)) {
                toast("输入不可为空")
                return@setOnClickListener
            }

            if (!pwd.equals(pwd2)) {
                toast("两次密码不一致")
                return@setOnClickListener
            }

            presenter.setpwd(pwd)
            presenter.getDataByPost()

        }
    }


    override fun loadDataSuccess(bean: EntityUtils<SetPwdBean>?) {
            Log.i("code","code:"+bean?.code)
    }

    override fun LoadListDataSuccess(data: MutableList<EntityUtils<SetPwdBean>>?) {

    }

    override fun loadDataFailure(code: Int, ErrorMess: String?) {
        Log.i("code","code:"+code+"错误信息是："+ErrorMess)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}