package com.example.player.a1610aplayerdemo.ui.fragment

import android.content.Intent
import android.text.TextUtils
import android.view.TextureView
import android.view.View
import com.bumptech.glide.Glide
import com.example.player.a1610aplayerdemo.R
import com.example.player.a1610aplayerdemo.base.BaseFragment
import com.example.player.a1610aplayerdemo.ui.activity.GoodsInfoActivity
import com.example.player.a1610aplayerdemo.ui.activity.LogOutActivity
import com.example.player.a1610aplayerdemo.ui.activity.LoginActivity
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import kotlinx.android.synthetic.main.fragment_me.*
import org.jetbrains.anko.support.v4.startActivity

/**
 * Created by Lmz on 2019/06/11
 */
class MeFragment :BaseFragment() {
    override fun initview(): View? {
        return View.inflate(context, R.layout.fragment_me,null)
    }
    override fun initlistener() {
        super.initlistener()

        me_avatar.setOnClickListener {
            startActivity<LoginActivity>()
        }
        me_text_login.setOnClickListener {
            startActivity<LoginActivity>()
        }
        me_setting.setOnClickListener {
            //这里是退出
            var intent =Intent()
            intent.setClass(context,LogOutActivity::class.java)
            startActivity(intent)
        }
        me_text_setting.setOnClickListener {
            var intent =Intent()
            intent.setClass(context,GoodsInfoActivity::class.java)
            startActivity(intent)
        }
    }
    override fun initdata() {
        super.initdata()
        var user=  SharePresenterUtils.getUserInfo()
        var avatarString=""
        if (user==null){
            avatarString = SharePresenterUtils.getAvatar()
        }else{
            if (user.avatar==null){
                avatarString = SharePresenterUtils.getAvatar()
            }else{
                avatarString=user.avatar
                me_text_login.text =  user.nickName
            }

        }




        Glide.with(context).load(avatarString).into(me_avatar)

    }
}