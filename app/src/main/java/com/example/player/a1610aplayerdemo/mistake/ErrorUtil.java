package com.example.player.a1610aplayerdemo.mistake;

import android.widget.Toast;
import com.example.player.a1610aplayerdemo.MVPApplication;
import com.google.gson.JsonSyntaxException;
import retrofit2.HttpException;

import java.net.SocketTimeoutException;

public class ErrorUtil {
    public static void handleError(Throwable e) {
        if (e instanceof SocketTimeoutException) { //肯定是网络请求协议错误.
            Toast.makeText(MVPApplication.instance, "网络连接超时错误：" + e.toString(), Toast.LENGTH_SHORT).show();
        } else if (e instanceof HttpException) {
            Toast.makeText(MVPApplication.instance, "网络处理错误：" + e.toString(), Toast.LENGTH_SHORT).show();
        } else if (e instanceof JsonSyntaxException) { //json 解析错误.
            Toast.makeText(MVPApplication.instance, "解析Json错误：" + e.toString(), Toast.LENGTH_SHORT).show();
        } else { //业务错误.
            Toast.makeText(MVPApplication.instance, "业务错误：" + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
