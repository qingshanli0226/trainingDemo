package com.example.player.a1610aplayerdemo.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.PropertyResourceBundle;
import java.util.concurrent.TimeUnit;

public class RetrofitCreator {
    private static RetrofitCreator retrofitCreator = new RetrofitCreator();
    private RetrofitApiService retrofitApiService;
    public static RetrofitCreator getInstance(){
        return retrofitCreator;
    }

    public  RetrofitApiService getRetrofitApiService() {
        if (retrofitApiService == null){
            createService();
        }
        return retrofitApiService;
    }

    private void createService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("")
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }
}
