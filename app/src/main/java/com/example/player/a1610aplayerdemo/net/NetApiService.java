package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
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
}
