package com.example.player.a1610aplayerdemo.ui.activity

import android.util.Log
import com.example.player.a1610aplayerdemo.base.BasePresenter
import com.example.player.a1610aplayerdemo.utils.Constans
import com.example.player.a1610aplayerdemo.utils.EntityUtils
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.HashMap

/**
 * Created by Lmz on 2019/06/17
 */
class LoginPresenter:BasePresenter<Boolean>() {

    var phone:String? =null

    fun setCheckPhone(phone:String){
        this.phone =phone
    }

    override fun getParmars(): HashMap<String, String> {
        var hashMap = hashMapOf<String,String>()
        Log.i("LoginPresenter","手机号"+phone)
        hashMap.put("loginName",phone!!)
        return hashMap
    }

    override fun getApiPath(): String {
        return "account"
    }

    override fun getApiPath2(): String {
       return "checkExists"
    }

    override fun getType(): Type {
       return object :TypeToken<EntityUtils<Boolean>>(){}.type
    }

    override fun isList(): Int {
        return Constans.DATA_TYPE_OBJECT
    }
}