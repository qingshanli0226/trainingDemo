package com.example.player.a1610aplayerdemo.ui.my.login;

import android.util.Log;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.SignInBean;
import com.example.player.a1610aplayerdemo.bean.User;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.utils.TokenSp;
import com.example.player.a1610aplayerdemo.utils.UserSp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.Map;

public class LoginPresenter {

    private ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    public void getData(final String name, final String pwd) {
        String token = TokenSp.getInstance().getToken();
        Map<String, String> map = new HashMap<>();
        map.put("Android-channel", "guoyun");
        map.put("Android-VersionCode", "43");
        map.put("DeviceKey", Constant.DeviceKey);
        map.put("Tingyun_Process", "true");
        map.put("CH-TOKEN", token);
        map.put("User-Agent", "Dalvik/1.6.0 (Linux; U; Android 4.4.2; MI 6  Build/NMF26X)");

        Map<String, String> map1 = new HashMap<>();
        map1.put(Constant.LOGIN_NAME, name);
        map1.put(Constant.PASSWORD, pwd);

        RetrofitCreator.getInstance().getIServiceApi().getLoginUserData(map, map1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bean<SignInBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Bean<SignInBean> signInBeanBean) {
                        if(signInBeanBean.isSuccess()){
                            loginView.loginSuccess(signInBeanBean.getData());
                            UserSp.getInstance().setUserSp(name,pwd);
                            String avatar = signInBeanBean.getData().getAvatar();
                            UserSp.getInstance().setUser(new User(name,avatar));
                        }else{
                            loginView.loginFail();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginView.loginError();
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    public void onDestroy(ILoginView iLoginView){
        iLoginView = null;
    }

}
