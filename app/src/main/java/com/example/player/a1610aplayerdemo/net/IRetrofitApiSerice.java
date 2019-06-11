package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.NetBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IRetrofitApiSerice {
    @GET
    Observable<NetBean> getData(@Url String url);
}
