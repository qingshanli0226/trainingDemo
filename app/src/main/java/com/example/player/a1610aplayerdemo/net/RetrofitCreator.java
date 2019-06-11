package com.example.player.a1610aplayerdemo.net;

import android.os.Message;
import com.example.player.a1610aplayerdemo.BuildConfig;
import com.example.player.a1610aplayerdemo.Constant;
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

public class RetrofitCreator {
    private RetrofitCreator() {
    }

    private static RetrofitCreator retrofitCreator = new RetrofitCreator();

    public static RetrofitCreator getInstance() {
        return retrofitCreator;
    }

    private IServiceApi iServiceApi;

    public IServiceApi getIServiceApi() {
        if (iServiceApi == null) {

            FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                    .showThreadInfo(true)
                    .methodOffset(7)
                    .methodOffset(2)
                    .tag("yangnan")
                    .build();
            Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);

            if(BuildConfig.LOG_DEBUG){
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            }else {
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }

            OkHttpClient client = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor)
                    .build();

            Retrofit builder = new Retrofit.Builder()
                    .baseUrl(Constant.BASE)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
            iServiceApi = builder.create(IServiceApi.class);
        }
        return iServiceApi;
    }

    private static HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            if (message.startsWith("[") || message.startsWith("{")) {
                Logger.json(message);
            } else {
                Logger.d(message);
            }
        }
    };
}
