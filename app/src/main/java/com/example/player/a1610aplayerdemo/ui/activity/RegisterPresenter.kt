package com.example.player.a1610aplayerdemo.ui.activity

import com.example.player.a1610aplayerdemo.base.BasePresenter
import com.example.player.a1610aplayerdemo.bean.CheckRegisterBean
import com.example.player.a1610aplayerdemo.utils.Constans
import com.example.player.a1610aplayerdemo.utils.EntityUtils
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.HashMap

/**
 * Created by Lmz on 2019/06/15
 */
class RegisterPresenter: BasePresenter<CheckRegisterBean>() {

    var phone="PHONE"
    fun setParare(phone:String){
        this.phone = phone
    }
    override fun getParmars(): HashMap<String, String> {
        var hashMap = hashMapOf<String,String>()
        hashMap.put("loginName",phone)
        return hashMap
    }

    override fun getApiPath(): String {
        return "account"
   }

    override fun getApiPath2(): String {
       return "checkExists"
    }

    override fun getType(): Type {
        var type=object : TypeToken<CheckRegisterBean>(){}.type
        return type
    }

    override fun isList(): Int {
        return Constans.DATA_TYPE_BOOLEAN
    }

}