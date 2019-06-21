package com.example.player.a1610aplayerdemo.utils;

import android.util.Log;
import android.widget.Toast;
import com.example.player.a1610aplayerdemo.MyApp;
import com.google.gson.JsonSyntaxException;
import retrofit2.HttpException;

import java.net.SocketTimeoutException;

public class ErrorUtils {
    public static void handleError(Throwable e) {
        if (e instanceof SocketTimeoutException) { //肯定是网络请求协议错误.
            Toast.makeText(MyApp.instance, "网络连接超时错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("ZYS",e.toString());
        } else if (e instanceof HttpException) {
            Toast.makeText(MyApp.instance, "网络处理错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("ZYS",e.toString());
        } else if (e instanceof JsonSyntaxException) { //json 解析错误.
            Toast.makeText(MyApp.instance, "解析Json错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("ZYS",e.toString());
        } else { //业务错误.
            Toast.makeText(MyApp.instance, "业务错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("ZYS",e.toString());
        }
    }
}
