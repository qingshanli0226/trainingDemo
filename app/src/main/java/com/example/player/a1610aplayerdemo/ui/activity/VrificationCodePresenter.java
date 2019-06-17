package com.example.player.a1610aplayerdemo.ui.activity;

import com.example.player.a1610aplayerdemo.bean.VerificationCodeBean;
import com.example.player.a1610aplayerdemo.utils.ErrorUtils;
import com.example.player.a1610aplayerdemo.utils.MVPObervice;
import com.example.player.a1610aplayerdemo.utils.RetrofitCreate;
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.HTTP;

/**
 * Created by Lmz on 2019/06/17s
 */
public class VrificationCodePresenter {
    private String HEARD1="account";
    private String HEARD2="getValidCode";
    private String CheckCode="checkValidCode";
    private RegisterView registerView;

    public VrificationCodePresenter(RegisterView registerView) {
        this.registerView = registerView;
    }
    //获取验证码
    public void getVrificationCode(String phone,String type){
        HashMap<String,String> map = new HashMap<>();
        map.put("mobilePhone",phone);
        map.put("messageType",type);
        RetrofitCreate.getNetApiService().getDataByPost(new HashMap<String, String>(),HEARD1,HEARD2,map)
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribeOn(Schedulers.io())
                            .subscribe(new MVPObervice<String>(){
                                @Override
                                public void onError(Throwable e) {
                                    super.onError(e);
                                    registerView.getVerificationCodeFailure(101,e.toString());
                                    ErrorUtils.ErrorMess(e);
                                }

                                @Override
                                public void onNext(String s) {
                                    super.onNext(s);
                                    Gson gson =new Gson();
                                    VerificationCodeBean verificationCodeBean = gson.fromJson(s, VerificationCodeBean.class);
                                    registerView.getVerificationCodeSuccess(verificationCodeBean);
                                }
                            });

    }
    //验证手机号和验证码
    public void CheckCodeAndPhone(String phone,String code){
        HashMap<String,String> map =new HashMap<>();
        map.put("loginName",phone);
        map.put("identifyingCode",code);
      //  map.put("token", SharePresenterUtils.getToken());
        RetrofitCreate.getNetApiService().getDataByPost(new HashMap<String, String>(),HEARD1,CheckCode,map)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new MVPObervice<String>(){
                                    @Override
                                    public void onNext(String s) {
                                        super.onNext(s);
                                        Gson gson =new Gson();
                                        VerificationCodeBean verificationCodeBean = gson.fromJson(s, VerificationCodeBean.class);
                                        registerView.CommitPhoneAndCodeSuccess(verificationCodeBean);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        super.onError(e);
                                        registerView.CommitPhoneAndCodeFailure(102,e.toString());
                                        ErrorUtils.ErrorMess(e);
                                    }
                                });
    }

    public void DestroyView(){
        if (registerView!=null){
            registerView =null;
        }
    }
}
