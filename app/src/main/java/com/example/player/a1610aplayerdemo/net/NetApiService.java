package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.curriculum.bean.BannerBean;
import com.example.player.a1610aplayerdemo.curriculum.bean.Bean;
import com.example.player.a1610aplayerdemo.mistake.ResEntity;
import com.example.player.a1610aplayerdemo.my.bean.AuthCode;
import com.example.player.a1610aplayerdemo.my.bean.Feedback;
import com.example.player.a1610aplayerdemo.my.bean.PwdBean;
import com.example.player.a1610aplayerdemo.my.bean.UserBean;
import com.example.player.a1610aplayerdemo.study.bean.VipBean;
import com.example.player.a1610aplayerdemo.token.TokenBean;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface NetApiService {
    @GET
    Observable<ResEntity<Bean>> getBeanData(@Url String string);

    @POST("restapi/account/createNew")
    Observable<TokenBean> getToken(@QueryMap Map<String,String> map);

    @GET
    Observable<ResEntity<List<VipBean>>> getVipBeanData(@Url String string);

    @POST("restapi/app/setFeedback")
    Observable<ResEntity<Feedback>> getFeedback(@QueryMap Map<String,String> map);

    @GET("restapi/course/getVideo2")
    Observable<ResEntity<BannerBean>> getBannerData(@QueryMap Map<String,String> map);

    @POST("restapi/account/signIn")
    Observable<ResEntity<UserBean>> getUserData(@QueryMap Map<String,String> map);

    @POST("restapi/account/getValidCode")
    Observable<AuthCode> getAuthCodeData(@QueryMap Map<String,String> map);

    @POST("restapi/account/checkValidCode")
    Observable<AuthCode> getAuthCodeDataTwo(@QueryMap Map<String,String> map);

    @POST("restapi/account/signUp")
    Observable<ResEntity<PwdBean>> getPwdData(@QueryMap Map<String,String> map);
}
