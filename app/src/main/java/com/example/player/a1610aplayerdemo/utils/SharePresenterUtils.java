package com.example.player.a1610aplayerdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.design.widget.NavigationView;
import android.util.Log;

import com.example.player.a1610aplayerdemo.bean.LoginUserInfoBean;
import com.example.player.a1610aplayerdemo.bean.SetPasswordBean;

import java.util.HashMap;

/**
 * Created by Lmz on 2019/06/11
 *  创建 sp 工具类
 */
public class SharePresenterUtils {
   private static SharedPreferences sp;
   private static LoginUserInfoBean.DataBean bean;
   public static  void init(Context context){
       sp =context.getSharedPreferences(Constans.YX_USER,Context.MODE_PRIVATE);
        bean= new LoginUserInfoBean().getData();
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

    /**
     * 保存对象
     */
    public static void saveUserInfo(LoginUserInfoBean user){
        bean = user.getData();
    }
    public static void saveUserInfo2(SetPasswordBean.DataBean data){

        String avatar = data.getAvatar();
        Log.d("avatar",avatar);
        String nickName = data.getNickName();
        Log.d("avatar","nickName"+ nickName);
        Log.d("avatar",bean.getAvatar());
        bean.setAvatar(avatar);
        Log.d("avatar","bean:"+bean.getAvatar());
    }
    public static LoginUserInfoBean.DataBean getUserInfo(){
        return bean;
    }


    public static HashMap<String, String> getHeardData(){
        HashMap<String,String> map =new HashMap<>();
        map.put("DeviceKey", PhoneUtils.getDeviceKye());
        int sdkInt = Build.VERSION.SDK_INT;
        String sdk = "" + sdkInt;
        map.put("Android-VersionCode","43");
        map.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
        map.put("Tingyun_Process","true");
        map.put("Cache-Control","max-age=604800000");
        map.put("Android-channel","guoyun");
        map.put("User-Agent","Dalvik/2.1.0 (Linux; U; Android 6.0.1; MI 6 Build/V417IR)");
        return map;
    }
}
