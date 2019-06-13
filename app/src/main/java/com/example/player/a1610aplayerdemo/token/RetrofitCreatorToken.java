package com.example.player.a1610aplayerdemo.token;

import com.example.player.a1610aplayerdemo.net.NetApiService;
import com.example.player.a1610aplayerdemo.url.SiteUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitCreatorToken {
    public static NetApiService netApiService;

    public static NetApiService getNetApiService() {
        if(netApiService == null){
            createApiService();
        }
        return netApiService;
    }

    private static void createApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5,TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(SiteUrl.TOKEN_URL)
                .build();

        netApiService = retrofit.create(NetApiService.class);
    }
}
