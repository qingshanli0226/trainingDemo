package com.example.player.a1610aplayerdemo.fragment.Home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.player.a1610aplayerdemo.R;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewAdapter;
import com.example.player.a1610aplayerdemo.base.BaseRecyclerViewFragment;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.fragment.Home.adapter.SelectorAdapter1;
import com.example.player.a1610aplayerdemo.fragment.Home.bean.SelectorBean;
import com.example.player.a1610aplayerdemo.net.NetFunction;
import com.example.player.a1610aplayerdemo.net.ResEntity;
import com.example.player.a1610aplayerdemo.net.RetrofitCreate;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestFragment extends BaseRecyclerViewFragment<Object,View> {

    private SelectorAdapter1 adapter1=new SelectorAdapter1();


    @Override
    public IBasePresenter getPresenter() {

        return new SelectorPresent();
    }

    @Override
    public BaseRecyclerViewAdapter<Object, View> getAdapter() {

        return adapter1;
    }

    @Override
    public void onloadDataBean(Object data) {
        super.onloadDataBean(data);
        List<Object> list=new ArrayList<>();
        SelectorBean selectorBean= (SelectorBean) data;
        list.add(0,selectorBean.getHomeBanner());
//        list.add(0,selectorBean.getHomeBanner());
//        list.add(0,selectorBean.getHomeBanner());
//        list.add(0,selectorBean.getHomeBanner());
//        list.add(0,selectorBean.getHomeBanner());
    }

    private class SelectorPresent implements IBasePresenter<SelectorBean> {
        IBaseView<SelectorBean> iBaseView;
        @Override
        public void loadDataByGet() {
            RetrofitCreate.getNetApiService().getSelectorData()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeOn(Schedulers.io())
                    .map(new NetFunction<ResEntity<SelectorBean>,SelectorBean>())
                    .subscribe(new Observer<SelectorBean>(){
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(SelectorBean value) {
                            Log.d("ZYS",value.getHomeBanner().get(0).getTitle());
                            iBaseView.onloadDataBean(value);
//                            iBaseView.onLoadObject(selectBean);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }


                    });
        }

        @Override
        public void attchView(IBaseView iBaseView) {

        }

        @Override
        public void detachView() {

        }
    }
}
