package com.example.player.a1610aplayerdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lmz on 2019/06/11
 *  创建 sp 工具类
 */
public class SharePresenterUtils {
   private static SharedPreferences sp;
   public static  void init(Context context){
       sp =context.getSharedPreferences(Constans.YX_USER,Context.MODE_PRIVATE);
   }

    /**
     *  保存token 到 SP
      * @param token
     */
   public static void saveToken(String token){
       sp.edit().putString(Constans.TOKEN,token).commit();
    }
    /**
     * 从sp当中 取出token
     */
    public static String getToken(){
        String token = sp.getString(Constans.TOKEN, "");
        return token;
    }

    /**
     * 保存头像
     */
    public static void saveAvatar(String imgUri){
        sp.edit().putString(Constans.USER_AVATAR,imgUri).commit();
    }
    /**
     * 取出头像
     */
    public static String getAvatar(){
        return sp.getString(Constans.USER_AVATAR,"");
    }

    /**
     * 保存下验证码
     */
    public static void saveCode(String code){
        sp.edit().putString("code",code).commit();
    }
    /**
     * 取出验证码
     */
    public static String getCode(){
        return sp.getString("code","");
    }
    /**
     * 保存手机号
     */
    public static void savePhone(String phone){
        sp.edit().putString("phone",phone).commit();
    }
    public static String getPhone(){
        return sp.getString("phone","");
    }


}
