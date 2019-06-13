package com.example.player.a1610aplayerdemo.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.example.player.a1610aplayerdemo.MyApp;

public class DeviceKye {
    @SuppressLint("MissingPermission")
    public static String getDeviceKye(){
        String deviceKey = null;
        TelephonyManager tm = (TelephonyManager) MyApp.instance.getSystemService(Context.TELEPHONY_SERVICE);
        deviceKey = tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }

}
