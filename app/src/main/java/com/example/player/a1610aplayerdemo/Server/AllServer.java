package com.example.player.a1610aplayerdemo.Server;

import com.example.player.a1610aplayerdemo.common.AdvertBean;
import com.example.player.a1610aplayerdemo.common.HomeBean;
import com.example.player.a1610aplayerdemo.common.VedioBean;
import com.example.player.a1610aplayerdemo.util.Contants;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AllServer {
    @GET(Contants.GET_ADVERT)
    Observable<AdvertBean> getAdvert();

    @GET(Contants.GET_HOME)
    Observable<HomeBean> getHomeInfo(@Header("CH-TOKEN")String token);

    @GET(Contants.VEDIOURL)
    Observable<VedioBean> getVedioInfo(@Header("CH-TOKEN")String token,
                                       @Query("courseId")String courseId,
                                       @Query("packageId")String packageId);
}
