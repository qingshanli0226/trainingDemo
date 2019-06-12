package com.example.player.a1610aplayerdemo.activity.Slaphe;
import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.example.player.a1610aplayerdemo.MyApp;
public class PhoneUtils {
    @SuppressLint("MissingPermission")
    public static String getDeviceKey(){
        String deviceKey=null;
        TelephonyManager tm= (TelephonyManager) MyApp.instance.getSystemService(MyApp.instance.TELEPHONY_SERVICE);
        deviceKey=tm.getSimSerialNumber();
        deviceKey = Md5Utils.MD5(deviceKey);
        return deviceKey;
    }

}
