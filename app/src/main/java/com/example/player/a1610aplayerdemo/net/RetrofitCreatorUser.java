package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.token.TokenInterceptor;
import com.example.player.a1610aplayerdemo.token.TokenUser;
import com.example.player.a1610aplayerdemo.url.SiteUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitCreatorUser {
    public static NetApiService netApiService;

    public static NetApiService getNetApiService() {
        if(netApiService == null){
            createApiService();
        }
        return netApiService;
    }

    private static void createApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenUser())
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(SiteUrl.URL_HEAD)
                .build();

        netApiService = retrofit.create(NetApiService.class);
    }
}
