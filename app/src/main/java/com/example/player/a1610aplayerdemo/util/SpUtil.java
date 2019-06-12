package com.example.player.a1610aplayerdemo.util;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.Contants;
import com.example.player.a1610aplayerdemo.MyApp;

public class SpUtil {

    private static final String name = "account";
    private static SharedPreferences sp;

    public static void init(Context context) {
        sp = MyApp.instance.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static void saveToken(String token) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Contants.TOKEN, token);
        editor.apply();
    }

    public static String getToken() {//读取token
        return sp.getString(Contants.TOKEN, "");
    }

}
