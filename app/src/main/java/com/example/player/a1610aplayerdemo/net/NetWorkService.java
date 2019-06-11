package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.url.ResEntity;
import com.example.player.a1610aplayerdemo.discover.bean.DiscoverBean;
import io.reactivex.Observable;
import retrofit2.http.GET;


public interface NetWorkService {
    @GET("/restapi/loading/getHome")
    Observable<ResEntity<DiscoverBean>> getHomeData();
}
