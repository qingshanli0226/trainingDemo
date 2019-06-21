package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;
import com.example.player.a1610aplayerdemo.secondUI.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.service.util.Contants;
import io.reactivex.Observable;
import okhttp3.Call;
import okhttp3.RequestBody;
import retrofit2.http.*;

public interface MyService {

   //http://api.immedc.com/restapi/loading/getHome HTTP/1.1
   @GET(Contants.GET_HOME)
   Observable<HomeBean> getHomeInfo(@Header("TOKEN")String token);

   //http://api.immedc.com/restapi/?minid=0&size=20
   @GET(Contants.GET_VIP)
   Observable<VipBean> getVipInfo(@Query("minid")String minid,@Query("size")String size);


//http://api.immedc.com/restapi/account/signInByToken

  //http://api.immedc.com/restapi/account/signIn HTTP/1.1  游客

   @POST(Contants.GET_LOGIN)
   Call getLogin(@Body RequestBody body, @Query("nickName")String nickName, @Query("passport")String passport);


   //http://api.immedc.com/restapi/course/getVideo2?courseId=367&packageId=0   banner的二级菜单
   @GET(Contants.GET_TwoMenu)
   Observable<BannerBean> getTwoMenu(@Query("courseId")String courseId,@Query("packageId")String packageId);


   //http://api.immedc.com/restapi/category/getPerfesional?pid=1    音乐课堂
   @GET(Contants.GET_MusicClass)
   Observable<MusicClassBean> getMusicClass(@Query("pid")String pid);

    //mvvm



   // http://api.immedc.com/restapi/student/getStudentInfo HTTP/1.1 passport 230309


   //http://api.immedc.com/restapi/student/getStudentInfo HTTP/1.1
//{
//   "success" : false,
//        "message" : "no user data",
//        "code" : "Unknow"
//}



}
