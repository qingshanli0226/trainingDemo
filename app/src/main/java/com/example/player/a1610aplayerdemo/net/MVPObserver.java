package com.example.player.a1610aplayerdemo.net;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MVPObserver<T> implements Observer<T> {

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable e) {

        Log.d("qwe",e.toString());
    }

    @Override
    public void onComplete() {

    }
}
