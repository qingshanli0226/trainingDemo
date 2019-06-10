package com.example.player.a1610aplayerdemo.net

import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitCreatorS {
    var netApiService: NetApiService? = null


    fun getApiService(): NetApiService? {
        if (netApiService == null) {
            createApiService()
        }

        return netApiService
    }

    private fun createApiService() {

        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(true)  // (Optional) Whether to show thread info or not. Default true
            .methodCount(2)         // (Optional) How many method line to show. Default 2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag("SXZ")
            .build()

        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))

        val httpLoggingInterceptor = HttpLoggingInterceptor(mvlogger)
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //确保service方法，返回值是Observable.
            .addConverterFactory(GsonConverterFactory.create()) //数据解析
            .client(okHttpClient) //okhttpclient
            .baseUrl("") //base url
            .build()

        netApiService = retrofit.create(NetApiService::class.java)
    }

    var mvlogger: HttpLoggingInterceptor.Logger = HttpLoggingInterceptor.Logger { message ->
        if (message.startsWith("[") || message.startsWith("{")) {
            Logger.json(message)
        } else {
            Logger.d(message)
        }
    }
}