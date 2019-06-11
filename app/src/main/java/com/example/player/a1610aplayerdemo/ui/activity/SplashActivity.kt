package com.example.player.a1610aplayerdemo.ui.activity

import android.util.Log
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.FirstInBean
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils

/**
 * Created by Lmz on 2019/06/11
 *   引导页
 */
class SplashActivity :BaseActivity(),IBaseView<FirstInBean>{
    val presenter by lazy { ISplashPresenter() }
    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initlistener() {
        super.initlistener()

        presenter.attachView(this)
        presenter.getData()
    }

    /**
     * 获取数据
     *  里面有 是否是游客 字段，token ,头像 等字段，
     *  是否登录
     */
    override fun loadDataSuccess(bean: FirstInBean?) {
            var code=bean?.code
            if ("success".equals(code)){
                //获取数据是正确的
                val data = bean?.data;
                //保存token
                SharePresenterUtils.saveToken(data?.accessToken)
            }
    }

    override fun loadDataFailure(code: Int, ErrorMess: String?) {
            Log.d("lmz","错误原因"+ErrorMess);
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

}