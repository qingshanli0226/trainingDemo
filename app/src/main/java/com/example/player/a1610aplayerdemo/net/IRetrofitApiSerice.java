package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.cateactivity.Bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.selectclass.bean.SelectBean;
import com.example.player.a1610aplayerdemo.test.NetBean;
import com.example.player.a1610aplayerdemo.vip.Bean.VipBean;
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

    //获取Vip界面接口
    @GET("masterPackage/getMasterPackagelist?minid=0&size=20")
    Observable<VipBean> getVipBean();

    //获取音乐选课界面接口
    @GET("category/getPerfesional?pid=1")
    Observable<MusicClassBean> getMusicBean();
}
