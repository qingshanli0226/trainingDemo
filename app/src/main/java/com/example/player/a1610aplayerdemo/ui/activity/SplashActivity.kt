package com.example.player.a1610aplayerdemo.ui.activity

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import com.bumptech.glide.Glide
import com.example.player.a1610aplayerdemo.MyApplication
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseActivity
import com.example.player.a1610aplayerdemo.bean.FirstInBean
import com.example.player.a1610aplayerdemo.bean.SplashBean
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_splash.*
import org.jetbrains.anko.toast

/**
 * Created by Lmz on 2019/06/11
 *   引导页
 */
class SplashActivity :BaseActivity(),ISplashView<String>{

    private val mHandler:Handler =object :Handler(Looper.getMainLooper()){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
            if (msg?.what==1){
                //跳转页面
                startActivityAndFinainsh<BannerActivity>()
            }
        }
    }

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
    override fun loadDataSuccess(bean: String?) {
        //  kotlin 方式的 gson 解析
        var s: FirstInBean =Gson().fromJson(bean,FirstInBean::class.java);
        var code=s.code
        if ("success".equals(code)){
            //成功
            var data=s.data
            SharePresenterUtils.saveToken(data.accessToken);
            presenter.getSplash()
        }else{
            //失败
            toast("失败了")
        }

    }

    override fun loadDataFailure(code: Int, ErrorMess: String?) {
            Log.d("lmz","错误原因"+ErrorMess);
    }

    //想到页
    override fun loadSplashSuccess(bean: String?) {
                var s:SplashBean=Gson().fromJson(bean,SplashBean::class.java);
                var code=s.code;
                if ("success".equals(code)){
                    //成功
                    var data=s.data
                    var img=data.bannerUrl
                    Glide.with(MyApplication.getContext()).load(img).into(splash_img);
                    mHandler.sendEmptyMessageDelayed(1,4000)

                }else{
                    //失败
                    toast("失败了")
                }
    }
    override fun loadSplashFailure(mess: String?) {
        Log.d("lmz","错误原因"+mess);
    }
    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}