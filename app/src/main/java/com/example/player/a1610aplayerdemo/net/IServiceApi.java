package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.bean.*;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;
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

    /**
     * 获取VIP界面的数据
     * @param map
     * @param url
     * @return
     */
    @GET
    Observable<Bean<List<VipDataBean>>> getVipData(@HeaderMap Map<String,String> map,@Url String url);

    ///restapi/student/getStudentInfo   每次更改个人信息会调用的


    /**
     * 获取VIP界面的数据
     * @param map
     * @param url
     * @return
     */
    @GET
    Observable<Bean<DetailBean>> getDetailsData(@HeaderMap Map<String,String> map, @Url String url);

}
