package com.example.player.a1610aplayerdemo.net;

import com.example.player.a1610aplayerdemo.base.ResEntity;
import com.example.player.a1610aplayerdemo.ui.bean.Bean;
import com.example.player.a1610aplayerdemo.ui.home.bean.HomeBean;
import com.example.player.a1610aplayerdemo.ui.home_activity.categoryactivity.bean.CategoryZeroBean;
import com.example.player.a1610aplayerdemo.ui.home_activity.zllistactivity.bean.ZlListBean;
import com.example.player.a1610aplayerdemo.ui.home_activity.zllistactivity.bean.ZlListRightBean;
import com.example.player.a1610aplayerdemo.ui.member.bean.MemberBean;
import io.reactivex.Observable;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

public interface MyServiceInterface {

    @GET("loading/getHome")
    Observable<HomeBean> getData();

    //TODO Home（主页）界面数据
    @GET("loading/getHome")
    Observable<ResEntity<HomeBean.DataBean>> getHomeBean(@HeaderMap Map<String,String> map);

    /**
     *
     * @param map
     * @param id
     * @return
     * 网址http://api.immedc.com/restapi/zhuanLan/getdetail?id=20
     * 主页二级界面ZlLest数据left
     */
    @GET("zhuanLan/getdetail")
    Observable<ResEntity<ZlListBean.DataBean>> getZlListBean(@HeaderMap Map<String,String> map, @Query("id") String id);

    /**
     *
     * @param map
     * @param pid
     * @return
     * 网址http://api.immedc.com/restapi/category/getPerfesional?pid=1
     * 主页二级界面Category数据Zero
     */
    @GET("category/getPerfesional")
    Observable<ResEntity<List<CategoryZeroBean.DataBean>>> getCategroyBean(@HeaderMap Map<String,String> map,@Query("pid")String pid);

    /**
     *
     * @param map
     * @param zlId
     * @param page
     * @param size
     * @return
     * 网址http://api.immedc.com/restapi/zhuanLan/getArticleList?zlId=20&page=1&size=20
     * 主页二级界面ZlLest数据Right
     */
    @GET("zhuanLan/getArticleList")
    Observable<ResEntity<List<ZlListRightBean.DataBean>>> getZlListRightBean(@HeaderMap Map<String,String> map, @Query("zlId") String zlId, @Query("page")String page, @Query("size")String size);

    /**
     *
     * @param map
     * @param minid
     * @param size
     * @return
     * 网址http://api.immedc.com/restapi/masterPackage/getMasterPackagelist?minid=0&size=20
     * Member（会员）界面数据
     */
    @GET("masterPackage/getMasterPackagelist")
    Observable<MemberBean> getDataTwo(@HeaderMap Map<String,String> map,@Query("minid")String minid,@Query("size")String size);

    @GET("/")
    Observable<ResEntity> foo(@Header("CH-TOKEN")String lang);

    @POST("account/createNew")
    Observable<ResEntity<Bean.DataBean>> getUser(@QueryMap Map<String,String> headers);

}