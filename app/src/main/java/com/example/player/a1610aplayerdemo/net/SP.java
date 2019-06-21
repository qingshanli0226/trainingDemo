package com.example.player.a1610aplayerdemo.net;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.MyApplication;

public class SP {
    private static SharedPreferences sp;
    static {
        sp = MyApplication.instance.getSharedPreferences("bean", Context.MODE_PRIVATE);
    }

    public static void Tokens(String token){
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(Contants.TOKEN,token);
        editor.commit();
    }

    public static String getToken(){
        return sp.getString(Contants.TOKEN,"");
    }

}