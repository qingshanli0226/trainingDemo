package com.example.player.a1610aplayerdemo.service;

import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.bean.VipBean;
import com.example.player.a1610aplayerdemo.secondUI.bean.BannerBean;
import com.example.player.a1610aplayerdemo.secondUI.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.service.util.Contants;
import com.example.player.a1610aplayerdemo.ui.register.bean.CheckValidCodeBean;
import com.example.player.a1610aplayerdemo.ui.register.bean.VaildCodeBean;
import com.example.player.a1610aplayerdemo.ui.register.checkexists.CheckBean;
import io.reactivex.Observable;
import okhttp3.Call;
import okhttp3.RequestBody;
import retrofit2.http.*;

import java.util.HashMap;
import java.util.Map;

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


//是否已经注册
   //POST http://api.immedc.com/restapi/account/checkExists HTTP/1.1
   @POST("account/checkExists")
   @FormUrlEncoded
   Observable<CheckBean> getCheckExists(@HeaderMap HashMap<String, String> head,@FieldMap HashMap<String,String> map);

//获取验证码
   //POST http://api.immedc.com/restapi/account/getValidCode HTTP/1.1
   @POST("account/getValidCode")
   @FormUrlEncoded
   Observable<VaildCodeBean> getValidCode(@HeaderMap HashMap<String,String> head,@FieldMap HashMap<String,String> map);

//注册下一步，验证码正确
   //POST http://api.immedc.com/restapi/account/checkValidCode HTTP/1.1
   @POST("account/checkValidCode")
   @FormUrlEncoded
   Observable<CheckValidCodeBean> getCheckValidCode(@HeaderMap HashMap<String,String> head,@FieldMap HashMap<String,String> map);









//mvvm

//注册
//POST http://api.immedc.com/restapi/account/signOut HTTP/1.1
//{
//   "success" : true,
//        "message" : "",
//        "code" : "success",
//        "data" : {
//   "passportId" : 0,
//           "nickName" : "游客",
//           "avatar" : "http://ali-files.yooshow.com/app/yangyin/default.png",
//           "gender" : 0,
//           "ranking" : 0,
//           "score" : 0,
//           "login" : false
//}
//}

   //password=shanxianxian9965&loginName=18251513369&





  // POST http://api.immedc.com/restapi/account/signIn HTTP/1.1
//   {
//      "success" : true,
//           "message" : "",
//           "code" : "success",
//           "data" : {
//      "passportId" : 230309,
//              "nickName" : "18251513369",
//              "avatar" : "http://ali-files.yooshow.com/app/yangyin/default.png",
//              "gender" : 0,
//              "birthdate" : "",
//              "ranking" : 0,
//              "score" : 0,
//              "courseInfo" : {
//         "courseId" : 0,
//                 "cardId" : 0,
//                 "noPay" : false,
//                 "existCourse" : false
//      },
//      "vip" : false,
//              "login" : true
//   }
//   }


//登录----
   //http://api.immedc.com/restapi/student/getStudentInfo HTTP/1.1
//{
//   "success" : false,
//        "message" : "no user data",
//        "code" : "Unknow"
//}

//   http://api.immedc.com/restapi/student/getStudentInfo HTTP/1.1
//   {
//      "success" : true,
//           "message" : "",
//           "code" : "success",
//           "data" : {
//      "name" : "18251513369",
//              "avatar" : "http://ali-files.yooshow.com/app/yangyin/default.png",
//              "score" : 0,
//              "ranking" : 0,
//              "money" : 0.0,
//              "workCount" : 0,
//              "purchaseCount" : 0,
//              "courseCount" : 0,
//              "questionCount" : 0,
//              "isShowQuestion" : 0,
//              "purchaseAllCount" : 0,
//              "shareView" : {
//         "sharePic" : "http://ali-files.yooshow.com/app/yangyin/default-red-share.png",
//                 "shareTitle" : "【央音在线】中央音乐学院官方平台",
//                 "shareUrl" : "http://api.immedc.com/restapi/app/download",
//                 "shareContent" : "名校教育，名师领航，为您提供一站无忧式音乐教学服务。"
//      }
//   }
//   }


}
