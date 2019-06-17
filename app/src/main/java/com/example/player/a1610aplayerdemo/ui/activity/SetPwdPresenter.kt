package com.example.player.a1610aplayerdemo.ui.activity

import android.os.Build
import com.example.player.a1610aplayerdemo.base.BasePresenter
import com.example.player.a1610aplayerdemo.bean.SetPwdBean
import com.example.player.a1610aplayerdemo.utils.Constans
import com.example.player.a1610aplayerdemo.utils.EntityUtils
import com.example.player.a1610aplayerdemo.utils.PhoneUtils
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.HashMap

/**
 * Created by Lmz on 2019/06/17
 *  设置密码
 */
class SetPwdPresenter :BasePresenter<EntityUtils<SetPwdBean>>(){

    var pwd="PHONE"
    fun setpwd(pwd:String){
        this.pwd = pwd
    }
    override fun getApiPath(): String {
       return "account"
    }

    override fun getApiPath2(): String {
        return "signUp"
    }

    override fun getType(): Type {
        var type=object :TypeToken<EntityUtils<SetPwdBean>>(){}.type
        return type
    }

    override fun isList(): Int {
        return Constans.DATA_TYPE_OBJECT
    }

    override fun getParmars(): HashMap<String, String> {
        var map = hashMapOf<String,String>()
       // map.put("token",SharePresenterUtils.getToken())
        map.put("identifyingCode",SharePresenterUtils.getCode())
        map.put("mobilePhone",SharePresenterUtils.getPhone())
        map.put("password",pwd)
        return map
    }

    override fun getHearder(): HashMap<String, String> {
        var map = hashMapOf<String,String>()
        map.put("DeviceKey", PhoneUtils.getDeviceKye())
        val sdkInt = Build.VERSION.SDK_INT
        val sdk = "" + sdkInt
        map.put("Android-VersionCode","43")
        map.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8")
        map.put("Tingyun_Process","true")
        map.put("Cache-Control","max-age=604800000")
        map.put("Android-channel","guoyun")
        map.put("User-Agent","Dalvik/2.1.0 (Linux; U; Android 6.0.1; MI 6 Build/V417IR)")


        return map
    }

}