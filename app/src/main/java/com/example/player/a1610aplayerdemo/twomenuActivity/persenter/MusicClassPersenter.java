package com.example.player.a1610aplayerdemo.twomenuActivity.persenter;

import com.example.player.a1610aplayerdemo.base.BasePersenter;
import com.example.player.a1610aplayerdemo.base.BaseView;
import com.example.player.a1610aplayerdemo.service.MyService;
import com.example.player.a1610aplayerdemo.twomenuActivity.bean.MusicClassBean;
import com.example.player.a1610aplayerdemo.util.MyRetorfit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MusicClassPersenter implements BasePersenter {

    BaseView baseView;

    public MusicClassPersenter(BaseView baseView) {
        this.baseView = baseView;
    }

    public void getMusicData(String pid){

        MyService service = new MyRetorfit().getService();
       service.getMusicClass(pid)
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new Observer<MusicClassBean>() {
                   @Override
                   public void onSubscribe(Disposable d) {

                   }

                   @Override
                   public void onNext(MusicClassBean musicClassBean) {
                       baseView.onLoadData(musicClassBean);

                   }

                   @Override
                   public void onError(Throwable e) {
                       baseView.onLoadError(120,e.toString());
                   }

                   @Override
                   public void onComplete() {

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
