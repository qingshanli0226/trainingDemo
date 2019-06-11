package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.Contants;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitCreate {
    private static NetApiService netApiService;

    public static NetApiService getNetApiService() {
        if (netApiService == null) {
            createRetrofit();
        }
        return netApiService;
    }

    private static void createRetrofit() {


        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Contants.BASE_URL)
                .client(okHttpClient)
                .build();
        netApiService=retrofit.create(NetApiService.class);
    }
}
