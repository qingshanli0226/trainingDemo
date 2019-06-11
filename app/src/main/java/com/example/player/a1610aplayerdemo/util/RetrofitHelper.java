package com.example.player.a1610aplayerdemo.util;

import android.content.Context;
import com.example.player.a1610aplayerdemo.Server.AllServer;
import com.example.player.a1610aplayerdemo.Server.TokenInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitHelper {
    public static RetrofitHelper helper;
    private Context mContext;
    private Retrofit retrofit;
    private AllServer service;

    public RetrofitHelper(Context context) {
        this.mContext = context;
        init();
    }

    private void init() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();


        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(Contants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public AllServer getService(){
        service = retrofit.create(AllServer.class);
        return service;
    }

    public static RetrofitHelper getInstance(Context context){
        if(helper == null){
            helper = new RetrofitHelper(context);
        }
        return helper;
    }
}
