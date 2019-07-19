package com.example.player.a1610aplayerdemo.net;

import com.orhanobut.logger.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

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
// logger打印
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("LOGWL")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(mvpLogger);
        if (!BuildConfig.DEBUG) {//如果配置了，打印log，我们就把打印等级设置成BODY。否则的话设置成NONE，不打印log.
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new TokenInterceptor())
                .connectTimeout(50, TimeUnit.SECONDS)
            //    .addInterceptor(httpLoggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Contant.BASE_URL)
                .build();
        retrofitApiService = retrofit.create(RetrofitApiService.class);
    }

    //定义一个打印log的匿名log工具类
    private static HttpLoggingInterceptor.Logger mvpLogger = new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            if (message.startsWith("{") || message.startsWith("[")) {//这个代表着该message是json字符串.
                Logger.json(message);//使用第三方log框架打印log。打印json字符串
            } else {
                Logger.d(message);//正常打印log
            }
        }
    };
}
