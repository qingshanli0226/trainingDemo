package com.example.player.a1610aplayerdemo.net;



import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class MyObServer<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public abstract void onNext(T t);

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onComplete() {

    }
}
