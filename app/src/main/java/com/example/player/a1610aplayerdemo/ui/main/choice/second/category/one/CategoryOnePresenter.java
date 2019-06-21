package com.example.player.a1610aplayerdemo.ui.main.choice.second.category.one;

import android.util.Log;
import com.example.player.a1610aplayerdemo.Constant;
import com.example.player.a1610aplayerdemo.base.IBasePresenter;
import com.example.player.a1610aplayerdemo.base.IBaseView;
import com.example.player.a1610aplayerdemo.bean.Bean;
import com.example.player.a1610aplayerdemo.bean.CategoryOneBean;
import com.example.player.a1610aplayerdemo.net.RetrofitCreator;
import com.example.player.a1610aplayerdemo.utils.TokenSp;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryOnePresenter implements IBasePresenter<CategoryOneBean> {
    private IBaseView<CategoryOneBean> iBaseView;
    @Override
    public void getData() {
        String token = TokenSp.getInstance().getToken();
        Map<String, String> map = new HashMap<>();
        map.put("Android-channel", "guoyun");
        map.put("Android-VersionCode", "43");
        map.put("DeviceKey", Constant.DeviceKey);
        map.put("Tingyun_Process", "true");
        map.put("CH-TOKEN", token);
        RetrofitCreator.getInstance().getIServiceApi()
                .getCategoryOneData(map,Constant.BASE + "/restapi/category/getPerfesional?pid=1")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<Bean<List<CategoryOneBean>>, List<CategoryOneBean>>() {
                    @Override
                    public List<CategoryOneBean> apply(Bean<List<CategoryOneBean>> listBean) throws Exception {
                        return listBean.getData();
                    }
                }).subscribe(new Observer<List<CategoryOneBean>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<CategoryOneBean> categoryOneBeans) {
                iBaseView.onLoadData(categoryOneBeans);
//                Log.e("ynynyn", "onNext: "+categoryOneBeans.size());
            }

            @Override
            public void onError(Throwable e) {
//                Log.e("ynynync", "onError: "+e.toString());
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void attachView(IBaseView<CategoryOneBean> iBaseView) {
        this.iBaseView = iBaseView;

    }


    @Override
    public void detachView() {
        iBaseView = null;
    }
}
