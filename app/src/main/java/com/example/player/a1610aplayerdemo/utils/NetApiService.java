package com.example.player.a1610aplayerdemo.utils;

import com.example.player.a1610aplayerdemo.bean.FirstInBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by Lmz on 2019/06/10
 *  网络接口api
 */
public interface NetApiService {
        //  第一次进入获取token   http://api.immedc.com/restapi/account/createNew HTTP/1.1

    @POST("account/createNew")
    Observable<FirstInBean> FirstInAndGetToken(@QueryMap Map<String,String> map);

}
