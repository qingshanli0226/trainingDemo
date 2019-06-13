package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.commit.Contants;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class RetrofitCreator {

    public static MyServiceInterface myServiceInterface;

    public static MyServiceInterface getMyServiceInterface() {
        if (myServiceInterface == null){
            createApiService();
        }
        return myServiceInterface;
    }

    private static void createApiService() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .connectTimeout(50, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Contants.BASE_URL)
                .build();
        myServiceInterface = retrofit.create(MyServiceInterface.class);
    }
}