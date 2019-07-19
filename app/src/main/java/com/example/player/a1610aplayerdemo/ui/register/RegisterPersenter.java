package com.example.player.a1610aplayerdemo.ui.register;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.service.util.MyRetorfit;
import com.example.player.a1610aplayerdemo.ui.register.bean.RegisterBean;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;

public class RegisterPersenter implements BasePersenter<RegisterBean.DataBean> {
    BaseView<RegisterBean.DataBean> baseView;




    public void getCheckExistsData(HashMap head ,HashMap map){
        MyRetorfit myRetorfit = new MyRetorfit();
        myRetorfit.getService().getCheckExists(head,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }


    @Override
    public void getData() {

    }

    @Override
    public void attachview(BaseView<RegisterBean.DataBean> baseView) {
         this.baseView=baseView;
    }

    @Override
    public void destoryView() {
        baseView=null;
    }
}
