package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.Contants;
import com.google.gson.Gson;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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

        FormatStrategy formatStrategy= PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(3)
                .methodOffset(7)
                .tag("ZYS")
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));


        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(logger);
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.SECONDS)
                .addInterceptor(loggingInterceptor)
                .addInterceptor(new TokenInterceptor())
                .build();
        Retrofit retrofit=new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Contants.BASE_URL)
                .client(okHttpClient)
                .build();
        netApiService=retrofit.create(NetApiService.class);
    }
    public static HttpLoggingInterceptor.Logger logger=new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            if (message.startsWith("{") || message.startsWith("{")) {
                Logger.json(message);
            }else {
                Logger.d(message);
            }
        }
    };
}
