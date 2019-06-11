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

}
