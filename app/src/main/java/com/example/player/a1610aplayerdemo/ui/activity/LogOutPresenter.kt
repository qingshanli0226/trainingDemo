package com.example.player.a1610aplayerdemo.ui.activity

import com.example.player.a1610aplayerdemo.base.BasePresenter
import com.example.player.a1610aplayerdemo.bean.LogOutBean
import com.example.player.a1610aplayerdemo.utils.Constans
import com.example.player.a1610aplayerdemo.utils.EntityUtils
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.HashMap

/**
 * Created by Lmz on 2019/06/17
 *   POST http://api.immedc.com/restapi/account/signOut HTTP/1.1
 */
class LogOutPresenter :BasePresenter<LogOutBean.DataBean>(){
    override fun getApiPath(): String {
        return "account"
    }

    override fun getApiPath2(): String {
       return "signOut"
    }

    override fun getType(): Type {
        return object :TypeToken<EntityUtils<LogOutBean.DataBean>>(){}.type
    }

    override fun isList(): Int {
        return Constans.DATA_TYPE_OBJECT
    }

    override fun getHearder(): HashMap<String, String> {
        return SharePresenterUtils.getHeardData()
    }
}