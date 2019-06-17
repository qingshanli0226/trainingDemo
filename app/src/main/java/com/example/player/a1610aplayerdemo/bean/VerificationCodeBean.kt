package com.example.player.a1610aplayerdemo.bean

/**
 * Created by Lmz on 2019/06/16
 * 获取验证码的bean类
 */
data class VerificationCodeBean(
    val `data`: String,
    val code: String,
    val message: String,
    val success: Boolean
)