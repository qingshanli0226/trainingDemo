package com.example.player.a1610aplayerdemo.utils;

import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lmz on 2019/06/11
 *
 */
public class RetrofitCreate {

    private static NetApiService netApiService;

    public static NetApiService getNetApiService() {
        if (netApiService==null){
            synchronized (NetApiService.class){
                if (netApiService==null){
                    CreateApi();
                }
            }
        }
        return netApiService;
    }

    private static NetApiService CreateApi(){

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)//是否显示线程的信息，默认就是显示
                .methodCount(3)//设置显示方法的行数
                .methodOffset(7)//隐藏内部方法的调用
                .tag("Shopping")// 标记
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));//初始化，配置了Log.的 打印策略
        HttpLoggingInterceptor httpLoggingInterceptor =new HttpLoggingInterceptor(ShoppingLog);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);  //输出全部的信息


        OkHttpClient client =new OkHttpClient.Builder()
                            .connectTimeout(3000, TimeUnit.SECONDS)
                            .readTimeout(3000,TimeUnit.SECONDS)
                            .addInterceptor(new TokenInterceptor()) //加入token 拦截器
                            .build();
        Retrofit retrofit =new Retrofit.Builder()
                                .baseUrl(Constans.BaseUri)
                                .client(client)
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                .build();
        netApiService = retrofit.create(NetApiService.class);
        return netApiService;
    }


    //定义一个打印Log 的匿名工具类
    private static HttpLoggingInterceptor.Logger ShoppingLog=new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            if (message.startsWith("{")||message.startsWith("[")){  //判断日志信息是否是 这种括号开头的  是的话打印JSON
                Logger.json(message);
            }else { //不是的话 正常输出
                Logger.d(message);
            }
        }
    };
}
