package com.example.player.a1610aplayerdemo.Server;

import com.example.player.a1610aplayerdemo.common.AdvertBean;
import com.example.player.a1610aplayerdemo.common.HomeBean;
import com.example.player.a1610aplayerdemo.util.Contants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface AllServer {
    @GET(Contants.GET_ADVERT)
    Observable<AdvertBean> getAdvert();


    @GET(Contants.GET_HOME)
    Observable<HomeBean> getHomeInfo(@Header("CH-TOKEN")String token);
}
