package com.example.hasee.dreamvideo.utils;

import com.example.hasee.dreamvideo.bean.HomeBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Lmz on 2019/06/09
 * 网络数据接口
 */
public interface ApiUtils {
    //   https://v1.itooi.cn/tencent/mv/hot?&pageSize=20&page=0
    //home页面的网络接口
    @GET("mv/hot")
    Observable<HomeBean> getHomeDateInfo(@Query("pageSize")String pagesize,@Query("page")String page);
}
