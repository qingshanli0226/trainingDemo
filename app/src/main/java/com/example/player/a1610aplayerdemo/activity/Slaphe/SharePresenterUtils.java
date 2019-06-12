package com.example.player.a1610aplayerdemo.activity.Slaphe;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.player.a1610aplayerdemo.Contants;

public class SharePresenterUtils {
//    public void saveToken
    private static SharedPreferences sharedPreferences;
    public static void init(Context context){
        sharedPreferences=context.getSharedPreferences(Contants.USER,Context.MODE_PRIVATE);
    }
    public static void saveToke(String token){
        sharedPreferences.edit().putString(Contants.TOKEN,token).commit();
    }

    public static String getToken(){
        String token=sharedPreferences.getString(Contants.TOKEN,"");
        return token;
    }

    public static void saveAvater(String imgUri){
        sharedPreferences.edit().putString(Contants.USER_AVATER,imgUri).commit();
    }

    public static String getAvater(){
        return sharedPreferences.getString(Contants.USER_AVATER,"");
    }
}
