package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import com.example.player.a1610aplayerdemo.bean.UserBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface IServiceApi {

    @POST
    Observable<Bean<UserBean>> getUser(@Url String url);

    /**
     * 获取主页面数据
     * @param url
     * @return
     */
    @GET
    Observable<Bean<MainBean>> getMainData(@Url String url);
}
