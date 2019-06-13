package com.example.player.a1610aplayerdemo.utils;

import android.content.Context;
import android.util.Log;

import com.example.player.a1610aplayerdemo.MyApplication;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Lmz on 2019/06/13
 * 实现一个未捕获异常的类
 */
public class CrashMerss implements Thread.UncaughtExceptionHandler {
    public static final String Tag = "CrashHandler";

    //创建 crash实例
    public static CrashMerss instance;
    //上下文对象
    private MyApplication application;
    //系统默认的 ubcaughtExceptionHandler 类
    private Thread.UncaughtExceptionHandler  uncaughtExceptionHandler;
    //保证只有一个实例
    public CrashMerss(Context context) {

        application = (MyApplication) context.getApplicationContext();
        uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }
    //获取实例


    public static CrashMerss getInstance(Context context) {
        CrashMerss merss =instance;
        if (merss == null){
            synchronized (CrashMerss.class){
                if (merss == null){
                    merss =new CrashMerss(context.getApplicationContext());
                    instance =merss;
                }
            }
        }
        return merss;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        StringWriter stringWriter =new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        e.printStackTrace(printWriter);
        StringBuffer sb =new StringBuffer();
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
        String format = simpleDateFormat.format(new Date());
        sb.append("时间："+format);
        sb.append("\r\n");
        sb.append("出错线程ID："+t.getId()+"-------出错线程名称："+t.getName());
        sb.append("\r\n");
        sb.append("出错原因："+e.getMessage());
        sb.append("\r\n");
        sb.append("异常原因："+e.getCause());
        sb.append("\r\n");
        sb.append("出错的栈："+e.toString());

        StackTraceElement[] stackTrace = e.getStackTrace();
        for (int i=0;i<stackTrace.length;i++){
            sb.append("\r\n");
            sb.append("出错的行数"+(i+1)+"："+e.getStackTrace()[i]);
        }

        Log.d("lmz",sb.toString());
    }
}
