package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.url.AllUrl;
import com.example.player.a1610aplayerdemo.url.TokenInterceptor;
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

public class NetWorkCreator {
    public static NetWorkService netWorkService;
    public static NetWorkService getNetWorkService(){
        if (netWorkService==null){
            createNetWorkService();
        }
        return netWorkService;
    }

    private static void createNetWorkService() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(2)         // (Optional) How many method line to show. Default 2
                .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
                .tag("MVPDemo")   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy)); //初始化。配置了log的打印策略.
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(mvpLogger);
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                //配置一个log拦截器，去打印网络请求。注意给它设置一个打印的级别。在这里设置是Body 级别，是打印请求所有数据。
                .addInterceptor(new TokenInterceptor())
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(50, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //确保service方法，返回值是Observable.
                .addConverterFactory(GsonConverterFactory.create()) //数据解析
                .client(okHttpClient) //okhttpclient
                .baseUrl(AllUrl.url) //base url
                .build();

        netWorkService = retrofit.create(NetWorkService.class);
    }
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
