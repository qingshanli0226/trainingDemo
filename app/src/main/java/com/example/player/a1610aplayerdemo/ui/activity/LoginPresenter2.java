package com.example.player.a1610aplayerdemo.ui.activity;

import com.example.player.a1610aplayerdemo.bean.LoginUserInfoBean;
import com.example.player.a1610aplayerdemo.utils.ErrorUtils;
import com.example.player.a1610aplayerdemo.utils.MVPObervice;
import com.example.player.a1610aplayerdemo.utils.RetrofitCreate;
import com.example.player.a1610aplayerdemo.utils.SharePresenterUtils;
import com.google.gson.Gson;

import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lmz on 2019/06/17
 */
public class LoginPresenter2 {
        private LoginView loginView;

    public LoginPresenter2(LoginView loginView) {
        this.loginView = loginView;
    }

    public void LoginUser(String phone,String pwd){
        HashMap<String,String> map =new HashMap<>();
        map.put("loginName",phone);
        map.put("password",pwd);

        RetrofitCreate.getNetApiService().getDataByPost(SharePresenterUtils.getHeardData(),"account","signIn",map)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribeOn(Schedulers.io())
                                .subscribe(new MVPObervice<String>(){
                                    @Override
                                    public void onNext(String s) {
                                        super.onNext(s);
                                        Gson gson=new Gson();
                                        LoginUserInfoBean loginUserInfoBean = gson.fromJson(s, LoginUserInfoBean.class);
                                        loginView.LoginUserSuccess(loginUserInfoBean);
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        super.onError(e);
                                        loginView.LoginUserFailure(e.toString());
                                        ErrorUtils.ErrorMess(e);
                                    }
                                });
    }

    public void OnDestry(){
        if (loginView !=null){
            loginView =null;
        }
    }
}
