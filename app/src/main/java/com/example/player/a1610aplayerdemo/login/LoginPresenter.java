package com.example.player.a1610aplayerdemo.login;


import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.bean.LoginTokenBean;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.util.MyRetorfit;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.*;

import java.io.IOException;

public class LoginPresenter implements BasePersenter {

    BaseView baseView;

    public LoginPresenter(BaseView baseView) {
        this.baseView = baseView;
    }

    public void getLogin(RequestBody body, String nickName, String passport){
        MyService service = new MyRetorfit().getService();
        service.getLogin(body, nickName, passport)
               .enqueue(new Callback() {
                   @Override
                   public void onFailure(Call call, IOException e) {

                   }

                   @Override
                   public void onResponse(Call call, Response response) throws IOException {
                         ResponseBody loginTokenBean=response.body();
                   }
               });




    }



    @Override
    public void getData() {

    }

    @Override
    public void destoryView() {

    }


}
