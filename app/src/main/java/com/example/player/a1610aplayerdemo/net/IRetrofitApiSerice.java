package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.selectclass.SelectBean;
import com.example.player.a1610aplayerdemo.test.NetBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.HashMap;

public interface IRetrofitApiSerice {
//    @GET
    Observable<NetBean> getData(@Url String url);
    //获取用户信息接口
    @POST("account/createNew")
    Observable<ResponseBody>  getUserInfo(@QueryMap HashMap<String,String> parmas);

    //获取主界面接口
    @GET("loading/getHome")
    Observable<ResEntity<SelectBean>> getSelectBean();
}
