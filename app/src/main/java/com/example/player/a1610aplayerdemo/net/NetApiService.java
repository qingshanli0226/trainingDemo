package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.example.player.a1610aplayerdemo.token.TokenBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

import java.util.Map;

public interface NetApiService {
    @GET
    Observable<Bean> getBeanData(@Url String string);

    @POST("restapi/account/createNew")
    Observable<TokenBean> getToken(@QueryMap Map<String,String> map);
}
