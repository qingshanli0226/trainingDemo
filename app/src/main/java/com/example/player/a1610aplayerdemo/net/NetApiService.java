package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.Mb2Bean;
import com.example.player.a1610aplayerdemo.fragment.MusicClass.bean.MbBean;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.example.player.a1610aplayerdemo.fragment.membre.Bean.MenmberBean;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.*;

import java.util.Map;

public interface NetApiService {
    @POST("account/createNew")
    Observable<ResponseBody> FirstInAndGetToken(@QueryMap Map<String,String> map);

    @GET("loading/getHome")
    Observable<ResEntity<SelectorBean>> getSelectorData();
    @GET("loading/getHome")
    Observable<SelectorBean> getSelectorData1();

    @GET()
//    /getMasterPackagelist?minid=0&size=20
    Observable<MenmberBean> getMemberData(@Url String s);

    @GET()
//  /getPerfesional?pid=1
    Observable<MbBean> getMbBean(@Url String s);
    @GET()
    Observable<Mb2Bean> getMb2Bean(@Url String s);
//    @GET
//    Observable<>
}
