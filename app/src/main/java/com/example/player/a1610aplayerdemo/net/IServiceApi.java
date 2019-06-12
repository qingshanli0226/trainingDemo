package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.bean.UserBean;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.Map;

public interface IServiceApi {

    @POST("/restapi/account/createNew")
    @FormUrlEncoded
    Observable<Bean<UserBean>> getUser(@HeaderMap Map<String,String> map,@FieldMap Map<String,String> map1);

    /**
     * 获取主页面数据
     * @param url
     * @return
     */
    @GET
    Observable<Bean<MainBean>> getMainData(@HeaderMap Map<String,String> map,@Url String url);
}
