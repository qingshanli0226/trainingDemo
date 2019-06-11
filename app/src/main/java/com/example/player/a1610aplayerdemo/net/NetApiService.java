package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface NetApiService {
        @GET
    Observable<SelectorBean> getSelectorData(@Url String string);
}
