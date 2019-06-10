package com.example.player.a1610aplayerdemo.net;

import android.util.Log;
import android.widget.Toast;

import com.example.player.a1610aplayerdemo.MyApp;
import com.google.gson.JsonSyntaxException;

import java.net.SocketTimeoutException;

import retrofit2.HttpException;

public class ErrorUtil {
    public static void handleError(Throwable e) {
        if (e instanceof SocketTimeoutException) { //肯定是网络请求协议错误.
            Toast.makeText(MyApp.instance, "网络连接超时错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("qwe",e.toString());
        } else if (e instanceof HttpException) {
            Toast.makeText(MyApp.instance, "网络处理错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("qwe",e.toString());
        } else if (e instanceof JsonSyntaxException) { //json 解析错误.
            Toast.makeText(MyApp.instance, "解析Json错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("qwe",e.toString());
        } else { //业务错误.
            Toast.makeText(MyApp.instance, "业务错误：" + e.toString(), Toast.LENGTH_SHORT).show();
            Log.d("qwe",e.toString());
        }
    }
}
