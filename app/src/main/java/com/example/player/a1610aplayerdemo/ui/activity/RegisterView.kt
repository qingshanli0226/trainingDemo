package com.example.player.a1610aplayerdemo.ui.activity

import com.example.player.a1610aplayerdemo.base.IBaseView
import com.example.player.a1610aplayerdemo.bean.CheckRegisterBean
import com.example.player.a1610aplayerdemo.bean.VerificationCodeBean

/**
 * Created by Lmz on 2019/06/17
 *
 */
interface RegisterView{
    fun getVerificationCodeSuccess(bean:VerificationCodeBean)
    fun getVerificationCodeFailure(code:Int,error:String)


    fun CommitPhoneAndCodeSuccess(bean:VerificationCodeBean)
    fun CommitPhoneAndCodeFailure(code: Int,error:String)
}