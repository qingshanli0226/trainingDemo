package com.example.player.a1610aplayerdemo.utils;

import android.widget.Toast;

import com.example.player.a1610aplayerdemo.MyApplication;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.net.HttpRetryException;
import java.net.SocketTimeoutException;

/**
 * Created by Lmz on 2019/06/13
 * 错误工具类
 */
public class ErrorUtils {

    public static void ErrorMess(Throwable e){
        if (e instanceof NullPointerException){
            Toast.makeText(MyApplication.getContext(), "null:"+e.toString(), Toast.LENGTH_SHORT).show();
        }else if (e instanceof HttpRetryException){
            Toast.makeText(MyApplication.getContext(), "网络访问异常:"+e.toString(), Toast.LENGTH_SHORT).show();
        }else if (e instanceof JsonParseException){
            Toast.makeText(MyApplication.getContext(), "JSON语法 :"+e.toString(), Toast.LENGTH_SHORT).show();
        }else if (e instanceof JsonSyntaxException){
            Toast.makeText(MyApplication.getContext(), "JSON解析 :"+e.toString(), Toast.LENGTH_SHORT).show();
        }else if (e instanceof SocketTimeoutException){
            Toast.makeText(MyApplication.getContext(), "网络连接超时 :"+e.toString(), Toast.LENGTH_SHORT).show();
        }else if (e instanceof IllegalStateException){
            Toast.makeText(MyApplication.getContext(), "没有开启服务器 :"+e.toString(), Toast.LENGTH_SHORT).show();
        } else{
            Toast.makeText(MyApplication.getContext(), "业务逻辑有误 :"+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
