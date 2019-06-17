package com.example.player.a1610aplayerdemo.ui.activity

import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.LogOutBean
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.activity_logout.*
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/17
 *  用户退出页面
 */
class LogOutActivity :BaseActivity(),IBaseView<LogOutBean.DataBean>{

    var presenter =LogOutPresenter()
    override fun getLayoutId(): Int {
        return R.layout.activity_logout
    }

    override fun initlistener() {
        super.initlistener()
        presenter.attachView(this)
        logout_btn.setOnClickListener {
            //点我退出
            presenter.getDataByPost()
            SharePresenterUtils.savePhone("")
            finish()
        }
    }



    override fun loadDataSuccess(bean: LogOutBean.DataBean?) {

        toast("目前的身份是："+bean?.nickName)
    }

    override fun LoadListDataSuccess(data: MutableList<LogOutBean.DataBean>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadDataFailure(code: Int, ErrorMess: String?) {
        toast("有错误："+ErrorMess)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}