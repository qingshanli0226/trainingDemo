package com.example.player.a1610aplayerdemo.net;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitCreator {

    public static NetApiService netApiService;

    public static NetApiService getApiService() {
        if (netApiService == null) {
            createApiService();
        }

        return netApiService;
    }

    private static void createApiService() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(50, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //确保service方法，返回值是Observable.
                .addConverterFactory(StringConverterFactory.create()) //数据解析
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient) //okhttpclient
                .baseUrl("http://www.qubaobei.com/ios/cf/") //base url
                .build();

        netApiService = retrofit.create(NetApiService.class);
    }


}
