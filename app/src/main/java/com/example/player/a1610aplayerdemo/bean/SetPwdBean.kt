package com.example.player.a1610aplayerdemo.bean

import java.io.Serializable

/**
 * Created by Lmz on 2019/06/17
 *  设置密码的bean类
 */
data class SetPwdBean (
    val `data`: Data,
    val code: String,
    val message: String,
    val success: Boolean

):Serializable

data class Data (
    val avatar: String,
    val courseInfo: CourseInfo,
    val gender: Int,
    val login: Boolean,
    val nickName: String,
    val passportId: Int,
    val ranking: Int,
    val score: Int
):Serializable

data class CourseInfo(
    val cardId: Int,
    val courseId: Int,
    val existCourse: Boolean,
    val noPay: Boolean
):Serializable