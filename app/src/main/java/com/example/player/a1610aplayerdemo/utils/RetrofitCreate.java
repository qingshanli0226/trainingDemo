package com.example.player.a1610aplayerdemo.utils;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
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
}
