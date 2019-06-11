package com.example.player.a1610aplayerdemo.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class CreatorRetorfitApi {

    private  volatile static IRetrofitApiSerice iRetrofitApiSerice;

    private CreatorRetorfitApi(){}

    public static IRetrofitApiSerice getiRetrofitApiSerice() {
        if(iRetrofitApiSerice == null){
            createApiService();
        }
        return iRetrofitApiSerice;
    }

    private static void createApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .addInterceptor()
                .connectTimeout(5000, TimeUnit.MICROSECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.qubaobei.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        iRetrofitApiSerice = retrofit.create(IRetrofitApiSerice.class);
    }
}
