package com.example.player.a1610aplayerdemo.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;

import com.example.player.a1610aplayerdemo.MyApplication;

/**
 * Created by Lmz on 2019/06/11
 *  获取手机信息 工具类
 */
public class PhoneUtils {
    /**
     *   获取手机的key
     * @return
     */
    @SuppressLint("MissingPermission")
     public static String getDeviceKye(){
         String key = null;
         TelephonyManager tm = (TelephonyManager) MyApplication.getContext().getSystemService(Context.TELEPHONY_SERVICE);
         String simSerialNumber = tm.getSimSerialNumber();
         key = Md5Utils.MD5(simSerialNumber);
         return key;
     }
}

