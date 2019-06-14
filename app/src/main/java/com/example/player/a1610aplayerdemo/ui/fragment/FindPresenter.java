package com.example.player.a1610aplayerdemo.ui.fragment;

import android.util.Log;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.HomeBean;
import com.example.player.a1610aplayerdemo.utils.MVPObervice;
import com.example.player.a1610aplayerdemo.utils.RetrofitCreate;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Lmz on 2019/06/11
 *  发现页面presenter
 */
public class FindPresenter implements IBasePresenter<HomeBean>{
    private IBaseView iBaseView;

    @Override
    public void getData() {
        RetrofitCreate.getNetApiService().getFindInfo()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new MVPObervice<HomeBean>(){
                            @Override
                            public void onNext(HomeBean homeBean) {
                                super.onNext(homeBean);
                                System.out.println(homeBean.getMessage());
                                String simpleName = homeBean.getClass().getSimpleName();
                                iBaseView.loadDataSuccess(homeBean);
                            }

                            @Override
                            public void onError(Throwable e) {
                                super.onError(e);
                                iBaseView.loadDataFailure(101,e.toString());
                            }
                        });
    }

    @Override
    public void attachView(IBaseView<HomeBean> view) {
        iBaseView = view;
    }

    @Override
    public void detachView() {
        if (iBaseView!=null){
            iBaseView=null;
        }

    }
}
