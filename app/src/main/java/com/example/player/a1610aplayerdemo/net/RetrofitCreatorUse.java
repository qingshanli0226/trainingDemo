package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.Contants;
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

public class RetrofitCreatorUse {

    public static NetApiService netApiService;


    public static NetApiService getApiService() {
        if (netApiService == null) {
            createApiService();
        }

        return netApiService;
    }

    private static void createApiService() {

        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)
                .methodCount(2)
                .methodOffset(7)
                .tag("SXZ")
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(mvlogger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1000, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new TokenInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //确保service方法，返回值是Observable.
                .addConverterFactory(StringConverterFactory.create()) //数据解析
                .client(okHttpClient) //okhttpclient
                .baseUrl(Contants.BASE_URL) //base url
                .build();

        netApiService = retrofit.create(NetApiService.class);
    }

    public static HttpLoggingInterceptor.Logger mvlogger = new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            if (message.startsWith("[")|| message.startsWith("{")){
                Logger.json(message);
            }else {
                Logger.d(message);
            }

        }
    };
}
