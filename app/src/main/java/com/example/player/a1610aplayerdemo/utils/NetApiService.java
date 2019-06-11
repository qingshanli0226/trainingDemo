package com.example.player.a1610aplayerdemo.utils;

import com.example.player.a1610aplayerdemo.bean.HomeBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by Lmz on 2019/06/10
 *  网络接口api
 */
public interface NetApiService {
        //  第一次进入获取token   http://api.immedc.com/restapi/account/createNew HTTP/1.1

    @POST("account/createNew")
    Observable<ResponseBody> FirstInAndGetToken(@QueryMap Map<String,String> map);

    // 引导页   http://api.immedc.com/restapi/loading/getStartBanner
    @GET("loading/getStartBanner")
    Observable<ResponseBody> getSplashInfo();

    //          http://api.immedc.com/restapi/loading/getHome   home主页
    @GET("loading/getHome")
    Observable<HomeBean> getFindInfo();

}
