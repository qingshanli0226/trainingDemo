package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.token.SpUtils;

import java.util.HashMap;
import java.util.Map;

public class HeadParam {
    private static  Map<String,String> headMap = new HashMap<>();

    public static Map<String,String> getHeadMap (){
        String token = SpUtils.getSpUtils().getToken();
        headMap.put(Contant.CH_TOKEN,token);
        headMap.put("DeviceKey", Contant.DEVICEKEY);
        headMap.put("Android-VersionCode","43");
        headMap.put("Android-channel","guoyun");
        headMap.put("Tingyun_Process","true");
        headMap.put("Content-Type","application/x-www-form-urlencoded");
        headMap.put("charset","UTF-8");
        headMap.put("User-Agent","Dalvik/2.1.0 (Linux; U; Android 5.1.1; redmi note 3 Build/LMY47I)");

    return headMap;
    }
}
