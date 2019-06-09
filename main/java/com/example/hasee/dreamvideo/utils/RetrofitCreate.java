package com.example.hasee.dreamvideo.utils;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lmz on 2019/06/09
 *  网络获取工具类
 */
public class RetrofitCreate {
    private static ApiUtils apiUtils;

    public RetrofitCreate() {
        //单例
        if (apiUtils == null){
            synchronized (ApiUtils.class){
                if (apiUtils==null){
                    getUriService();
                }
            }
        }
    }

    public static ApiUtils getUriService(){
        OkHttpClient okHttpClient =new OkHttpClient.Builder()
                .readTimeout(3000, TimeUnit.SECONDS)
                .connectTimeout(3000,TimeUnit.SECONDS)
                .build();

        Retrofit retrofit =new Retrofit.Builder()
                            .baseUrl("https://v1.itooi.cn/tencent/")
                            .client(okHttpClient)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
        apiUtils = retrofit.create(ApiUtils.class);
        return apiUtils;
    }
}
