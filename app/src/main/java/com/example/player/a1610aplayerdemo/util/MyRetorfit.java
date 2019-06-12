package com.example.player.a1610aplayerdemo.util;

import com.example.player.a1610aplayerdemo.home.persenter.TokenInterceptor;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class MyRetorfit {

    public MyService getService(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        Retrofit build = new Retrofit.Builder().baseUrl(Contants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
        MyService myService = build.create(MyService.class);

        return myService;

    }

}
