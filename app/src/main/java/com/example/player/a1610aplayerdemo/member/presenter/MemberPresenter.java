package com.example.player.a1610aplayerdemo.member.presenter;

import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.member.bean.MemberBean;
import com.example.player.a1610aplayerdemo.net.NetWorkCreator;
import com.example.player.a1610aplayerdemo.url.NetFunction;
import com.example.player.a1610aplayerdemo.url.ResEntity;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.List;

public class MemberPresenter implements IBasePresenter<MemberBean> {
    private IBaseView iBaseView;
    @Override
    public void getData() {
        NetWorkCreator.getNetWorkService().getMemberData()
                .subscribeOn(Schedulers.io())
                .map(new NetFunction<ResEntity<List<MemberBean>>, List<MemberBean>>())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<MemberBean>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<MemberBean> memberBeans) {
                        iBaseView.onLoadData(memberBeans);
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
    public void attachView(IBaseView<MemberBean> iBaseView) {
        this.iBaseView=iBaseView;
    }

    @Override
    public void detachView() {
        iBaseView=null;
    }
}
