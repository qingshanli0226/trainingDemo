package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.MainBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IServiceApi {
    @GET
    Observable<Bean<MainBean>> getMainData(@Url String url);
}
